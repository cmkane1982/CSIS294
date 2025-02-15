import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Util {
    public String getMerkleRoot(ArrayList<String> wordList) {
        MerkleNode finalNode = new MerkleNode();
        ArrayList<MerkleNode> mNodeList = new ArrayList<>();

        for(int i = 0; i < wordList.size(); i++) {
            mNodeList.add(new MerkleNode());
            mNodeList.get(i).sHash = generateHash(wordList.get(i));
        }

        for(int i = 0; i < wordList.size(); i += 2) {
            MerkleNode mNode = new MerkleNode();

            populateMerkleNode(mNode, mNodeList.get(i), mNodeList.get(i + 1));
            mNodeList.add(mNode);
        }

        populateMerkleNode(finalNode, mNodeList.get(mNodeList.size() - 2), mNodeList.getLast());

        return finalNode.sHash;
    }

    private void populateMerkleNode(MerkleNode oNode, MerkleNode oLeftNode, MerkleNode oRightNode) {
        oNode.oLeft = oLeftNode;
        oNode.oRight = oRightNode;
        oNode.sHash = generateHash(oNode.oLeft.sHash + oNode.oRight.sHash);
    }

    public synchronized String generateHash(String sOriginal) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(sOriginal.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < btEncodedhash.length; i++)
            {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch (Exception ex) {
            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }

    public String promptUser(String uQuestion) {
        String sAnswer;
        sAnswer = JOptionPane.showInputDialog(uQuestion);
        return sAnswer;
    }

    public void sleepRandomTime(String sThreadName) {
        // Gets random number between 0 and 5 and then adds 3, meaning between and 8 now.
        int iSleepTime = new SecureRandom().nextInt(5) + 3;
        System.out.println(sThreadName + " sleeping for " + iSleepTime + " seconds.");
        try {
            sleep(iSleepTime);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sleep(int sleepTime) throws Exception {
        Thread.sleep(sleepTime * 1000L);
    }
}