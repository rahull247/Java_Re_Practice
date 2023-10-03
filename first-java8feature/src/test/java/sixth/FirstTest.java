package sixth;


/*
Exercise: 5
1) Sorting: Natrual Order Sorting, Complex Object
2) Aggregation: sum, min, max
*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FirstTest {

    @Test
    void streamInitialize() {
        Stream<String> abc = Stream.of("abc");
        Stream<String> abc1 = Stream.of("abc", "pqr", "adasd");
        List<String> list = Arrays.asList("abc", "def", "dsad");
        list.stream();
    }

    @Test //complex object sorting
    void first_userMarksSortedNameWithObjects() {

        Stream<UserMarks> userMarksStream = Stream.of(
                new UserMarks("Rahul", 21, 81, 99),
                new UserMarks("Akshay", 27, 95, 81),
                new UserMarks("Simon", 25, 73, 77),
                new UserMarks("Kunal", 23, 50, 100)
        );

        Stream<UserMarks> sorted = userMarksStream.sorted(Comparator.comparing(UserMarks::getName));
        sorted.forEach(System.out::println);
    }
    @Test//complex object sorting
    void second_userMarksSortedAgeWithObjects() {

        Stream<UserMarks> userMarksStream = Stream.of(
                new UserMarks("Rahul", 21, 81, 99),
                new UserMarks("Akshay", 27, 95, 81),
                new UserMarks("Simon", 25, 73, 77),
                new UserMarks("Kunal", 23, 50, 100)
        );

        Stream<UserMarks> sorted = userMarksStream.sorted(Comparator.comparing(UserMarks::getAge));
        sorted.forEach(System.out::println);
    }
    @Test //Natural sorting
    void third_userMarksSortedWithNameOnly() {

        Stream<UserMarks> userMarksStream = Stream.of(
                new UserMarks("Rahul", 21, 81, 99),
                new UserMarks("Akshay", 27, 95, 81),
                new UserMarks("Simon", 25, 73, 77),
                new UserMarks("Kunal", 23, 50, 100)
        );

        Stream<String> sorted = userMarksStream.map(UserMarks::getName).sorted();
        sorted.forEach(System.out::println);
    }
    @Test//Natural sorting
    void fourth_userMarksSortedWithAgeOnly() {

        Stream<UserMarks> userMarksStream = Stream.of(
                new UserMarks("Rahul", 21, 81, 99),
                new UserMarks("Akshay", 27, 95, 81),
                new UserMarks("Simon", 25, 73, 77),
                new UserMarks("Kunal", 23, 50, 100)
        );

        Stream<Integer> sorted = userMarksStream.map(UserMarks::getAge).sorted();
        sorted.forEach(System.out::println);
    }
    @Test
    void fifth_userMarksMathMarksSum() {

        Stream<UserMarks> userMarksStream = Stream.of(
                new UserMarks("Rahul", 21, 81, 99),
                new UserMarks("Akshay", 27, 95, 81),
                new UserMarks("Simon", 25, 73, 77),
                new UserMarks("Kunal", 23, 50, 100)
        );

        IntStream intStream = userMarksStream.mapToInt(UserMarks::getMathsMarks);
        int sum = intStream.sum();
        System.out.println("Sum: " + sum);
    }

    @Test
    void fifth_userMarksMathMarksMin() {

        Stream<UserMarks> userMarksStream = Stream.of(
                new UserMarks("Rahul", 21, 81, 99),
                new UserMarks("Akshay", 27, 95, 81),
                new UserMarks("Simon", 25, 73, 77),
                new UserMarks("Kunal", 23, 50, 100)
        );

        IntStream intStream = userMarksStream.mapToInt(UserMarks::getMathsMarks);
        OptionalInt min = intStream.min();
        System.out.println("min: " + min.getAsInt());
    }

    @Test
    void fifth_userMarksMathMarksMax() {

        Stream<UserMarks> userMarksStream = Stream.of(
                new UserMarks("Rahul", 21, 81, 99),
                new UserMarks("Akshay", 27, 95, 81),
                new UserMarks("Simon", 25, 73, 77),
                new UserMarks("Kunal", 23, 50, 100)
        );

        IntStream intStream = userMarksStream.mapToInt(UserMarks::getMathsMarks);
        OptionalInt max = intStream.max();
        System.out.println("max: " + max.getAsInt());
    }

}
