package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private InterfaceClass interfaceClass;

    public Handler(InterfaceClass interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String message = (String) method.invoke(interfaceClass, args);

        return message + " You're using proxy!";
    }
}
