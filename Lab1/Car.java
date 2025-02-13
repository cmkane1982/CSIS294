public class Car extends MotorVehicle
{
    private int doorCount;

    public void setDoorCount(int doorCount)
    {
        this.doorCount = doorCount;
    }

    public int getDoorCount()
    {
        return this.doorCount;
    }

    public void start()
    {
        super.setRunning(true);
        
        System.out.println();
        System.out.println("Running: " + super.getRunning());
        System.out.println("Color: " + super.getColor());
        System.out.println("Door Count: " + this.doorCount);
        System.out.println("Vehicle Type: Car");
        System.out.println("Car has been started");
        System.out.println();
    }

    public void stop()
    {
        super.setRunning(false);

        System.out.println();
        System.out.println("Running: " + super.getRunning());
        System.out.println("Color: " + super.getColor());
        System.out.println("Door Count: " + this.doorCount);
        System.out.println("Vehicle Type: Car");
        System.out.println("Car has been stopped");
        System.out.println();
    }
    
}
