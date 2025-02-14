import java.util.ArrayList;

public class MerkleThread implements Runnable
{
    public String threadName;
    public static volatile ArrayList<String> lstWords;
    private static final int iMerkleTreeInputs = 4;

    public void run()
    {
        Util util = new Util();
        ArrayList<String> wordList = new ArrayList<>();

        while(true)
        {
            String newWord;

            util.sleepRandomTime(threadName);

            newWord = MerkleManager.grabWord();

            if(newWord != null)
            {
                System.out.println("Merkle Word Grabbed!");
                lstWords.add(newWord);
                if(lstWords.size() == iMerkleTreeInputs)
                {
                    MerkleManager.userMerkleRoot = util.getMerkleRoot(wordList);
                }
            }
        }
    }
}
