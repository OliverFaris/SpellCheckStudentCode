public class TSTNode {
    // Instance variables
    private TSTNode[] nodes;
    private boolean isWord;
    private char letter;

    // Constructor
    public TSTNode(char letter) {
        nodes = new TSTNode[3];
        isWord = false;
        this.letter = letter;
    }

    // Methods
    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean bool) {
        isWord = bool;
    }

    public TSTNode[] getNodes() {
        return nodes;
    }

    public void setNode(int index, TSTNode node) {
        nodes[index] = node;
    }

    public char getLetter() {
        return letter;
    }
}
