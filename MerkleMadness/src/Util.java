import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Util
{
    private String sHash;
    private MerkleNode oLeft;
    private MerkleNode oRight;

    public String getMerkleRoot(ArrayList<String> wordList)
    {
        return "";
    }

    private void populateMerkleNode()
    {

    }

    public synchronized String generateHash(String sOriginal)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(sOriginal.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < btEncodedhash.length; i++)
            {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch (Exception ex)
        {
            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }

    public String promptUser(String uQuestion)
    {
        String sAnswer;
        JOptionPane oQuestion = new JOptionPane();

        sAnswer = oQuestion.showInputDialog(uQuestion);

        return sAnswer;
    }

    public void sleepRandomTime(String sThreadName)
    {
        // Gets random number between 0 and 5 and then adds 3, meaning between and 8 now.
        int iSleepTime = new SecureRandom().nextInt(5) + 3;

        System.out.println(sThreadName + " sleeping for " + iSleepTime + " seconds.");
        sleep(iSleepTime);
    }

    public void sleep(int sleepTime)
    {

    }
}
