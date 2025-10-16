public class TST {
    // Instance variables
    private final int LEFT = 0;
    private final int MIDDLE = 1;
    private final int RIGHT = 2;
    private TSTNode root;

    // Constructor
    public TST(char firstLetter) {
        root = new TSTNode(firstLetter);
    }

    // Methods
    public void insert(String word) {
        TSTNode node = root;
        int count = 0;
        char letter = ' ';
        // Iterate through word
        while (count < word.length()) {
            letter = word.charAt(count);

            // Go to the right
            if (node.getLetter() < letter) {
                // Set new node if empty
                if (node.getNodes()[RIGHT] == null) {
                    node.setNode(RIGHT, new TSTNode(letter));
                }
                // Move to the right node
                node = node.getNodes()[RIGHT];
            }
            // Go to the left
            else if (node.getLetter() > letter) {
                if (node.getNodes()[LEFT] == null) {
                    node.setNode(LEFT, new TSTNode(letter));
                }
                // Move to the left node
                node = node.getNodes()[LEFT];
            }

            // Go down the middle
            else {
                // The last letter is the end of the word
                if (count == word.length() -1) {
                    node.setWord(true);
                    break;
                }
                // Set new node if middle is empty
                if (node.getNodes()[MIDDLE] == null) {
                    node.setNode(MIDDLE, new TSTNode(word.charAt(count+1)));
                }
                // Go to next letter & move to the middle node
                count++;
                node = node.getNodes()[MIDDLE];
            }
        }
    }

    public boolean lookup(String word) {
        TSTNode node = root;
        int count = 0;
        char letter = ' ';
        while (node != null) {
            letter = word.charAt(count);
            // Go right
            if (node.getLetter() < letter) {
                node = node.getNodes()[RIGHT];
            }
            // Go left
            else if (node.getLetter() > letter) {
                node = node.getNodes()[LEFT];
            }
            // Go middle
            else {
                // If at the last letter, check if it's a word or not
                if (count == word.length() -1)
                    return node.isWord();

                node = node.getNodes()[MIDDLE];
                // Go to the next letter
                count++;
            }
        }
        return false;
    }
}
