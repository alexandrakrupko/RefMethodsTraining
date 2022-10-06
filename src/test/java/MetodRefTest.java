import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MetodRefTest {

    public static void main(String[] args) {

        String[] textArray = {"sara", "Dog", "Cat", "Ann"};
        Arrays.sort(textArray, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(textArray));

        Function<CharSequence, Integer> func = CharSequence::length;
        String myName = "Sasha";
        System.out.println(func.apply(myName));

        MetodRefTest.returnLength(myName);

        System.out.println(sout(myName, MetodRefTest::returnLength));




    }

    static int returnLength(String s) {
        return s.length();
    }

    public static int sout(String text, Function<String, Integer> func) {
        return func.apply(text);
    }

}
