package fifth;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstStreamTest {


    @Test
    void first_traditional() {
/*
Exercise: 1
1) List of string with dummy values
2) Drop the element which does not start with Alphabet "a"
3) Convert the list of trying to uppercase
*/
        List<String> stringList = Arrays.asList("Rahul", "Akshay", "Ganesh", "Akash", "Aman");
        List<String> aNamesList = new ArrayList<>();
        for (String names : stringList) {
            if (names.startsWith("A")) {
                aNamesList.add(names.toUpperCase());
            }
        }

        System.out.println(aNamesList);

    }

    @Test
    void second_streamExample() {
 /*
    Stream API
    Intermediate Operations : filter, map, flatMap
    Terminal Operations(single for stream) - trigger the execution -collect, findAny, findFirst
 */

        System.out.println("Starting the stream");
        List<String> stringList = Arrays.asList("a", "b", "c", "a", "a");
        Stream<String> stream = stringList.stream();
        Stream<String> stringStream = stream.filter(s -> {
            System.out.println("Operation on the string: " + s);
            return s.startsWith("a");
        });
        Stream<String> stringStream1 = stringStream.map(s -> {
            System.out.println("Map on:" + s);
            return s.toUpperCase();
        });

        List<String> collect = stringStream1.collect(Collectors.toList());
        System.out.println("Result: " + collect);

        System.out.println("Ending the stream");
    }

    @Test
    void third_stream_example_of_second_test_compact_version() {
 /*
    Stream API
    Intermediate Operations : filter, map, flatMap
    Terminal Operations(single for stream) - trigger the execution -collect, findAny, findFirst
 */

        System.out.println("Starting the stream");
        List<String> stringList = Arrays.asList("a", "b", "c", "a", "a");
        Stream<String> stream = stringList.stream();
        List<String> stringStream = stream.filter(s -> s.startsWith("a"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Result: " + stringStream);
        System.out.println("Ending the stream");
    }

    @Test
    void fourth_stream() {
/*
Exercise: 3
User: id, name, age
1) List of Users with dummy values
2) Drop the Users which does not start with Alphabet "a"
3) Convert all the names of trying to uppercase
4) Final Output: List of string with uppercase names(starts with "a")
*/
        List<Users> stringList = Arrays.asList
                (new Users(1, "Rahul", 27),
                        new Users(2, "Akshay", 28),
                        new Users(3, "Ganesh", 32),
                        new Users(4, "Akash", 24),
                        new Users(5, "Aman", 21));

        List<String> aNamesList = new ArrayList<>();
        for (Users names : stringList) {
            if (names.getName().startsWith("A")) {
                aNamesList.add(names.getName().toUpperCase());
            }
        }

        System.out.println(aNamesList);

    }
}
