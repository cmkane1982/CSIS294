import java.util.Scanner;

public class VehicleManager 
{
    static final int NUM_VEHICLES = 3;

    private Car cars[];
    private Motorcycle motorcycles[];

    public void run()
    {
        Scanner scnr = new Scanner(System.in);

        cars = new Car[NUM_VEHICLES];
        motorcycles = new Motorcycle[NUM_VEHICLES];

        int selection;

        for(int i = 0; i < NUM_VEHICLES; i++)
        {
            Car newCar = new Car();
            Motorcycle newMotorcycle = new Motorcycle();

            newCar.setRunning(false);
            newMotorcycle.setRunning(false);

            cars[i] = newCar;
            motorcycles[i] = newMotorcycle;
        }

        cars[0].setColor("Green");
        cars[1].setColor("Red");
        cars[2].setColor("Blue");

        cars[0].setDoorCount(2);
        cars[1].setDoorCount(4);
        cars[2].setDoorCount(2);

        motorcycles[0].setColor("Green");
        motorcycles[1].setColor("Red");
        motorcycles[2].setColor("Blue");

        motorcycles[0].setWindshield(false);
        motorcycles[1].setWindshield(true);
        motorcycles[2].setWindshield(true);

        System.out.println("Which car would you like to START?");
        for(int i = 0; i < cars.length; i++)
        {
            System.out.println(i + 1 + ": " + cars[i].getColor());
        }
        System.out.print("Selection (1-3): ");
        selection = scnr.nextInt();

        cars[selection - 1].start();

        System.out.println("Which motorcycle would you like to START?");
        for(int i = 0; i < motorcycles.length; i++)
        {
            System.out.println(i + 1 + ": " + motorcycles[i].getColor());
        }
        System.out.print("Selection (1-3): ");
        selection = scnr.nextInt();

        motorcycles[selection - 1].start();

        System.out.println("Which car would you like to STOP?");
        for(int i = 0; i < cars.length; i++)
        {
            System.out.println(i + 1 + ": " + cars[i].getColor());
        }
        System.out.print("Selection (1-3): ");
        selection = scnr.nextInt();

        cars[selection - 1].stop();

        System.out.println("Which motorcycle would you like to STOP?");
        for(int i = 0; i < motorcycles.length; i++)
        {
            System.out.println(i + 1 + ": " + motorcycles[i].getColor());
        }
        System.out.print("Selection (1-3): ");
        selection = scnr.nextInt();

        motorcycles[selection - 1].stop();

        System.out.println("Cars:");
        for(int i = 0; i < NUM_VEHICLES; i++)
        {
            System.out.println("Car " + (i + 1) + ": " + "Color: " + cars[i].getColor() + ", Num Doors:" + cars[i].getDoorCount() + ", Running:" + cars[i].getRunning());
            System.out.println();
        }

        System.out.println("Motorcycles:");
        for(int i = 0; i < NUM_VEHICLES; i++)
        {
            System.out.println("Motorcycle " + (i + 1) + ": " + "Color: " + motorcycles[i].getColor() + ", Windshield:" + motorcycles[i].getWindshield() + ", Running:" + motorcycles[i].getRunning());
            System.out.println();
        }

        scnr.close();
    }
}
