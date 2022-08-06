package decorator;

public abstract class Beverage {

    public enum Size {TALL, GRANDE, VENTI;}

    private Size size;

    public abstract String getDescription();

    public abstract double cost();

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size != null ? size : Size.GRANDE;
    }
}
