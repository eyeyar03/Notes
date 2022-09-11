package proxy;

public class OriginalClass implements InterfaceClass {

    @Override
    public String getMessage(String name) {
        return String.format("Hello %s!", name);
    }
}
