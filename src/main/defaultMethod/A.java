package main.defaultMethod;

public class A implements InterfaceWithDefaultMethod , InterfaceWithDefaultMethod1{

    @Override
    public void abstracMethod() {
        System.out.println("This is implemented method of InterfaceWithDefaultMethod from class A ");
    }

    @Override
    public void defaultMethod() {
        InterfaceWithDefaultMethod1.super.defaultMethod();
    }

/*    public void defaultMethod() {
        System.out.println("This override default method from class A");
    }*/
}
