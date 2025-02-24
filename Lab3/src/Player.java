import java.util.Scanner;

public class Player
{
    private int iUserRow;
    private int iUserCol;

    public int getUserRow() { return iUserRow; }
    public int getUserCol() { return iUserCol; }

    public void increaseRow() { iUserRow++; }
    public void decreaseRow() { iUserRow--; }
    public void increaseCol() { iUserCol++; }
    public void decreaseCol() { iUserCol--; }

    Player()
    {
        this.iUserCol = 0;
        this.iUserRow = 0;
    }

    public int getUserSelection()
    {
        Scanner scnr = new Scanner(System.in);
        String userInput;
        int userSelection;

        System.out.println("Your Position: X : " + getUserCol() + ", Y : " + getUserRow());
        System.out.println("Please Select a Direction to Move:");
        System.out.println("1: Up");
        System.out.println("2: Right");
        System.out.println("3: Down");
        System.out.println("4: Left");
        System.out.println("5: Exit");
        System.out.print("Selection (1 - 5): ");
        userInput = scnr.nextLine();
        try
        {
            userSelection = Integer.parseInt(userInput);
        }
        catch (NumberFormatException nfe)
        {
            userSelection = 0;
        }

        return userSelection;
    }
}
