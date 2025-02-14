public class MerkleManager
{
    public static volatile String uWord;
    public static String uMerkleRoot;
    public static String merkleRoot = null;
    public static int strikes = 0;

    public void manage()
    {
        Util util = new Util();

        String ans = util.promptUser("Test");
    }

    public static synchronized String grabWord()
    {
        String tempWord;

        tempWord = uWord;
        uWord = null;

        return tempWord;
    }
}
