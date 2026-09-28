package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> eachBook = new LinkedList<>();
        LinkedList<String[]> eachMember = new LinkedList<>();
        LinkedList<String[]> requestSuccess = new LinkedList<>();

        Queue<String[]> queRequest = new LinkedList<>();
        Stack<String[]> requestFail = new Stack<>();

        Scanner kml = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        eachBook.add(new String[]{"Kalkulus", "2"});
        eachBook.add(new String[]{"Fisika", "1"});
        eachBook.add(new String[]{"Statistika", "2"});

        while (kml.nextLine()) {
            String[] requests = new String[2]

            requests[0] = kml.next();
            requests[1] = kml.next();
            request.add(requests);

            boolean Ada = false;

            for(String[] member : eachMember) {
                if (member[0].equals(requests[0])) {
                    Ada = true;
                }
            }

            if(!Ada) {
                String[] member = new String[2];

            }
        }

        kml.close();
        
        queRequ.addAll(request);

        while (!queRequ.isEmpty()) {
            String[] requests = queRequ.poll();

            String name = requests[0];
            String  bookTitle = requests[1];
            
            String[] book = null;
            String[] member = null;
            
            for (String[] buku : eachBook){
                if(buku[0].equals(bookTitle)) {
                    book = buku;
                    break;
                }
            } 

            for (String[] anggota : eachMember) {
                if(anggota[0].equals(name)) {
                    member = anggota;
                    break;
                }
            }

            int stock = Integer.parseInt(book[1]);
            int borrowed = Integer.parseInt(member[1]);

        }
        System.out.println("=== Successfully Processed Request ===");

        for (String[] requests :) {
            System.out.println(requests[0] + " " + requests[1]);
        }

        System.out.println("=== Remaining Book Stock ===");
        for (String[] book :) {
            System.out.println(book[0] + " " + book{1});
        }
        
        System.out.println("=== Failed Requests ===");
        while (!requestFail.isEmpty()) {
            String[] requests = requestFail.pop();

            System.out.println(requests[0] + " "+ request{1});
        }
    }
    
}
