public class Motorcycle extends MotorVehicle
{
    private boolean windshield;

    public void setWindshield(boolean windshield)
    {
        this.windshield = windshield;
    }

    public boolean getWindshield()
    {
        return this.windshield;
    }

    public void start()
    {
        super.setRunning(true);

        System.out.println();
        System.out.println("Running: " + super.getRunning());
        System.out.println("Color: " + super.getColor());
        System.out.println("Windshield: " + this.windshield);
        System.out.println("Vehicle Type: Motorcycle");
        System.out.println("Motorcycle has been started");
        System.out.println();
    }

    public void stop()
    {
        super.setRunning(false);

        System.out.println();
        System.out.println("Running: " + super.getRunning());
        System.out.println("Color: " + super.getColor());
        System.out.println("Windshield: " + this.windshield);
        System.out.println("Vehicle Type: Motorcycle");
        System.out.println("Motorcycle has been stopped");
        System.out.println();
    }
    
}
