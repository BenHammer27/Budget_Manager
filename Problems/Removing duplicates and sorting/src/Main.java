import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> input = new HashSet<>();
        int size = scanner.nextInt();
        while (scanner.hasNext()){
            input.add(scanner.nextLine());
        }
        SortedSet<String> output = new TreeSet<>(input);
        output.forEach(System.out::println);
    }
}