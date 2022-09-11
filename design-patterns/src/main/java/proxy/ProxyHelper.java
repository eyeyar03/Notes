package proxy;

import java.lang.reflect.Proxy;

public class ProxyHelper {

  public static InterfaceClass getProxy(InterfaceClass interfaceClass) {
    InterfaceClass proxy = new ProxyClass(interfaceClass);

    return proxy;
  }

  public static InterfaceClass getProxyUsingApi(InterfaceClass interfaceClass) {
    InterfaceClass proxiedClass =
        (InterfaceClass)
            Proxy.newProxyInstance(
                interfaceClass.getClass().getClassLoader(),
                interfaceClass.getClass().getInterfaces(),
                new Handler(new OriginalClass()));

    return proxiedClass;
  }

  public static PersonBean getOwnerProxy(PersonBean personBean) {

    return (PersonBean)
        Proxy.newProxyInstance(
            personBean.getClass().getClassLoader(),
            personBean.getClass().getInterfaces(),
            new OwnerInvocationHandler(personBean));
  }

  public static PersonBean getNonOwnerProxy(PersonBean personBean) {
    return (PersonBean)
        Proxy.newProxyInstance(
            personBean.getClass().getClassLoader(),
            personBean.getClass().getInterfaces(),
            new NonOwnerInvocationHandler(personBean));
  }
}
