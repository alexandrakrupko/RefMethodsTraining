import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class LambdaTest  {

    public static void main(String[] args) {

        String[] names = {"Alex", "Aalexandra", "Yan", "Julia"};
        System.out.println("Initial array: " + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("Array after literal sort: " + Arrays.toString(names));
//        Arrays.sort(names, (first, second) -> first.length() - second.length());
        Comparator<String> comp = (f, s) -> f.length() - s.length();
        Arrays.sort(names, comp);
        System.out.println("Array after length sort: " + Arrays.toString(names));

        Comparator<String> comparator = (o1, o2) -> 0;

        Hello helloTest = (text) -> "test1";
        System.out.println("helloTest: " + helloTest);

        Runnable runnable = () -> {
            for (int i = 1; i < 6; i++)
                System.out.println(i);
        };
        runnable.run();

        Runnable runnable1 = () -> {};

        BiFunction<String, String, Integer> comp1 =
                (first, second) ->
            first.length() - second.length();

        Consumer<String> print = System.out::println;
        print.accept("Print with consumer");

        List<String> words = Arrays.asList("hello", "bye", "cat", "dog");
        forEach(words, System.out::println);



//        Arrays.sort(names, new LambdaTest());

    }
    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for(T t: list) {
            consumer.accept(t);
        }
    }
/*
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
    */

}
