import java.util.Map;

public class Problem3 {
    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        env.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
