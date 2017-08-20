package com.java.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by xhans on 2016/5/22 0022.
 */
public class ComputeEngine implements Compute{

    public ComputeEngine(){
        super();
    }


    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }

    public static void main(String[] args){
//        if (System.getSecurityManager() == null){
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();

            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);

            //启动RMI注册服务，指定端口为1099　（1099为默认端口）
            //也可以通过命令 ＄java_home/bin/rmiregistry 1099启动
            //这里用这种方式避免了再打开一个DOS窗口
            //而且用命令rmiregistry启动注册服务还必须事先用RMIC生成一个stub类为它所用
            Registry registry = LocateRegistry.createRegistry(1099);
            //注册对象到registry
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
