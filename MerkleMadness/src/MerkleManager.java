public class MerkleManager
{
    public static volatile String uWord;
    public static String expectedMerkleRoot;
    public static String userMerkleRoot = null;
    public static int strikes = 0;

    public void manage()
    {
        Util util = new Util();

        expectedMerkleRoot = util.promptUser("Enter expected Merkle Root");

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

        while(true)
        {
            uWord = util.promptUser("Enter a Word:");
        }
    }

    public static synchronized String grabWord()
    {
        String tempWord;

        tempWord = uWord;
        uWord = null;

        return tempWord;
    }
}
