import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1RAW = scanner.nextLine();
        String input1 = input1RAW.toLowerCase();
        String input2RAW = scanner.nextLine();
        String input2 = input2RAW.toLowerCase();

        Map<Character, Integer> input1Map = new HashMap<>();
        Map<Character, Integer> input2Map = new HashMap<>();

        for (int i = 0; i < input1.length(); i++) {
            char next = input1.charAt(i);
            int counter = 0;
            for (int j = i; j < input1.length(); j++) {
                if (input1.charAt(j) == next) {
                    counter++;
                }
            }
            input1Map.putIfAbsent(next, counter);
        }

        for (int i = 0; i < input2.length(); i++) {
            char next = input2.charAt(i);
            int counter = 0;
            for (int j = i; j < input2.length(); j++) {
                if (input2.charAt(j) == next) {
                    counter++;
                }
            }
            input2Map.putIfAbsent(next, counter);
        }

        boolean anagram = Objects.equals(input1Map, input2Map);
        if (anagram) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}