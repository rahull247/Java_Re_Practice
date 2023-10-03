package fifth;
/*
limit(int): limit(3): Three element will be selected.
skip(int): skip(3): Three element will be skipped.
flatMap(): Flattens each generated stream into single stream.
findAny(): Return single element(generally the first element but not guaranteed).
findFirst(): Returns single element(guaranteed to return the first element).
anyMatch(Predicate): Any element that matches the predicate.
allMatch(Predicate): All elements that match the predicate.
noneMatch(Predicate): No elements in the stream match the predicate.
*/

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThirdStreamTest {

    @Test
    void first_findAny() {
        List<String> stringList = Arrays.asList("Abc", "gdks", "hgk", "yuty", "gtde");
        Optional<String> any = stringList.stream()
                .filter(s -> s.length() > 3)
                .findAny();

        System.out.println(any);
        if (any.isPresent()) {  // to check value present or not before use.
            System.out.println(any.get());
        }
    }

    @Test
    void second_flatMap() {
        List<String> stringList = Arrays.asList("lambda", "In", "Action");
        Stream<String> stream = stringList.stream();

     /* Stream<String[]> map = stream.map(w -> w.split(""));
        Stream<Stream<String>> streamStream = map.map(Arrays::stream);
        List<Stream<String>>  strings= streamStream.collect(Collectors.toList());
        strings.forEach(System.out::println);
     */

        Stream<String[]> stream1 = stream.map(w -> w.split(""));
        Stream<String> stringStream = stream1.flatMap(Arrays::stream);
        List<String> collect = stringStream.collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

    @Test
    void third_limit() {
        List<String> stringList = Arrays.asList("lambda", "In", "Action");
        Stream<String> stream = stringList.stream();
        Stream<String[]> stream1 = stream.map(w -> w.split(""));
        Stream<String> stringStream = stream1.flatMap(Arrays::stream);
        Stream<String> limit = stringStream.limit(5);
        List<String> collect = limit.collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

    @Test
    void fourth_skip() {
        List<String> stringList = Arrays.asList("lambda", "In", "Action");
        Stream<String> stream = stringList.stream();
        Stream<String[]> stream1 = stream.map(w -> w.split(""));
        Stream<String> stringStream = stream1.flatMap(Arrays::stream);
        Stream<String> limit = stringStream.limit(5);
        Stream<String> skip = limit.skip(3);
        List<String> collect = skip.collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    void fifth_anyMatch() {
        List<String> stringList = Arrays.asList("lambda", "In", "Action");
        Stream<String> stream = stringList.stream();
        boolean b = stream.anyMatch(s -> s.length() > 5);
        System.out.println("Result " + b);

    }

    @Test
    void sixth_allMatch() {
        List<String> stringList = Arrays.asList("lambda", "In", "Action");
        Stream<String> stream = stringList.stream();
        boolean b = stream.allMatch(s -> s.length() > 5);
        System.out.println("Result " + b);
    }

    @Test
    void seven_noneMatch() {
        List<String> stringList = Arrays.asList("lambda", "In", "Action");
        Stream<String> stream = stringList.stream();
        boolean b = stream.noneMatch(s -> s.length() > 5);
        System.out.println("Result " + b);
    }
    

}
