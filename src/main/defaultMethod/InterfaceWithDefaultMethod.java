package main.defaultMethod;

public interface InterfaceWithDefaultMethod {
    void abstracMethod();
    default void defaultMethod(){
        System.out.println("This is default method of InterfaceWithDefaultMethod interface");
    }
    static void staticMethod(){
        System.out.println("This is static method of InterfaceWithDefaultMethod interface");
    }
}
