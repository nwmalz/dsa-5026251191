package lw03.unguided;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("==== Enrollment Checks ====");
        Scanner kml = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        List<String> checkResults = new ArrayList<>();
        Map<String, Integer> enrollmentMap = new LinkedHashMap<>();

        int rejectedOperations = 0;

        while(kml.hasNext()) {
            String type = kml.next();
            String courseCode = kml.next();

            if (type.equals("REGISTER")) {
                int quantity = kml.nextInt();
                if (quantity <= 0) {
                    rejectedOperations++;
                } else {
                    if (enrollmentMap.containsKey(courseCode)) {
                        int currentEnrollment = enrollmentMap.get(courseCode);
                        currentEnrollment = currentEnrollment + quantity;
                        enrollmentMap.put(courseCode, currentEnrollment);

                    } else {
                        enrollmentMap.put(courseCode, quantity);

                    }
                }

            } else if (type.equals("WITHDRAW")) {
                int quantity = kml.nextInt();

                if (quantity <= 0) {
                    rejectedOperations++;
                } else {
                    if (enrollmentMap.containsKey(courseCode)) {
                        int currentEnrollment = enrollmentMap.get(courseCode);

                        if (currentEnrollment >= quantity) {
                            currentEnrollment = currentEnrollment - quantity;
                            enrollmentMap.put(courseCode, currentEnrollment);
                            
                        } else {
                            rejectedOperations++;
                        }

                    } else {
                        rejectedOperations++;
                    }
                }

            } else if (type.equals("CHECK")) {
                if (enrollmentMap.containsKey(courseCode)) {
                    checkResults.add(courseCode + ": " + enrollmentMap.get(courseCode)+ " students");
                } else {
                    checkResults.add(courseCode + ": Not found");
                }
            }
        }

        kml.close();

        for (String result : checkResults) {
            System.out.println(result);
        }
        System.out.println();
        System.out.println("===== Final Enrollment =====");

        for (String course : enrollmentMap.keySet()) {
            System.out.println(course + ": " + enrollmentMap.get(course) + " students");
        }
        System.out.println();
        System.out.println("Rejected operations: " + rejectedOperations);
    }
}