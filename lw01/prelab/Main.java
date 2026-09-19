import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try (Scanner ngeprint = new Scanner(new File("C:\\Users\\Zephyrus\\Downloads\\ASD PRAKTIKUM\\dsa-5026251191\\lw01\\prelab\\jobs.txt"))) {
        
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
        
        } catch(FileNotFoundException e) {
            System.out.println("yahahai eror");
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
