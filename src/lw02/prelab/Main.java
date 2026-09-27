package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner kml = new Scanner(Main.class.getResourceAsStream("transaction.txt"));

            LinkedList<String[]> transactions = new LinkedList<>();
            LinkedList<String[]> customerRecords = new LinkedList<>();
            Queue<String[]> qTransac = new LinkedList<>();
            Stack<String[]> withdrawFail = new Stack<>();

            while (kml.hasNextLine()) {
                String line = kml.nextLine();
                String[] pisah = line.split(" ");

                boolean sudahAda = false;
                for (String[] c : customerRecords) {
                    if (c[0].equals(pisah[0])) {
                        sudahAda = true;
                    }
                }
                if (!sudahAda) {
                    customerRecords.add(new String[]{pisah[0], "0"});
                }

                transactions.add(pisah);
            }

        kml.close();

        for (String[] t : transactions) {
            qTransac.add(t);
        }

            while (!qTransac.isEmpty()) {
                String[] transaksi = qTransac.poll();
                String nama = transaksi[0];
                String tipe = transaksi[1];
                int jumlah = Integer.parseInt(transaksi[2]);

                for (String[] customer : customerRecords) {
                    if (customer[0].equals(nama)) {
                        int saldo = Integer.parseInt(customer[1]);

                        if (tipe.equals("DEPOSIT")) {
                            saldo = saldo + jumlah;
                            customer[1] = String.valueOf(saldo);
                        } else if (tipe.equals("WITHDRAW")) {
                            if (jumlah > saldo) {
                                withdrawFail.push(transaksi);
                            } else {
                                saldo = saldo - jumlah;
                                customer[1] = String.valueOf(saldo);
                            }
                        }
                    }
                }
            }

        System.out.println("=== Final Balances ===");

        for (String[] customer : customerRecords) {
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println("=== Failed Transactions ===");

        while (!withdrawFail.isEmpty()) {
            String[] gagal = withdrawFail.pop();
            System.out.println(gagal[0] + " " + gagal[1] + " " + gagal[2]);
        }
    }
}