import java.util.Arrays;
import java.util.List;

public class StreamTraining {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> filteredNum = numbers.stream()
                .filter(StreamTraining::selectPositive)
                .filter(StreamTraining::selectEven)
                .map(StreamTraining::pow)
                .map(StreamTraining::modifyToText)
                .toList();
        System.out.println(filteredNum);


    }

    public static boolean selectPositive(Integer x) {
        return x > 0;
    }

    public static boolean selectEven(Integer x) {
        return x % 2 == 0;
    }

    public static Integer pow(Integer x) {
        return (int) Math.pow(x, 2);
    }

    public static String modifyToText(Integer x) {
        return String.format("Item: %s -> %s", (int) Math.sqrt(x), x);
    }

}