import java.util.ArrayList;

public class MerkleThread implements Runnable
{
    public String threadName;
    public static volatile ArrayList<String> lstWords;
    private static final int iMerkleTreeInputs = 4;

    /*
        PURPOSE: Starts MerkleThread. Grabs new words while running.
        INPUT: N/A
        OUTPUT: N/A
     */
    public void run()
    {
        Util util = new Util();
        lstWords = new ArrayList<>();

        System.out.println(threadName + " running.");

        while(true)
        {
            String newWord;

            util.sleepRandomTime(threadName);

            newWord = MerkleManager.grabWord();

            if(newWord != null)
            {
                System.out.println("Merkle Word Grabbed!");
                System.out.println("Word: " + newWord);
                lstWords.add(newWord);
                if(lstWords.size() == iMerkleTreeInputs)
                {
                    MerkleManager.userMerkleRoot = util.getMerkleRoot(lstWords);
                }
            }
        }
    }
}
