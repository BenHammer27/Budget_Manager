import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputString = scanner.nextLine().split(" ");
        int[] input = new int[inputString.length];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(inputString[i]);
        }

        int counter = 0;

        for (int j = 0; j < input.length - 1; j++) {
            for (int k = 0; k < input.length - j - 1; k++) {
                if (input[k] < input[k + 1]) {
                    int temp = input[k];
                    input[k] = input[k + 1];
                    input[k + 1] = temp;
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}