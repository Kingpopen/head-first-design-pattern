package com.kingpopen.proxypattern.rmiproxy.server;

import com.kingpopen.proxypattern.rmiproxy.MyRemote;
import com.kingpopen.proxypattern.rmiproxy.server.impl.MyRemoteImpl;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 彭锦波
 * @project head-first-design-pattern
 * @description 服务端的运行类
 * @date 2024/03/19 22:20:13
 */
@Slf4j
public class ServerRunDemo {

  public static void main(String[] args) {
    try {
      MyRemote service = new MyRemoteImpl();
      Registry registry = LocateRegistry.createRegistry(1099);
      registry.rebind("RemoteHello", service);
      log.info("服务已启动！");
    } catch (Exception e) {
      throw new RuntimeException("MyRemoteImpl 出现异常！", e);
    }
  }
}
