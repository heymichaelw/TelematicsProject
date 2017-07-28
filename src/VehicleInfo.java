
public class VehicleInfo {
    private int VIN;
    private double odometer;
    private double gallonsUsed;
    private double odometerAtLastService;
    private double engineSize;

    public VehicleInfo() {

    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getGallonsUsed() {
        return gallonsUsed;
    }

    public void setGallonsUsed(double gallonsUsed) {
        this.gallonsUsed = gallonsUsed;
    }

    public double getOdometerAtLastService() {
        return odometerAtLastService;
    }

    public void setOdometerAtLastService(double odometerAtLastService) {
        this.odometerAtLastService = odometerAtLastService;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}
