// import java.util.Scanner;

// public class IPAddressClassification {

//     public static boolean isValid(int[] octetValues){
//         if((octetValues[0]>=0 && octetValues[0]<=255) && (octetValues[1]>=0 && octetValues[1]<=255) && (octetValues[2]>=0 && octetValues[2]<=255) && (octetValues[3]>=0 && octetValues[3]<=255)){
//             return true;
//         }
//         return false;
//     }
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {

//             System.out.println("Enter IP Address:");
//             String ipAddress = sc.nextLine();

//             String[] octets = ipAddress.split("\\.");

//             int[] octetValues = new int[octets.length];

//             for (int i = 0; i < octets.length; i++) {
//                 octetValues[i] = Integer.parseInt(octets[i]);
              
//             }
            



            
//             if((octetValues[0]>=0 && octetValues[0]<=127) && isValid(octetValues)){
//                 System.out.println("Class A found");
//             }
//             else if((octetValues[0]>=128 && octetValues[0]<=191) && isValid(octetValues)){
//                 System.out.println("Class B found");
//             }
//             else if((octetValues[0]>=192 && octetValues[0]<=223) && isValid(octetValues)){
//                 System.out.println("Class C found");
//             }
//             else if((octetValues[0]>=224 && octetValues[0]<=239) && isValid(octetValues)){
//                 System.out.println("Class D found");
//             }
//             else if((octetValues[0]>=240 && octetValues[0]<=255) && isValid(octetValues)){
//                 System.out.println("Class E found");
//             } 
//             else{
//                 System.out.println("Invalid IP Address");
//             }

//         }
//     }
// }

import java.util.Scanner;

public class IPAddressClassification {

    public static boolean isValid(int[] octetValues){
        if((octetValues[0]>=0 && octetValues[0]<=255) && (octetValues[1]>=0 && octetValues[1]<=255) && (octetValues[2]>=0 && octetValues[2]<=255) && (octetValues[3]>=0 && octetValues[3]<=255)){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter IP Address:");
            String ipAddress = sc.nextLine();

            String[] octets = ipAddress.split("\\.");

            int[] octetValues = new int[octets.length];

            // Validate octets
            boolean isValid = true;
            for (int i = 0; i < octets.length; i++) {
                if (octets[i].length() > 1 && octets[i].charAt(0) == '0') {
                    // If there are leading zeros, it's not a valid IP address
                    isValid = false;
                    break;
                }
                octetValues[i] = Integer.parseInt(octets[i]);
            }
            
            if(isValid && isValid(octetValues)) {
                if(octetValues[0] >= 0 && octetValues[0] <= 127) {
                    System.out.println("Class A found");
                }
                else if(octetValues[0] >= 128 && octetValues[0] <= 191) {
                    System.out.println("Class B found");
                }
                else if(octetValues[0] >= 192 && octetValues[0] <= 223) {
                    System.out.println("Class C found");
                }
                else if(octetValues[0] >= 224 && octetValues[0] <= 239) {
                    System.out.println("Class D found");
                }
                else if(octetValues[0] >= 240 && octetValues[0] <= 255) {
                    System.out.println("Class E found");
                } 
            } else {
                System.out.println("Invalid IP Address");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid IP Address");
        }
    }
}
