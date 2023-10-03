package fifth;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondStreamTest {

    @Test
    void fifth_with_java8_stream_feature(){
        /*
Exercise: 4
User: id, name, age
1) List of Users with dummy values
2) Drop the Users which does not start with Alphabet "a"
3) Convert all the names of trying to uppercase
4) Final Output: List of string with uppercase names(starts with "a")
*/
        System.out.println("Start of the stream method");
        List<Users> usersList= Arrays.asList(new Users(1, "Rahul", 21),
                new Users(2, "Rahul", 22),
                new Users(3, "Ganesh", 23),
                new Users(4, "Kunal", 24),
                new Users(5, "Akshay", 25),
                new Users(6, "Akshay", 26));

        Stream<Users> streamUsers = usersList.stream();
        Stream<Users> filterStream = streamUsers.filter(u -> u.getName().startsWith("R"));
        Stream<String> mapStream = filterStream.map(u -> u.getName());
        Stream<String> mapOfUpperCaseStream = mapStream.map(u -> u.toUpperCase());
        Stream<String> distinct = mapOfUpperCaseStream.distinct();
        List<String> collect = distinct.collect(Collectors.toList());

        collect.forEach(System.out::println);
        System.out.println("End of the stream method");

    }

    @Test
    void sixth_with_java8_stream_feature_compact_version(){
        System.out.println("Start of the stream method");
        List<Users> usersList= Arrays.asList(new Users(1, "Rahul", 21),
                new Users(2, "Rahul", 22),
                new Users(3, "Ganesh", 23),
                new Users(4, "Kunal", 24),
                new Users(5, "Akshay", 25),
                new Users(6, "Akshay", 26));

        Stream<Users> streamUsers = usersList.stream();
          List<String> usersList1=streamUsers.filter(u -> u.getName().startsWith("R"))
                .map(u -> u.getName().toUpperCase())
                .distinct()
                .collect(Collectors.toList());


        usersList1.forEach(System.out::println);
        System.out.println("End of the stream method");

    }

    @Test
    void seven_count_names_starts_with_R(){


        System.out.println("Start of the stream method");
        List<Users> usersList= Arrays.asList(new Users(1, "Rahul", 21),
                new Users(2, "Rahul", 22),
                new Users(3, "Ganesh", 23),
                new Users(4, "Kunal", 24),
                new Users(5, "Akshay", 25),
                new Users(6, "Akshay", 26));

        Stream<Users> streamUsers = usersList.stream();
        long count=streamUsers.filter(u -> u.getName().startsWith("R"))
                .map(u -> u.getName().toUpperCase())
                .count();


        System.out.println(count);

        System.out.println("End of the stream method");

    }

    @Test
    void eight_convert_list_to_map(){
        /*
Exercise: 5
input : 1, "John", 21
Output: Map<String, Integer> map =<John, 21>
User: id, name, age
1) List of User with dummy values
2) Get a Map<String, Integer> : Map<String, Integer> map = <John, 21>
*/
        System.out.println("Start of the stream method");
        List<Users> usersList= Arrays.asList(new Users(1, "Rahul", 21),
                new Users(2, "Rahul", 22),
                new Users(3, "Ganesh", 23),
                new Users(4, "Kunal", 24),
                new Users(5, "Akshay", 25),
                new Users(6, "Akshay", 26));

        Stream<Users> streamUsers = usersList.stream();
        Map<Integer, String> map=streamUsers.filter(u -> u.getName().startsWith("R"))
                .collect(Collectors.toMap(users -> users.getId(), users -> users.getName()));


       map.forEach((key, value)-> System.out.println("Key: "+key+ ", Value: "+value));

        System.out.println("End of the stream method");

    }
}
