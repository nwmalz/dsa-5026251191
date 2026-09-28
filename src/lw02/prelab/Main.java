package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customerRecords = new LinkedList<>();

        Queue<String[]> queTransac = new LinkedList<>();
        Stack<String[]> withdrawFail = new Stack<>();

        Scanner kml = new Scanner(Main.class.getResourceAsStream("transaction.txt"));

        while (kml.hasNextLine()) {
            String[] transaction = new String[3];

            transaction[0] = kml.next();
            transaction[1] = kml.next();
            transaction[2] = kml.next();

            transactions.add(transaction);
        }

        kml.close();

        queTransac.addAll(transactions);

        while (!queTransac.isEmpty()) {
            String[] transaction = queTransac.poll();

            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            String[] customer = null;

            for (String[] data : customerRecords) {
                if (data[0].equals(name)) {
                    customer = data;
                    break;
                }
            }

            if (customer == null) {
                customer = new String[]{name, "0"};
                customerRecords.add(customer);
            }

            int balance = Integer.parseInt(customer[1]);

            if (type.equals("DEPOSIT")) {
                balance += amount;
                customer[1] = String.valueOf(balance);

            } else {
                if (amount > balance) {
                    withdrawFail.push(transaction);
                } else {
                    balance -= amount;
                    customer[1] = String.valueOf(balance);
                }
            }
        }

        System.out.println("=== Final Balances ===");

        for (String[] customer : customerRecords) {
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println("=== Failed Transactions ===");

        while (!withdrawFail.isEmpty()) {
            String[] transaction = withdrawFail.pop();

            System.out.println(
                    transaction[0] + " " +
                    transaction[1] + " " +
                    transaction[2]
            );
        }
    }
}
