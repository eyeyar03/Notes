package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler {

  private final PersonBean personBean;

  public NonOwnerInvocationHandler(PersonBean personBean) {
    this.personBean = personBean;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    final String methodName = method.getName();

    System.out.println(methodName);

    if (!methodName.equals("setHotOrNotRating") && methodName.startsWith("set")) {
      throw new IllegalAccessException();
    }

    return method.invoke(personBean, args);
  }
}
