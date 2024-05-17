import java.util.*;

public class crc {
    public static void main(String args[]) {
        try (
                Scanner scan = new Scanner(System.in)) {
            int size;
            System.out.println("Enter the size of the data array: ");
            size = scan.nextInt();
            int data[] = new int[size];
            System.out.println("Enter data bits in the array one by one: ");
            for (int i = 0; i < size; i++) {
                System.out.println("Enter bit " + (size - i) + ":");
                data[i] = scan.nextInt();
            }
            System.out.println("Enter the size of the divisor array:");
            size = scan.nextInt();
            int divisor[] = new int[size];
            System.out.println("Enter divisor bits in the array one by one: ");
            for (int i = 0; i < size; i++) {
                System.out.println("Enter bit " + (size - i) + ":");
                divisor[i] = scan.nextInt();
            }
            int rem[] = divideDataWithDivisor(data, divisor);
            for (int i = 0; i < rem.length - 1; i++) {
                System.out.print(rem[i]);
            }
            System.out.println("\nGenerated CRC code is: ");

            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i]);
            }
            for (int i = 0; i < rem.length - 1; i++) {
                System.out.print(rem[i]);
            }
            System.out.println();

            int sentData[] = new int[data.length + rem.length - 1];
            System.out.println("Enter bits in the array which you want to send: ");
            for (int i = 0; i < sentData.length; i++) {
                System.out.println("Enter bit " + (sentData.length - i) + ":");
                sentData[i] = scan.nextInt();
            }
            receiveData(sentData, divisor);
        }
    }

    static int[] divideDataWithDivisor(int oldData[], int divisor[]) {
        int rem[] = new int[divisor.length];
        int i;
        int data[] = new int[oldData.length + divisor.length];
        System.arraycopy(oldData, 0, data, 0, oldData.length);
        System.arraycopy(data, 0, rem, 0, divisor.length);
        for (i = 0; i < oldData.length; i++) {
            System.out.println((i + 1) + ".) First data bit is : " + rem[0]);
            System.out.print("Remainder : ");
            if (rem[0] == 1) {
                for (int j = 1; j < divisor.length; j++) {
                    rem[j - 1] = exorOperation(rem[j], divisor[j]);
                    System.out.print(rem[j - 1]);
                }
            } else {
                for (int j = 1; j < divisor.length; j++) {
                    rem[j - 1] = exorOperation(rem[j], 0);
                    System.out.print(rem[j - 1]);
                }
            }

            rem[divisor.length - 1] = data[i + divisor.length];
            System.out.println(rem[divisor.length - 1]);
        }
        return rem;
    }

    static int exorOperation(int x, int y) {
        if (x == y) {
            return 0;
        }
        return 1;
    }

    static void receiveData(int data[], int divisor[]) {

        int rem[] = divideDataWithDivisor(data, divisor);
        for (int i = 0; i < rem.length; i++) {
            if (rem[i] != 0) {
                System.out.println("Currupted data received...");
                return;
            }
        }
        System.out.println("Data received without any error.");
    }
}