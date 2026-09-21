package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ngerental = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int jumlahRental = ngerental.nextInt();
    
        Rental[] rentalan = new Rental[jumlahRental];
        int[] unit = new int[jumlahRental];


        for (int i = 0; i < jumlahRental; i++) {
            String type = ngerental.next();
            String id = ngerental.next();
            int days = ngerental.nextInt();
            unit[i] = ngerental.nextInt();

            if (type.equals("LAPTOP")) {
                rentalan[i] = new LaptopRental(id, days);
            } else {
                rentalan[i] = new ProjectorRental(id, days);
            }
        }

        for (int i = 0; i < jumlahRental; i++) {
            System.out.println(rentalan[i].summary(unit[i]));
        }

        ngerental.close();
    }
}