import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;


public class FunctionalInterfacesTest {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Double> function1 = Math::pow;
        Function<Double, String> function2 = input -> "Result is: " + String.valueOf(input);
        Double preresult = function1.apply(2, 3);

        System.out.println("preresult is: " + preresult);

        String result = function1.andThen(function2).apply(2, 3);

        System.out.println(result);


        Predicate<Integer> predicate = intValue -> intValue > 5;
        Integer six = 6;
        System.out.println("test predicate: " + predicate.test(six));

        List<Integer> intList = Arrays.asList(1, 7, 7, 9, 10);
        List<Integer> intListAfter = intList.stream().filter(predicate).toList();
        System.out.println("List with predicate (filter): " + intListAfter);

        //try with lambda
        List<Integer> listIntAfter2 = intList.stream().filter(x -> x > 5 && x < 10).toList();
        System.out.println("2 conditions filter: " + listIntAfter2);

        Predicate<Integer> notSeven = x -> x!=7;
        Predicate<Integer> greaterThanOne = x -> x>1;
        Predicate<Integer> lessThanTen = x -> x<10;

        List<Integer> listAfterANdPredicate = intList.stream()
                .filter(notSeven
                        .and(greaterThanOne)
                        .and(lessThanTen))
                .toList();

        System.out.println("listAfterANdPredicate: " + listAfterANdPredicate);

        intList.stream()
                .filter(x -> x<10)
                .map(String::valueOf)
                .distinct()
                .map(v -> "result "+ v)
                .forEach(System.out::println);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(7);
        list1.add(5);
        list1.removeIf(x -> x == 7);
        System.out.println("list1: " + list1);


        //LocalDate catBD;
        LocalDate nullDate = null;
        //catBD =  LocalDate.of(1996, 4, 16);
        LocalDate catBD = Objects.requireNonNullElseGet(nullDate, () -> LocalDate.of(1996, 4, 16));
        System.out.println(catBD);





    }

}
