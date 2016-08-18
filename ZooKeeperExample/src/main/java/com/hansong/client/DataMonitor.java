package com.hansong.client;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.Code;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.Arrays;

/**
 * Created by hansong.xhs on 2016/8/18.
 */
public class DataMonitor implements Watcher, AsyncCallback.StatCallback {

    private ZooKeeper   zk;

    String              znode;

    Watcher             chainedWatcher;

    boolean             dead;

    DataMonitorListener listener;

    byte[]              preData;

    public DataMonitor(ZooKeeper zk, String znode, Watcher chainedWatcher, DataMonitorListener listener) {
        this.zk = zk;
        this.znode = znode;
        this.chainedWatcher = chainedWatcher;
        this.listener = listener;

        zk.exists(znode, true, this, null);
    }

    public void processResult(int rc, String path, Object ctx, Stat stat) {
        boolean exists;
        switch (rc) {
            case Code.Ok:
                exists = true;
                break;
            case Code.NoNode:
                exists = false;
                break;
            case Code.SessionExpired:
            case Code.NoAuth:
                dead = true;
                listener.closing(rc);
                return;
            default:
                zk.exists(znode, true, this, null);
                return;
        }
        byte[] data = null;
        if (exists) {
            try {
                data = zk.getData(znode, false, null);
            } catch (InterruptedException e) {
                return;
            } catch (KeeperException e) {
                e.printStackTrace();
            }
        }
        if ((data == null && data != preData) || (data != null && !Arrays.equals(preData, data))) {
            listener.exists(data);
            preData = data;
        }
    }

    public interface DataMonitorListener {
        void exists(byte[] data);

        void closing(int rc);
    }


    public void process(WatchedEvent watchedEvent) {
        String path = watchedEvent.getPath();
        if (watchedEvent.getType() == Event.EventType.None) {
            switch (watchedEvent.getState()) {
                case SyncConnected:
                    break;
                case Expired:
                    dead = true;
                    listener.closing(Code.SessionExpired);
                    break;
            }
        } else {
            if (path != null && path.equals(znode)) {
                zk.exists(znode, true, this, null);
            }
        }
        if (chainedWatcher != null) {
            chainedWatcher.process(watchedEvent);
        }
    }

}
