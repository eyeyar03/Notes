package templatemethod;

public abstract class CaffeineBeverageWithHook {

    // template method
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()) {
            addCondiments();
        }
        secretStep();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water...");
    }

    void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    final void secretStep() {
    System.out.println("Some concrete method (secret step) that cannot be overridden...");
    }

    // hook method that can be overridden by subclasses
    protected boolean customerWantsCondiments() {
        return true;
    }
}
