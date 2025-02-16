public class MonitorThread implements Runnable {
    public String threadName;

    public void run() {
        Util util = new Util();

        // show that the merkle and rogue are running
        System.out.println(threadName + " running.");

        while(true) {
            if(MerkleManager.userMerkleRoot != null) {
                if(MerkleManager.userMerkleRoot.equals(MerkleManager.expectedMerkleRoot)) {
                    System.out.println("You Win!\nMerkle Root: " + MerkleManager.expectedMerkleRoot);
                    System.exit(0);
                } else {
                    System.out.println("You Lost!\nMerkle Root: " + MerkleManager.expectedMerkleRoot);
                    System.exit(0);
                }
            // 3 or more strikes causes the user to lose
            } else if (MerkleManager.strikes >= 3) {
                System.out.println("3 Strikes: You Lost!\nMerkle Root: " + MerkleManager.expectedMerkleRoot);
                System.exit(0);
            }
            // catches potential errors
            try {
                util.sleep(1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
