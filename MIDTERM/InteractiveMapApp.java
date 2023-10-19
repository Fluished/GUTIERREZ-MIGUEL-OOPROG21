//package InteractiveMapApp;

import java.util.*;

class BusRoutes {
    public BusRoutes(double distance) {
      this.distance = distance;
    }
    
    double distance;

    void carcarRoute() {
        double toMingla = 14.2, toSanfer = 13.1, toCarcar = 11.0;
        System.out.printf("\nRoute 1 : South Bus Terminal -> Minglanilla | %.2f km", (distance += toMingla));
        System.out.printf("\nRoute 2 : Minglanilla -> San Fernando | %.2f km", (distance += toSanfer));
        System.out.printf("\nRoute 3 : San Fernando -> Carcar | %.2f km", (distance += toCarcar));
    }

    void sibongaRoute() {
        double toSibonga = 10.3;
        System.out.printf("\nRoute 4.2 : Carcar -> Sibonga | %.2f km", (distance += toSibonga));
    }

    void bariliRoute() {
        double toBarili = 16.0, toDumanjug = 17.5, toAlcantara = 11.2;
        System.out.printf("\nRoute 4.1 : Carcar -> Barili | %.2f km", (distance += toBarili));
        System.out.printf("\nRoute 4.1.1 : Barili -> Dumanjug | %.2f km", (distance += toDumanjug));
        System.out.printf("\nRoute 4.1.2 : Dumanjug -> Alcantara | %.2f km", (distance += toAlcantara));
    }

    void dumanjugRoute() {
        double toDumanjug = 32.9, toAlcantara = 11.2;
        System.out.printf("\nRoute 4.2.1 : Sibonga -> Dumanjug | %.2f km", (distance += toDumanjug));
        System.out.printf("\nRoute 4.2.2 : Dumanjug -> Alcantara | %.2f km", (distance += toAlcantara));
    }

    void argaoRoute() {
        double toArgao = 8.0, toRonda = 27.0, toAlcantara = 18.8;
        System.out.printf("\nRoute 5 : Sibonga -> Argao | %.2f km", (distance += toArgao));
        System.out.printf("\nRoute 5.1 : Argao -> Ronda | %.2f km", (distance += toRonda));
        System.out.printf("\nRoute 5.2 : Ronda -> Alcantara | %.2f km", (distance += toAlcantara));
    }

    void endMoalboal() {
        double toMoalboal = 1.7;
        System.out.printf("\nRoute End : Alcantara -> Moalboal | %.2f km", (distance += toMoalboal));
    }

    String convertToTime(double timeInDecimal) {
        double convertedTime = 0;

        long hours = Math.round(Math.floor(timeInDecimal));
        long minutes = Math.round(Math.floor((timeInDecimal - hours) * 60));
        long seconds = Math.round(((((timeInDecimal - hours) * 60) - minutes) * 60));

        return String.format("%02dh:%02dm:%02ds", hours, minutes, seconds);
    }
}

public class InteractiveMapApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double distance = 0;

        System.out.println("\n[ You are in Cebu City | South Bus Terminal ]");
        System.out.print("Enter your speed in km/h: ");
        int speed = scan.nextInt();

        BusRoutes busRoutes = new BusRoutes(distance);

        busRoutes.carcarRoute();

        System.out.println("\n\n[ You are now in Carcar ]");
        System.out.println("Is Barili obstructed?");
        System.out.println("1. Yes | 2. No");
        System.out.print(" == ");
        byte option = scan.nextByte();

        switch (option) {
            case 1:
                busRoutes.sibongaRoute();

                System.out.println("\n\n[ You are now in Sibonga ]");
                System.out.println("Is Dumanjug obstructed?");
                System.out.println("1. Yes | 2. No");
                System.out.print(" == ");
                option = scan.nextByte();

                switch (option) {
                    case 1:
                        busRoutes.argaoRoute();
                        break;
                    case 2:
                        busRoutes.dumanjugRoute();
                        break;
                }
                break;
            case 2:
                busRoutes.bariliRoute();
                break;
        }

        busRoutes.endMoalboal();

        double totalDistance = busRoutes.distance;

        System.out.printf("\n\nSpeed: %d km/h", speed);
        System.out.printf("\nTotal distance: %.2f km", totalDistance);
        busRoutes.convertToTime(totalDistance / speed);
        System.out.printf("\nTOA: %.2f hours | %s", (totalDistance / speed),
                (busRoutes.convertToTime(totalDistance / speed)));

        scan.close();
    }
}
