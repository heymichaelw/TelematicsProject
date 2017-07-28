import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );

        System.out.println("What is your vehicle's VIN?");
        int thisVin = scanner.nextInt();

        System.out.println("How many miles are on the odometer?");
        double thisOdometer = scanner.nextDouble();

        System.out.println("How many gallons of gas have been consumed?");
        double thisGallons = scanner.nextDouble();

        System.out.println("What was the odometer reading at last service?");
        double thisService = scanner.nextDouble();

        System.out.println("What is the size of the engine, in liters?");
        double thisEngine = scanner.nextDouble();

        VehicleInfo newInfo = new VehicleInfo();
        newInfo.setVIN(thisVin);
        newInfo.setOdometer(thisOdometer);
        newInfo.setGallonsUsed(thisGallons);
        newInfo.setOdometerAtLastService(thisService);
        newInfo.setEngineSize(thisEngine);

        TelematicsService.report(newInfo);

    }
}
