import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordCount = scanner.nextInt();
        Set<String> words = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int i = 0; i <= wordCount; i++) {
            words.add(scanner.nextLine().toLowerCase());
        }

        int text = scanner.nextInt();
        String empty = scanner.nextLine();
        for (int j = 0; j < text; j++) {
            //String next = scanner.nextLine();
            String[] textArray = scanner.nextLine().toLowerCase().split(" ");
            for (int k = 0; k < textArray.length; k++) {
                if (!words.contains(textArray[k]) && !output.contains(textArray[k])) {
                    output.add(textArray[k]);
                }
            }
        }

        for (String s: output) {
            System.out.println(s);
        }
    }
}