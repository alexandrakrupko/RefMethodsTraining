public interface Hello {

    default String hello(String text) {
        return "Hello";
    }

    default int hello2(String text, int num) {
        return 2;
    }

    default char hello3(int num) {
        return 'h';
    }

    String hello4(String text);

}
