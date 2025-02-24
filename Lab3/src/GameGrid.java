import java.security.SecureRandom;

public class GameGrid
{
    public static final int NUM_COLS = 10;
    public static final int NUM_ROWS = 10;
    public static final int RANDOM_CHANCE = 30;

    private int[][] gameGrid = new int[NUM_ROWS][NUM_COLS];
    private Player player = new Player();
    private boolean gameOver = false;

    public void run()
    {
        initBoard();

        System.out.println("You Start at Bottom-Left of Board.");
        System.out.println("Avoid the Mines and Escape Either Up or Right.");
        while(!gameOver)
        {
            moveUser(player.getUserSelection());
            if(!gameOver)
            {
                if (player.getUserCol() == NUM_COLS - 1 || player.getUserRow() == NUM_ROWS - 1)
                {
                    System.out.println("Congratulations! You WIN!!!");
                    gameOver = true;
                }
                else if (gameGrid[player.getUserRow()][player.getUserCol()] == 1)
                {
                    System.out.println("You Hit a Land Mine. You Lose!");
                    gameOver = true;
                }
                else
                {
                    System.out.println("You Are Safe... For Now...");
                }
            }
        }

        printGameBoard();
    }

    private void initBoard()
    {
        SecureRandom random = new SecureRandom();

        for(int i = 0; i < NUM_ROWS; i++)
        {
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(random.nextInt(100) < RANDOM_CHANCE)
                {
                    gameGrid[i][j] = 1;
                }
                else
                {
                    gameGrid[i][j] = 0;
                }
            }
        }

        gameGrid[0][0] = 0;
    }

    private void moveUser(int direction)
    {
        if(direction < 1 || direction > 5)
        {
            System.out.println("Invalid Selection. Please Select 1 - 4");
        }
        else
        {
            switch (direction)
            {
                case 1:
                    player.increaseRow();
                    break;
                case 2:
                    player.increaseCol();
                    break;
                case 3:
                    if(player.getUserRow() == 0)
                    {
                        System.out.println("Cannot Go Out of Bounds.");
                    }
                    else
                    {
                        player.decreaseRow();
                    }
                    break;
                case 4:
                    if(player.getUserCol() == 0)
                    {
                        System.out.println("Cannot Go Out of Bounds.");
                    }
                    else
                    {
                        player.decreaseCol();
                    }
                    break;
                case 5:
                    gameOver = true;
            }
        }
    }

    private void printGameBoard()
    {
        for(int i = NUM_ROWS - 1; i >= 0; i--)
        {
            System.out.print(i + " ");
            for(int j = 0; j < NUM_COLS; j++)
            {
                if(i == player.getUserRow() && j == player.getUserCol())
                {
                    System.out.print("[X] ");
                }
                else
                {
                    System.out.print("[" + gameGrid[i][j] + "] ");
                }
            }
            System.out.println();
        }
        System.out.println("   0   1   2   3   4   5   6   7   8   9");
    }
}
