import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static <T> boolean isStrictSuperset(Set<T> set1, Set<T> set2) {
        boolean isSuperset = true;
        for (T elem : set1) {
            if (!set2.contains(elem)) {
                isSuperset = false;
            }
        }
        if (isSuperset && set1.equals(set2)){
            isSuperset = false;
        }
        return isSuperset;
    }

    /* Please do not change the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> set1 = readStringSet(scanner);
        Set<String> set2 = readStringSet(scanner);

        System.out.println(isStrictSuperset(set1, set2));
    }

    private static Set<String> readStringSet(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toSet());
    }
}