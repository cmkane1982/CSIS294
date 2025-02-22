public class MerkleManager
{
    public static volatile String uWord;
    public static String expectedMerkleRoot;
    public static String userMerkleRoot = null;
    public static int strikes = 0;

    /*
        PURPOSE: Create and start all threads needed for
                 game functionality. While game is running,
                 grabs new words from user.
        INPUT: N/A
        OUTPUT: N/A
     */
    public void manage()
    {
        Util util = new Util();

        expectedMerkleRoot = util.promptUser("Enter expected Merkle Root (Use: https://codebeautify.org/sha256-hash-generator)");

        MerkleThread merThread = new MerkleThread();
        RogueThread rogThread = new RogueThread();
        MonitorThread monThread = new MonitorThread();

        merThread.threadName = "Merkle Thread";
        rogThread.threadName = "Rogue Thread";
        monThread.threadName = "Monitor Thread";

        Thread tMerkThread = new Thread(merThread);
        Thread tRogThread = new Thread(rogThread);
        Thread tMonThread = new Thread(monThread);

        tMerkThread.start();
        tRogThread.start();
        tMonThread.start();

        System.out.println("Strikes: " + strikes);

        while(true)
        {
            uWord = util.promptUser("Enter a Word:");
        }
    }

    /*
        PURPOSE: Put instance variable of user's word into
                 temp variable and nullifies instance variable
        INPUT: N/A
        OUTPUT: String of temp variable
     */
    public static synchronized String grabWord()
    {
        String tempWord;

        tempWord = uWord;
        uWord = null;

        return tempWord;
    }
}
