package com.java.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by xhans on 2016/5/22 0022.
 */
public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}
