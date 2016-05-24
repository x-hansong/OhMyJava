package com.java.rmi.client;

import com.java.rmi.server.Compute;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by xhans on 2016/5/22 0022.
 */
public class ComputePi {
    public static void main(String[] args){
//        if (System.getSecurityManager() == null){
//            System.setSecurityManager(new SecurityManager());
//        }

        try{
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(1099);
            Compute compute = (Compute) registry.lookup(name);
            Pi task = new Pi(45);
            BigDecimal pi = compute.executeTask(task);

            System.out.println(pi);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
