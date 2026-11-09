
package lw04.unguided;

//saya pake 1 example aja karna pas coba ex 2 itu outputnya sama seperti di unguided

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kml = new Scanner(
            Main.class.getResourceAsStream("cards.txt"));

        int n = kml.nextInt();
        int[] angka = new int[n];

        for (int i = 0; i < n; i++) {
            angka[i] = kml.nextInt();
        }

        int jumlahCari = kml.nextInt();
        int[] angkaDicari = new int[jumlahCari];

        for (int i = 0; i < jumlahCari; i++) {
            angkaDicari[i] = kml.nextInt();
        }

        kml.close();

        sortCards(angka, 2);
        int[] hasilCari = new int[jumlahCari];

        for (int i = 0; i < jumlahCari; i++) {
            hasilCari[i] = findCard(angka, angkaDicari[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(angka[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < jumlahCari; i++) {
            if (hasilCari[i] != -1) {
                System.out.println(angkaDicari[i] + ": FOUND at index " + hasilCari[i]);
            } else {
                System.out.println(angkaDicari[i] + ": NOT FOUND");
            }
        }
    }

    static void sortCards(int[] angka, int passes) {
        int n = angka.length;

        for (int fill = 0; fill < passes; fill++) {
            int posMin = fill;

            for (int next = fill + 1; next < n; next++) {
                if (angka[next] < angka[posMin]) {
                    posMin = next;
                }
            }
            int temp = angka[fill];
            angka[fill] = angka[posMin];
            angka[posMin] = temp;
        }
    }

    static int findCard(int[] angka, int target) {
        for (int i = 0; i < angka.length; i++) {
            if (angka[i] == target) {
                return i;
            }
        }
        return -1;
    }
}