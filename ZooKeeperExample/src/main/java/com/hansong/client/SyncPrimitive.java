package com.hansong.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * Created by hansong.xhs on 2016/8/19.
 */
public class SyncPrimitive implements Watcher {

    static ZooKeeper zk = null;

    static Integer   mutex;

    String           root;

    SyncPrimitive(String address) {
        if (zk == null) {
            try {
                System.out.println("Starting ZK :");
                zk = new ZooKeeper(address, 2181, this);
                mutex = -1;
                System.out.println("Finished starting ZK: " + zk);
            } catch (IOException e) {
                e.printStackTrace();
                zk = null;
            }
        }
    }

    public synchronized void process(WatchedEvent event) {
        synchronized (mutex) {
            mutex.notify();
        }
    }

    public static class Barrier extends SyncPrimitive {
        int    size;

        String name;

        Barrier(String address, String root, int size) {
            super(address);
            this.root = root;
            this.size = size;

            if (zk != null) {
                try {
                    Stat s = zk.exists(root, false);
                    if (s == null) {
                        zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,
                            CreateMode.PERSISTENT);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (KeeperException e) {
                    e.printStackTrace();
                }
            }

            try {
                name = InetAddress.getLocalHost().getCanonicalHostName();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        boolean enter() throws KeeperException, InterruptedException {
            zk.create(root + "/" + name, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
            while (true) {
                synchronized (mutex) {
                    List<String> list = zk.getChildren(root, true);

                    if (list.size() < size) {
                        mutex.wait();
                    } else {
                        return true;
                    }
                }
            }
        }

        boolean leave() throws KeeperException, InterruptedException {
            zk.delete(root + "/" + name, 0);
            while (true) {
                synchronized (mutex) {
                    List<String> list = zk.getChildren(root, true);
                    if (list.size() > 0) {
                        mutex.wait();
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    public static class Queue extends SyncPrimitive {
        Queue(String address, String name) {
            super(address);
            this.root = name;
            // Create ZK node name
            if (zk != null) {
                try {
                    Stat s = zk.exists(root, false);
                    if (s == null) {
                        zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,
                            CreateMode.PERSISTENT);
                    }
                } catch (KeeperException e) {
                    System.out
                        .println("Keeper exception when instantiating queue: " + e.toString());
                } catch (InterruptedException e) {
                    System.out.println("Interrupted exception");
                }
            }

        }

        boolean produce(Integer i) throws KeeperException, InterruptedException {

            String path = zk.create(root + "/element", i.toString().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT_SEQUENTIAL);
            System.out.println("Produce: " + path);

            return true;
        }
    }

    int consume() throws KeeperException, InterruptedException {

        while (true) {
            synchronized (mutex) {
                List<String> list = zk.getChildren(root, true);
                if (list.size() == 0) {
                    System.out.println("Going to wait");
                    mutex.wait();
                } else {
                    Integer min = new Integer(list.get(0).substring(7));
                    String key = list.get(0);
                    for (String s : list) {
                        Integer tmp = new Integer(s.substring(7));
                        if (tmp < min) {
                            min = tmp;
                            key = s;
                        }
                    }
                    String path = root + "/" + key;
                    System.out.println("Temporary value: " + key);
                    byte[] b = zk.getData(path, false, null);
                    zk.delete(path, -1);
                    return Integer.parseInt(new String(b));
                }
            }
        }
    }

    public static void queueTest(String[] args) {
        Queue q = new Queue(args[1], "/app1");

        Integer max = new Integer(args[2]);

        if (args[3].equals("p")) {
            System.out.println("Producer");
            for (int i = 0; i < max; i++) {
                try {
                    q.produce(10 + i);
                } catch (InterruptedException e) {
                } catch (KeeperException e) {
                }
            }
        } else {
            System.out.println("Consumer");

            for (int i = 0; i < max; i++) {
                try {
                    int r = q.consume();
                    System.out.println("Item: " + r);
                } catch (InterruptedException e) {
                } catch (KeeperException e) {
                    System.out.println(e.getMessage());
                    i--;
                }
            }
        }
    }

    public static void barrierTest(String args[]) {
        Barrier b = new Barrier(args[1], "/b1", new Integer(args[2]));

        try {
            boolean flag = b.enter();
            System.out.println("Entered barrier: " + args[2]);
            if (!flag) {
                System.out.println("Error when entering the barrier");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int r = random.nextInt();
        for (int i = 0; i < r; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }

        try {
            b.leave();
        } catch (InterruptedException e) {
        } catch (KeeperException e) {
        }
        System.out.println("Left barrier");
    }

    public static void main(String args[]) {
        if (args[0].equals("qTest"))
            queueTest(args);
        else
            barrierTest(args);

    }
}
