import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();

        while (scanner.hasNext()) {
            input.add(scanner.nextInt());
        }

        int n = input.get(input.size() - 1);
        input.remove(input.size() - 1);

        int minDifference = Integer.MAX_VALUE;
        for (Integer i : input) {
            if (Math.abs(i - n) < minDifference) {
                minDifference = Math.abs(i - n);
            }
        }

        for (Integer j : input) {
            if (Math.abs(j - n) == minDifference) {
                output.add(j);
            }
        }

        Collections.sort(output);

        for (Integer k : output) {
            System.out.print(k + " ");
        }
    }
}