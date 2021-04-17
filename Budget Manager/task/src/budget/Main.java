package budget;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
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
            System.out.println("7) Analyze (Sort)");
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
                        System.out.println("\nPurchases were loaded!");
                    } catch (FileNotFoundException e) {
                        System.out.println("\nFile not found");
                    }
                    break;
                case 7:
                    boolean backAnalyze = false;
                    while(!backAnalyze) {
                        System.out.println("\nHow do you want to sort?");
                        System.out.println("1) Sort all purchases");
                        System.out.println("2) Sort by type");
                        System.out.println("3) Sort certain type");
                        System.out.println("4) Back");
                        int typeChoice = scanner.nextInt();

                        List<Purchase> Food = new ArrayList<>();
                        List<Purchase> Clothes = new ArrayList<>();
                        List<Purchase> Entertainment = new ArrayList<>();
                        List<Purchase> Other = new ArrayList<>();
                        Map<String, Double> totals = new TreeMap<>();
                        Double totalFood = 0.0;
                        Double totalClothes = 0.0;
                        Double totalEntertainment = 0.0;
                        Double totalOther = 0.0;

                        for (int i = 0; i < purchases.size(); i++) {
                            if (purchases.get(i).type.equals("Food")) {
                                Food.add(purchases.get(i));
                                totalFood += purchases.get(i).price;
                            } else if (purchases.get(i).type.equals("Clothes")) {
                                Clothes.add(purchases.get(i));
                                totalClothes += purchases.get(i).price;
                            } else if (purchases.get(i).type.equals("Entertainment")) {
                                Entertainment.add(purchases.get(i));
                                totalEntertainment += purchases.get(i).price;
                            } else if (purchases.get(i).type.equals("Other")) {
                                Other.add(purchases.get(i));
                                totalOther += purchases.get(i).price;
                            }
                        }

                        totals.put("Food", totalFood);
                        totals.put("Clothes", totalClothes);
                        totals.put("Entertainment", totalEntertainment);
                        totals.put("Other",totalOther);


                        switch (typeChoice) {
                            case 1:
                                if (purchases.isEmpty()) {
                                    System.out.println("\nThe purchase list is empty!");
                                } else {
                                    Collections.sort(purchases, new Comparator<Purchase>() {
                                        @Override
                                        public int compare(Purchase purchase, Purchase t1) {
                                            return t1.price.compareTo(purchase.price);
                                        }
                                    });
                                    System.out.println("\n All:");
                                    for (int i = 0; i < purchases.size(); i++) {
                                        System.out.println(purchases.get(i).name + " $" + format.format(purchases.get(i).price));
                                    }
                                    System.out.println("Total sum: $" + format.format(totals.get("Food") + totals.get("Clothes") + totals.get("Entertainment") + totals.get("Other")));
                                }
                                break;
                            case 2:
                                Double[] sortedTotals = {totals.get("Food"), totals.get("Clothes"), totals.get("Entertainment"), totals.get("Other")};
                                Arrays.sort(sortedTotals);
                                System.out.println("\n");
                                for (int i = sortedTotals.length - 1; i >= 0; i--) {
                                    if (sortedTotals[i] == totals.get("Food")) {
                                        System.out.println("Food - $" +format.format(sortedTotals[i]));
                                    } else if (sortedTotals[i] == totals.get("Clothes")) {
                                        System.out.println("Clothes - $" +format.format(sortedTotals[i]));
                                    } else if (sortedTotals[i] == totals.get("Entertainment")) {
                                        System.out.println("Entertainment - $" +format.format(sortedTotals[i]));
                                    } else if (sortedTotals[i] == totals.get("Other")) {
                                        System.out.println("Other - $" +format.format(sortedTotals[i]));
                                    }
                                }
                                System.out.println("Total sum: $" + format.format(totals.get("Food") + totals.get("Clothes") + totals.get("Entertainment") + totals.get("Other")));
                                break;
                            case 3:
                                System.out.println("\nChose the type of purchase");
                                System.out.println("1) Food");
                                System.out.println("2) Clothes");
                                System.out.println("3) Entertainment");
                                System.out.println("4) Other");

                                int sortChoice = scanner.nextInt();

                                switch (sortChoice) {
                                    case 1:
                                        if (Food.isEmpty()) {
                                            System.out.println("\nThe purchase list is empty!");
                                        } else {
                                            System.out.println("\nFood:");
                                            Collections.sort(Food, new Comparator<Purchase>() {
                                                @Override
                                                public int compare(Purchase purchase, Purchase t1) {
                                                    return t1.price.compareTo(purchase.price);
                                                }
                                            });
                                            for (int i = 0; i < Food.size(); i++) {
                                                System.out.println(Food.get(i).name + " $" + format.format(Food.get(i).price));
                                            }
                                            System.out.println("Total sum: $" + format.format(totals.get("Food")));
                                        }
                                        break;
                                    case 2:
                                        if (Clothes.isEmpty()) {
                                            System.out.println("\nThe purchase list is empty!");
                                        } else {
                                            System.out.println("\nClothes:");
                                            Collections.sort(Clothes, new Comparator<Purchase>() {
                                                @Override
                                                public int compare(Purchase purchase, Purchase t1) {
                                                    return t1.price.compareTo(purchase.price);
                                                }
                                            });
                                            for (int i = 0; i < Clothes.size(); i++) {
                                                System.out.println(Clothes.get(i).name + " $" + format.format(Clothes.get(i).price));
                                            }
                                            System.out.println("Total sum: $" + format.format(totals.get("Clothes")));
                                        }
                                        break;
                                    case 3:
                                        if (Entertainment.isEmpty()) {
                                            System.out.println("\nThe purchase list is empty!");
                                        } else {
                                            System.out.println("\nEntertainment:");
                                            Collections.sort(Entertainment, new Comparator<Purchase>() {
                                                @Override
                                                public int compare(Purchase purchase, Purchase t1) {
                                                    return t1.price.compareTo(purchase.price);
                                                }
                                            });
                                            for (int i = 0; i < Entertainment.size(); i++) {
                                                System.out.println(Entertainment.get(i).name + " $" + format.format(Entertainment.get(i).price));
                                            }
                                            System.out.println("Total sum: $" + format.format(totals.get("Clothes")));
                                        }
                                        break;
                                    case 4:
                                        if (Other.isEmpty()) {
                                            System.out.println("\nThe purchase list is empty!");
                                        } else {
                                            System.out.println("\nOther:");
                                            Collections.sort(Other, new Comparator<Purchase>() {
                                                @Override
                                                public int compare(Purchase purchase, Purchase t1) {
                                                    return t1.price.compareTo(purchase.price);
                                                }
                                            });
                                            for (int i = 0; i < Other.size(); i++) {
                                                System.out.println(Other.get(i).name + " $" + format.format(Other.get(i).price));
                                            }
                                            System.out.println("Total sum: $" + format.format(totals.get("Other")));
                                        }
                                        break;
                                }
                                break;
                            case 4:
                                backAnalyze = true;
                                break;
                        }
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
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
                    public int compare(K k1, K k2) {
                        int compare =
                                map.get(k2).compareTo(map.get(k1));
                        if (compare == 0)
                            return 1;
                        else
                            return compare;
                    }
                };

        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}