import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        List<String> input = List.of(test.split(" "));
        System.out.println(input);
    }
}