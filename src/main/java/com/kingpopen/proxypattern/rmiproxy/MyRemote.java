package com.kingpopen.proxypattern.rmiproxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 远程接口 这个接口是 客户端 和 服务端公用的接口
 * @date 2024/03/19 22:23:23
 */
public interface MyRemote extends Remote {
  String sayHello() throws RemoteException;
}
