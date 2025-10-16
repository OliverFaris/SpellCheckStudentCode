public class Trie {
    // Instance variables
    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Methods
    public void insert(String word) {
        TrieNode node = root;
        for (int i=0; i < word.length(); i++) {
            int index = word.charAt(i);

            // If the node is occupied
            if (node.getNext()[index] != null)
                // Move to that node
                node = node.getNext()[index];
            else {
                // Or, make a new node and move to that node
                TrieNode newNode = new TrieNode();
                node.setNext(index, newNode);
                node = newNode;
            }
        }
        // When the word is finished, make the last letter the end of the sentence
        node.setWord(true);
    }

    public boolean lookup(String word) {
        TrieNode node = root;
        for (int i=0; i < word.length(); i++) {
            int index = word.charAt(i);
            // If the node is occupied
            if (node.getNext()[index] != null)
                // Move to that node
                node = node.getNext()[index];
            // If the next node is empty, the word doesn't exist
            else
                break;

            // If we are at the end of the word and the letter is the end of the word, then this is a word
            if (i == word.length() -1 && node.isWord())
                return true;
        }

        // Not a word
        return false;
    }
}
