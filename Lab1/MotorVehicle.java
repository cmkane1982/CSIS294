public class MotorVehicle
{
    private boolean running;
    private String color;

    public MotorVehicle()
    {
        this.running = false;
        this.color = "none";
    }

    public MotorVehicle(String color)
    {
        this.running = false;
        this.color = color;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public boolean getRunning()
    {
        return this.running;
    }

    public String getColor()
    {
        return this.color;
    }
}
