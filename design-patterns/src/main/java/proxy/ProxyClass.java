package proxy;

public class ProxyClass implements InterfaceClass {

  private final InterfaceClass interfaceClass;

  public ProxyClass(InterfaceClass interfaceClass) {
    this.interfaceClass = interfaceClass;
  }

  @Override
  public String getMessage(String name) {
    return interfaceClass.getMessage(name) + " You're using proxy!";
  }
}
