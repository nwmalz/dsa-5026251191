
package lw04.prelab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kml = new Scanner(
            Main.class.getResourceAsStream("branches.txt")
        );

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

        // Insertion Sort Descending, 3 pass
        for (int i = 1; i <= 3; i++) {
            int angkaSekarang = angka[i];
            int posisi = i - 1;

            while (posisi >= 0 && angka[posisi] < angkaSekarang) {
                angka[posisi + 1] = angka[posisi];
                posisi--;
            }

            angka[posisi + 1] = angkaSekarang;
        }

        // Menampilkan hasil sorting
        for (int i = 0; i < n; i++) {
            System.out.print(angka[i] + " ");
        }
        System.out.println();

        // Linear Search
        for (int i = 0; i < jumlahCari; i++) {
            int index = -1;

            for (int j = 0; j < n; j++) {
                if (angka[j] == angkaDicari[i]) {
                    index = j;
                    break;
                }
            }

            if (index != -1) {
                System.out.println(
                    angkaDicari[i] + ": FOUND at index " + index
                );
            } else {
                System.out.println(angkaDicari[i] + ": NOT FOUND");
            }
        }
    }
}
