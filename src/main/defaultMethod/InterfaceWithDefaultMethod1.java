package main.defaultMethod;

public interface InterfaceWithDefaultMethod1 {
    void abstracMethod();
    default void defaultMethod(){
        System.out.println("This is default method of InterfaceWithDefaultMethod1 interface");
    }
    static void staticMethod(){
        System.out.println("This is static method of InterfaceWithDefaultMethod1 interface");
    }
}
