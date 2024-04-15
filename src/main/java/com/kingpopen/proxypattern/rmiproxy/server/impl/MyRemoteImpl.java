package com.kingpopen.proxypattern.rmiproxy.server.impl;

import com.kingpopen.proxypattern.rmiproxy.MyRemote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 远程接口实现
 * @date 2024/03/19 22:25:20
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

  public MyRemoteImpl() throws RemoteException {
  }

  @Override
  public String sayHello() throws RemoteException {
    return "Server says, 'Hey'";
  }
}
