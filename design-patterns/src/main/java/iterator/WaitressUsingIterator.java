package iterator;

public class WaitressUsingIterator {

    private final PancakeHouseMenuWithIterator pancakeHouseMenuWithIterator;

    private final DinerMenuWithIterator dinerMenuWithIterator;

    public WaitressUsingIterator(PancakeHouseMenuWithIterator pancakeHouseMenuWithIterator, DinerMenuWithIterator dinerMenuWithIterator) {
        this.pancakeHouseMenuWithIterator = pancakeHouseMenuWithIterator;
        this.dinerMenuWithIterator = dinerMenuWithIterator;
    }

    public void printMenu() {
        Iterator<MenuItem> pancakeHouseMenuIterator = pancakeHouseMenuWithIterator.createIterator();
        Iterator<MenuItem> dinerMenuIterator = dinerMenuWithIterator.createIterator();

        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeHouseMenuIterator);

        System.out.println("\nLUNCH");
        printMenu(dinerMenuIterator);
    }

    private void printMenu(Iterator<MenuItem> menuItemIterator) {
        while(menuItemIterator.hasNext()) {
            MenuItem menuItem = menuItemIterator.next();
            printMenuItem(menuItem);
        }
    }

    private void printMenuItem(MenuItem menuItem) {
        System.out.println(menuItem.getName() + " - " + menuItem.getPrice() + " (" + menuItem.getDescription() + ")");
    }
}
