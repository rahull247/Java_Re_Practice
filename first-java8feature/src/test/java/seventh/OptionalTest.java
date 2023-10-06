package seventh;

/*Optional:
1) of
2) ofNullble
3) empty
4) isPresent -> Predicate
5) isPresent -> Consumer
6) get or orElse -> optional.get
7) map
8) flatMap
9) orElse, orElseGet, orElseThrow*/

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    void first_Of() {
        Person person = new Person();
        Car car = new Car();
        person.setCar(Optional.of(car));
        System.out.println(person);
    }

    @Test
    void second_OfNullable() {
        Person person = new Person();
        person.setCar(Optional.ofNullable(null));
        if(person.getCar().isPresent()) {
            System.out.println(person.getCar().get());
        }else{
            System.out.println("Car not found");
        }
    }
    @Test
    void third_empty() {
        Optional<Person> person=Optional.empty();

        System.out.println(person);
    }
    @Test
    void fourth_empty() {
        Optional<String> optional=Optional.ofNullable(null);

        System.out.println(optional.orElse("Handle null"));
    }

    private String getData(int num){
        if(num== 0){
            return "Zero";
        }

        if(num == 1)
            return "One";

        return null;
    }

    @Test
    void fifth_orElse(){
        Optional<String> dataZero = Optional.ofNullable(getData(0));
        Optional<String> dataOne = Optional.ofNullable(getData(1));
        Optional<String> dataTwo = Optional.ofNullable(getData(2));

        System.out.println(dataZero.get().length());
        System.out.println(dataOne.orElse("a").length());
        // System.out.println(dataTwo.get().length());
    }

    private void process(Optional<String> stringOptional){
        String otherString = stringOptional
                .filter(s -> s.length() > 3)
                .map(s -> s.toUpperCase())
                .orElse("other string");


        //String a = optionalS.orElse("a");
        System.out.println("String:"+ otherString);
    }
    @Test
    void sixth_map(){
        process(Optional.ofNullable(getData(0)));
        process(Optional.ofNullable(getData(1)));
        process(Optional.ofNullable(getData(2)));
    }


}

