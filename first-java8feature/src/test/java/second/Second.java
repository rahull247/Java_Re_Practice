package second;

import org.junit.jupiter.api.Test;

public class Second {

    @Test
    public void first_myFunctionalInterface(){

        MyFunctionalInterface myFunctionalInterfaceConcat = (s1, s2) -> s1 + s2;

        MyFunctionalInterface myFunctionalInterfaceConcatantion = (s1, s2) -> s1.concat(s2);

        MyFunctionalInterface myFunctionalInterfaceUpperCase = ( s3,  s4) -> s3.toUpperCase() + s4.toUpperCase();

        MyFunctionalInterface myFunctionalInterfaceLowerCase = (s1, s2) -> s1.toLowerCase() + s2.toLowerCase();

        System.out.println(myFunctionalInterfaceConcat.myStringMethod("Hello", " Java!"));
        System.out.println(myFunctionalInterfaceConcatantion.myStringMethod("Hello", " Java!"));
        System.out.println(myFunctionalInterfaceUpperCase.myStringMethod("Hello", " Java!"));
        System.out.println(myFunctionalInterfaceLowerCase.myStringMethod("Hello", " Java!"));
    }

}
