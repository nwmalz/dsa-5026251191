package lw03.prelab;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== Problem 1 =====");

        Scanner kml = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new LinkedList<>();
        while (kml.hasNext()) {
            String task = kml.next();
            if (task.equals("ADD")) {
                String nama = kml.nextLine().trim();
                playlist.add(nama);
            } else if (task.equals("REMOVE")) {
                String nama = kml.nextLine().trim();
                playlist.remove(nama);
            } else if (task.equals("INSERT")) {
                int index = kml.nextInt();
                String nama = kml.nextLine().trim();
                playlist.add(index, nama);
            }
        }
        kml.close();
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
        System.out.println();
        System.out.println("===== Problem 2 =====");

        Scanner kml2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new LinkedHashSet<>();
        int dupes = 0;

        while (kml2.hasNext()) {
            String nama = kml2.next();
            if (!participants.contains(nama)) {
                participants.add(nama);
            } else {
                dupes++;
            }
        }

        kml2.close();

        System.out.println("Unique participants: " + participants.size());
        int count = 1;
        for (String participant : participants) {
            System.out.println(count + ". " + participant);
            count++;
        }

        System.out.println("Duplicate registrations: " + dupes);
        System.out.println();
        System.out.println("===== Problem 3 =====");

        Scanner kml3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();

        int failCount = 0;
        while (kml3.hasNext()) {
            String type = kml3.next();
            String product = kml3.next();
            int quantity = kml3.nextInt();

            if (type.equals("ADD")) {
                if (!inventory.containsKey(product)) {
                    inventory.put(product, quantity);
                } else {
                    int stock = inventory.get(product);
                    stock = stock + quantity;
                    inventory.put(product, stock);
                }
            } else if (type.equals("SELL")) {
                if (!inventory.containsKey(product)) {
                    failCount++;
                } else {
                    int stock = inventory.get(product);
                    if (stock < quantity) {
                        failCount++;
                    } else {
                        stock = stock - quantity;
                        inventory.put(product, stock);
                    }
                }
            }
        }

        kml3.close();

        for (String item : inventory.keySet()) {
            System.out.println(item + ": " + inventory.get(item));
        }

        System.out.println("Failed sales: " + failCount);
    }
}