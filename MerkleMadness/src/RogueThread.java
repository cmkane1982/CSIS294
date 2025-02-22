public class RogueThread implements Runnable{

    public String threadName;

    @Override
    public void run() {
        Util util = new Util();

        while(true) {
            util.sleepRandomTime(threadName);
            String sNewWord = MerkleManager.grabWord();

            if (sNewWord != null) {
                MerkleManager.strikes++;

                System.out.println("STRIKE!");
                System.out.println("Strikes: " + MerkleManager.strikes);
            }

        }
    }
}
