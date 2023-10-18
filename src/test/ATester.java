package test;

import main.defaultMethod.A;
import main.defaultMethod.InterfaceWithDefaultMethod;

public class ATester {
    public static void main(String[] args) {
        A a= new A();
        a.abstracMethod();
        a.defaultMethod();
        InterfaceWithDefaultMethod inter =new A();
        inter.abstracMethod();
        inter.defaultMethod();
        InterfaceWithDefaultMethod.staticMethod();
    }
}
