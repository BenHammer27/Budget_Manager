import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.nextInt());
        }
        List<Integer> output = new ArrayList<>();
        for (int i = 1; i < input.size(); i += 2) {
            output.add(input.get(i));
        }

        String outputLine = " ";

        for (int j = output.size() - 1; j >= 0; j--) {
            outputLine += output.get(j) + " ";
        }

        System.out.println(outputLine.trim());
    }
}