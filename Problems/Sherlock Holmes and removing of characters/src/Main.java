import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1RAW = scanner.nextLine();
        String input1 = input1RAW.toLowerCase();
        String input2RAW = scanner.nextLine();
        String input2 = input2RAW.toLowerCase();

        char[] total = (input1 + input2).toCharArray();
        Arrays.sort(total);

        Map<Character, Integer> totalMap = new HashMap<>();
        Map<Character, Integer> same = new HashMap<>();

        for (int i = 0; i < total.length; i++) {
            char next = total[i];
            int counterTotal = 0;
            int counterInput1 = 0;
            int counterInput2 = 0;

            for (int j = i; j < total.length; j++) {
                if (total[j] == next) {
                    counterTotal++;
                }
            }
            for (int j = 0; j < input1.length(); j++) {
                if (input1.charAt(j) == next) {
                    counterInput1++;
                }
            }
            for (int j = 0; j < input2.length(); j++) {
                if (input2.charAt(j) == next) {
                    counterInput2++;
                }
            }
            totalMap.putIfAbsent(next, counterTotal);
            same.putIfAbsent(next, Math.min(counterInput1, counterInput2));
        }

        int difference = 0;
        for (var key : same.keySet()) {
            difference += totalMap.get(key) - same.get(key) * 2;
        }
        System.out.println(difference);
    }
}