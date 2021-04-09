import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] newspaper =  scanner.nextLine().trim().split("\\s+"); //"where is money".split(" ");
        String[] message = scanner.nextLine().trim().split("\\s+"); // "Where is money".split(" ");

        Map<String, Integer> newspaperMap = new HashMap<>();
        for (int i = 0; i < newspaper.length; i++) {
            int counter = 0;
            for (int j = 0; j < newspaper.length; j++) {
                if(newspaper[i].equals(newspaper[j])) {
                    counter++;
                }
            }
            newspaperMap.putIfAbsent(newspaper[i], counter);
        }

        Map<String, Integer> messageMap = new HashMap<>();
        for (int i = 0; i < message.length; i++) {
            int counter = 0;
            for (int j = 0; j < message.length; j++) {
                if(message[i].equals(message[j])) {
                    counter++;
                }
            }
            messageMap.putIfAbsent(message[i], counter);
        }

        boolean money = true;
        for (var entry : messageMap.entrySet()) {
            if (newspaperMap.containsKey(entry.getKey())) {
                //System.out.println("message: " + entry.getValue() + " newspaper: " + newspaperMap.get(entry.getKey()));
                if (entry.getValue() > newspaperMap.get(entry.getKey())) {
                    money = false;
                }
            } else {
                money = false;
            }
        }

        if (money) {
            System.out.println("You get money");
        } else {
            System.out.println("You are busted");
        }
    }
}