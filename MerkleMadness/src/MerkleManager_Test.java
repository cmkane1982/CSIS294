/*
    GROUP MEMBERS:
        Craig Kane

    SAMPLE DATA:
    WORD: word1
    HASH 8b10450019daaf7c2812e14cf6edeb2263e2b45f3a2ef4342a8a3cde8ff7df5f

    WORD: word2
    HASH: afb39cadcd789669ee335b580724df9adbee7200c0340047d5ab6e9c69487a2b

    WORD: word3
    HASH: ffca7f8893c2cd4d63996c0135c8e1f35fdfc981486a8e4c24fe8fb5d8758510

    WORD: word4
    HASH: da466d4eb03fcd5bfd5275282f9f595eca6e88b45f96a3ff0e10a6ad7e84743b

    WORD1 + WORD2
    HASH: 0f4c8f50cd8f237c93dfebab45a57aff1be47ec8cdd8466cf6b7df51a159eb60

    WORD3 + WORD4
    HASH: 6e81f923a72e4ce3d91d7131d38453b6ee2221dfa32a4a20b8c2ca15f8313d21

    FINAL
    HASH: 0264d08de65fcd9ee5767a3c8e87a56a6f554137082898a10fd228331c092ffa
 */

public class MerkleManager_Test
{
    public static void main(String[] args)
    {
        MerkleManager mm = new MerkleManager();

        mm.manage();
    }
}
