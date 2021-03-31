import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt() + 1;
        int size = scanner.nextInt();
        String empty = scanner.nextLine();

        SortedMap<Integer, String> input = new TreeMap<>();

        while (scanner.hasNext()) {
            String[] next = scanner.nextLine().split(" ");
            input.put(Integer.valueOf(next[0]), next[1]);
        }

        SortedMap<Integer,String> output = input.subMap(from, to);
        for (var entry : output.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}