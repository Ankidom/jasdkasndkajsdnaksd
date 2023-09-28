package nl.saxion.parcomp.asign2;

import java.util.Scanner;

public class HiswaWorld {


    private final int sizeOfTheHISWA = 5, nrOfBuyes = 10, nrOfVisistors = 1000,
                      consecutiveBuyers = 4  ;



    public static void main(String[] args) {
        new HiswaWorld().startWorld();
    }



    public void startWorld() {
        Hiswa hiswa = new Hiswa(sizeOfTheHISWA, consecutiveBuyers);
        for (int i = 0; i < nrOfVisistors; i++) {
            new Thread(new Visitor(hiswa,"Visitor " + i),"Visitor" + i ).start();
        }
        for (int i = 0; i < nrOfBuyes; i++) {
            new Thread(new Buyer(hiswa,"Buyer " + i),"Buyer" + i ).start();
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Press Enter to quit...");
        scan.nextLine();
        System.exit(0);

    }

}
