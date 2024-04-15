package com.kingpopen.proxypattern.rmiproxy.client;

import com.kingpopen.proxypattern.rmiproxy.MyRemote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 客户端的运行类
 * @date 2024/03/19 22:54:07
 */
@Slf4j
public class ClientRunDemo {

  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      MyRemote stub = (MyRemote)registry.lookup("RemoteHello");
      log.info("远程服务返回的信息为:" + stub.sayHello());
    } catch (Exception e) {
      throw new RuntimeException("客户端出现异常！", e);
    }

  }
}
