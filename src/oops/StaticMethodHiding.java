package oops;

public class StaticMethodHiding {
    public static void main(String[] args) {
        Base b = new Base();
        Base s = new SubClass();
        b.func1(); // func1 of Base class
        s.func1(); // func1 of Base class

        b.func2(); // func2 of Base class
        s.func2(); // func2 of SubClass class
    }
}

class Base {
    public static void func1(){
        System.out.println("func1 of Base class");
    }
    public void func2(){
        System.out.println("func2 of Base class");
    }
}

class SubClass extends Base {
    public static void func1(){
        System.out.println("func1 of SubClass class");
    }
    public void func2(){
        System.out.println("func2 of SubClass class");
    }
}

