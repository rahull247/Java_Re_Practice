package third;

import org.junit.jupiter.api.Test;

import java.util.function.*;

/*
java.util.Function
1) Consumer ->  accepts an argument but returns nothing : void accept(T t)
2) Function ->  accepts an argument and returns something : R apply(T t)
3) Predicate -> accepts an arguments and returns boolean : boolean test(T t)
4) Supplier ->  accepts nothing and returns something : T get()
5) Runnable ->  accepts nothing and returns nothing : void run()
6) BiConsumer -> accepts two argument but returns nothing : void accept(T t, U u)
7) BiFunction ->  accepts two argument and returns something : R apply(T t, U u)
8) BiPredicate -> accepts two arguments and returns boolean : boolean test(T t, U u)
*/
public class UtilFunctionTests {

    @Test
    void first_PredicateString() {
        Predicate<String> predicate =
                (String str) -> str.startsWith("a") ? true : false;

        System.out.println(predicate.test("akshay"));
        System.out.println(predicate.test("rahul"));
        System.out.println(predicate.test("Akshay"));
    }

    @Test
    void second_PredicateInt() {
        Predicate<Integer> predicate = i -> {
            int remainder = i % 2;
            if (remainder == 0) return true;
            return false;
        };

        System.out.println(predicate.test(10));
        System.out.println(predicate.test(11));
        System.out.println(predicate.test(13));
    }

    @Test
    void third_ConsumerString() {
        Consumer<String> consumer = str -> {
            if (str.equals("test")) {
                System.out.println("HELLO: " + str.toUpperCase());
            } else {

                System.out.println("Hello: " + str);
            }
        };

        consumer.accept("World");
        consumer.accept("Java");
        consumer.accept("test");
    }

    @Test
    void fourth_ConsumerInt() {
        Consumer<Integer> consumer = i -> {
            if ((i % 2) == 0) {
                System.out.println("Even");
            } else {
                System.out.println("Odd");
            }
        };

        consumer.accept(5);
        consumer.accept(3);
        consumer.accept(4);
    }

    @Test
    void fifth_SupplierString() {
        Supplier<String> supplier = () -> "My String";
        Supplier<String> supplier1 = () -> "My String".toUpperCase();

        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier1.get());
    }

    @Test
    void sixth_SupplierDouble() {
        Supplier<Double> supplier = () -> Math.random();
        Supplier<Double> supplier1 = () -> Math.random();

        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier1.get());
    }

    @Test
    void seven_Function_String_String() {
        Function<String, String> stringStringFunction =
                (String str) -> {
                    System.out.println("Inside string function");
                    return str.toUpperCase();
                };

        System.out.println(stringStringFunction.apply("Hello"));
        System.out.println(stringStringFunction.apply("world"));
    }

    @Test
    void eight_Function_String_Integer() {
        Function<String, Integer> stringStringFunction =
                str -> {
                    System.out.println("Inside string function");
                    return str.length();
                };

        System.out.println(stringStringFunction.apply("Hello"));
        System.out.println(stringStringFunction.apply("world"));
    }

    @Test
    void nine_Function_Integer_Integer() {
        Function<Integer, Integer> stringStringFunction =
                i -> {
                    System.out.println("received int: " + i);
                    return i * 2;
                };

        System.out.println(stringStringFunction.apply(10));
        System.out.println(stringStringFunction.apply(100));
    }

    @Test
    void ten_Runnable() {
        Runnable runnable =
                () -> {
                    System.out.println("Printing Message");
                };

        runnable.run();
        runnable.run();
    }

    @Test
    void eleven_Runnable() {

        Runnable runnable =
                () -> {
                    int i = 1;
                    System.out.println(i++);
                };

        runnable.run();
        runnable.run();
    }

    @Test
    void twelve_BiConsumerString() {
        BiConsumer<String, String> biConsumer = (str, str2) -> {
            if (str.equalsIgnoreCase(str2)) {
                System.out.println("Both string are same");
            } else {
                System.out.println("Both string are not same");
            }
        };

        biConsumer.accept("World", "world");
        biConsumer.accept("Java", "Java 8");

    }

    @Test
    void thirteen_Function_String_String_Integer() {
        BiFunction<String, String, Integer> biFunction =
                (str, str1) -> str.equals(str1) ? 0 : 1;

        System.out.println(biFunction.apply("Hello","Hello"));
        System.out.println(biFunction.apply("world","Java"));
    }

    @Test
    void fourteen_PredicateString() {
        BiPredicate<String, String> biPredicate =
                (str, str2) -> str.startsWith(str2) ? true : false;

        System.out.println(biPredicate.test("akshay", "a"));
        System.out.println(biPredicate.test("rahul", "r"));
        System.out.println(biPredicate.test("Akshay", "a"));
    }
}


