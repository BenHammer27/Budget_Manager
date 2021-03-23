package budget;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.00;
        boolean exit = false;
        DecimalFormat format = new DecimalFormat("0.00");
        ArrayList<Purchase> purchases = new ArrayList<>();

        do {
            System.out.println("\nChoose your action:");
            System.out.println("1) Add Income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("0) Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    exit = true;
                    System.out.println("\nBye!");
                    break;
                case 1:
                    System.out.println("\nEnter income:");
                    balance += scanner.nextDouble();
                    System.out.println("Income was added!");
                    break;
                case 2:
                    System.out.println("\nEnter purchase name:");
                    String empty = scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Enter its price:");
                    Double price = scanner.nextDouble();
                    balance -= price;
                    purchases.add(new Purchase(name, price));
                    System.out.println("Purchase was added!");
                    break;
                case 3:
                    Double total = 0.00;
                    if (purchases.size() == 0) {
                        System.out.println("\nThe purchase list ist empty");
                    } else {
                        System.out.print("\n");
                        for (int i = 0; i < purchases.size(); i++) {
                            System.out.println(purchases.get(i).name + " $" + format.format(purchases.get(i).price));
                            total += purchases.get(i).price;
                        }
                        System.out.println("Total sum: $" + format.format(total));
                    }
                    break;
                case 4:
                    if (balance < 0) {
                        balance = 0.00;
                    }
                    System.out.println("\nBalance: $" + format.format(balance));
                    break;
            }
        } while (!exit);

        /*while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(input);
            String[] inputArray = input.split(" ");
            for (int i = 0; i < inputArray.length; i++) {
                if(inputArray[i].charAt(0) == '$') {
                    //System.out.println(inputArray[i].substring(1, inputArray[i].length()));
                    balance += Double.parseDouble(inputArray[i].substring(1, inputArray[i].length()-0));
                }
            }
        }
        System.out.println("Total: $" + balance);

        */
    }
}
