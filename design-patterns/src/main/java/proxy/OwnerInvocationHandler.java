package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {

  private final PersonBean personBean;

  public OwnerInvocationHandler(PersonBean personBean) {
    this.personBean = personBean;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    try {
      final String methodName = method.getName();
      System.out.println(methodName);

      if (methodName.equals("setHotOrNotRating")) {
        throw new IllegalAccessException();

      } else if (methodName.startsWith("get") || methodName.startsWith("set")) {
        return method.invoke(personBean, args);
      }

    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    return null;
  }
}
