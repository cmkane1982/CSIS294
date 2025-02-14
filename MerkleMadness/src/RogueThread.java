public class RogueThread implements Runnable
{
    public String threadName;

    public void run()
    {
        Util util = new Util();

        while(true)
        {
            String newWord;

            util.sleepRandomTime(threadName);

            newWord = MerkleManager.grabWord();

            if(newWord != null)
            {
                MerkleManager.strikes++;

                System.out.println("STRIKE!");
            }
        }
    }
}
