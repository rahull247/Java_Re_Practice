package fourth;

import org.junit.jupiter.api.Test;

public class ImplimentInterface {

    @Test
    void testFunctionalInterface(){
        MyFunctionalInterface myFunctionalInterface = (String str) -> str.toUpperCase();

        System.out.println(myFunctionalInterface.makeUpperCase("Hello World"));
        System.out.println(myFunctionalInterface.multiplyBy5(5));
        System.out.println(MyFunctionalInterface.concatnateString("Hello", " Java"));
    }
}