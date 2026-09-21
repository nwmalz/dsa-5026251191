package lw01.prelab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ngeprint = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
        
            PrintJob[] kerjaan = new PrintJob[100];

            int count = 0;

            while (ngeprint.hasNext()) {
                String type = ngeprint.next();
                String id = ngeprint.next();
                int pages = ngeprint.nextInt();

                if (type.equals("MONO")) {
                    kerjaan[count++] = new MonoPrint(id, pages);
                } else {
                    kerjaan[count++] = new ColourPrint(id, pages);
                } 
            
            } 

            for (int i=0;i<count;i++) {
                System.out.println(kerjaan[i].summary());
            }    
        
        ngeprint.close();
    }
    
    
}
