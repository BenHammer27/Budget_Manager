package budget;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        File file = new File("purchases.txt");

        do {
            System.out.println("\nChoose your action:");
            System.out.println("1) Add Income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("5) Save");
            System.out.println("6) Load");
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
                    boolean back = false;
                    while(!back) {
                        System.out.println("\nChose the type of purchase");
                        System.out.println("1) Food");
                        System.out.println("2) Clothes");
                        System.out.println("3) Entertainment");
                        System.out.println("4) Other");
                        System.out.println("5) Back");
                        int typeChoice = scanner.nextInt();
                        String type = "";

                        switch (typeChoice){
                            case 1:
                                type = "Food";
                                break;
                            case 2:
                                type = "Clothes";
                                break;
                            case 3:
                                type = "Entertainment";
                                break;
                            case 4:
                                type = "Other";
                                break;
                            case 5:
                                back = true;
                                break;
                        }
                        if (!back) {
                            System.out.println("\nEnter purchase name:");
                            String empty = scanner.nextLine();
                            String name = scanner.nextLine();
                            System.out.println("Enter its price:");
                            Double price = scanner.nextDouble();
                            balance -= price;
                            purchases.add(new Purchase(name, price, type));
                            System.out.println("Purchase was added!");
                        }
                    }
                    break;
                case 3:
                    Double total = 0.00;
                    boolean backList = false;
                    while(!backList) {
                        System.out.println("\nChose the type of purchase");
                        System.out.println("1) Food");
                        System.out.println("2) Clothes");
                        System.out.println("3) Entertainment");
                        System.out.println("4) Other");
                        System.out.println("5) All");
                        System.out.println("6) Back");
                        int typeChoice = scanner.nextInt();
                        String type = "";

                        switch (typeChoice) {
                            case 1:
                                Double totalFood = 0.00;
                                type = "Food";
                                for (int i = 0; i < purchases.size(); i++) {
                                    if (purchases.get(i).type.equals(type)) {
                                        totalFood += purchases.get(i).price;
                                    }
                                }
                                if (totalFood == 0) {
                                    System.out.println("\nThe purchase list ist empty");
                                } else {
                                    System.out.print("\nFood:\n");
                                    for (int i = 0; i < purchases.size(); i++) {
                                        if (purchases.get(i).type.equals(type)) {
                                            System.out.println(purchases.get(i).name + " $" + format.format(purchases.get(i).price));
                                        }
                                    }
                                    System.out.println("Total sum: $" + format.format(totalFood));
                                }
                                break;
                            case 2:
                                Double totalClothes = 0.00;
                                type = "Clothes";
                                for (int i = 0; i < purchases.size(); i++) {
                                    if(purchases.get(i).type.equals(type)) {
                                        totalClothes += purchases.get(i).price;
                                    }
                                }
                                if (totalClothes == 0) {
                                    System.out.println("\nThe purchase list ist empty");
                                } else {
                                    System.out.print("\nClothes:\n");
                                    for (int i = 0; i < purchases.size(); i++) {
                                        if(purchases.get(i).type.equals(type)) {
                                            System.out.println(purchases.get(i).name + " $" + format.format(purchases.get(i).price));
                                        }
                                    }
                                    System.out.println("Total sum: $" + format.format(totalClothes));
                                }
                                break;
                            case 3:
                                Double totalEntertainment = 0.00;
                                type = "Entertainment";
                                for (int i = 0; i < purchases.size(); i++) {
                                    if(purchases.get(i).type.equals(type)) {
                                        totalEntertainment += purchases.get(i).price;
                                    }
                                }
                                if (totalEntertainment == 0) {
                                    System.out.println("\nThe purchase list ist empty");
                                } else {
                                    System.out.print("\nEntertainment\n");
                                    for (int i = 0; i < purchases.size(); i++) {
                                        if (purchases.get(i).type.equals(type)) {
                                            System.out.println(purchases.get(i).name + " $" + format.format(purchases.get(i).price));
                                        }
                                    }
                                    System.out.println("Total sum: $" + format.format(totalEntertainment));
                                }
                                break;
                            case 4:
                                Double totalOther = 0.00;
                                type = "Other";
                                for (int i = 0; i < purchases.size(); i++) {
                                    if(purchases.get(i).type.equals(type)) {
                                        totalOther += purchases.get(i).price;
                                    }
                                }
                                if (totalOther == 0) {
                                    System.out.println("\nThe purchase list ist empty");
                                } else {
                                    System.out.print("\nOther:\n");
                                    for (int i = 0; i < purchases.size(); i++) {
                                        if(purchases.get(i).type.equals(type)) {
                                            System.out.println(purchases.get(i).name + " $" + format.format(purchases.get(i).price));
                                        }
                                    }
                                    System.out.println("Total sum: $" + format.format(totalOther));
                                }
                                break;
                            case 5:
                                System.out.print("\nAll:\n");
                                for (int i = 0; i < purchases.size(); i++) {
                                    System.out.println(purchases.get(i).name + " $" + format.format(purchases.get(i).price));
                                    total += purchases.get(i).price;
                                }
                                System.out.println("Total sum: $" + format.format(total));
                                break;
                            case 6:
                                backList = true;
                                break;
                        }
                    }

                    /*if(!backList) {
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
                    }*/
                    break;
                case 4:
                    if (balance < 0) {
                        balance = 0.00;
                    }
                    System.out.println("\nBalance: $" + format.format(balance));
                    break;
                case 5:
                    try (FileWriter writer = new FileWriter(file)) {
                        writer.write("Balance: " + balance +"\n");
                        for (Purchase p : purchases) {
                            writer.write(p.name + "/" + p.price + "/" + p.type +"\n");
                        }
                    } catch (IOException e) {
                        System.out.printf("An exception occurs %s", e.getMessage());
                    }
                    System.out.println("Purchases were saved!");
                    break;
                case 6:
                    try (Scanner fileScanner = new Scanner(file)){
                        String[] balanceFile = fileScanner.nextLine().split(" ");
                        balance = Double.parseDouble(balanceFile[1]);
                        while(fileScanner.hasNext()) {
                            String[] next = fileScanner.nextLine().split("/");
                            purchases.add(new Purchase(next[0], Double.parseDouble(next[1]), next[2]));
                        }
                        System.out.println("\nr Purchases were loaded!");
                    } catch (FileNotFoundException e) {
                        System.out.println("\nFile not found");
                    }
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