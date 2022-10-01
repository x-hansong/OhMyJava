package com.hansong.rmi.server;

/**
 * Created by xhans on 2016/5/22 0022.
 */
public interface Task<T> {
    T execute();
}
