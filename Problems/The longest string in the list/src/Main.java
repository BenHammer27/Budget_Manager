import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        int size = 0;
        int index = 0;
        for (String s : list) {
            if(s.length() > size) {
                size = s.length();
                index = list.indexOf(s);
            }
        }
        String newWord = list.get(index);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, newWord);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}