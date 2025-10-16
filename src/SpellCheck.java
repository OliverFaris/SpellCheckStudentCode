import java.util.ArrayList;
/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Oliver Faris
 * */

public class SpellCheck {
    public String[] checkWords(String[] text, String[] dictionary) {
        Trie trieDict = new Trie();
        // Insert dictionary into trie
        TST TSTDict = new TST('m');
        for (String word : dictionary) {
//            trieDict.insert(word);
            TSTDict.insert(word);
        }

//        Trie trieMisspelled = new Trie();
        TST TSTMisspelled = new TST('m');
        ArrayList<String> listMisspelled = new ArrayList<>();
        // Iterate through text
        for (String word : text) {
            // Checks if word is misspelled and we have caught it before
            if (!TSTDict.lookup(word) && !TSTMisspelled.lookup(word)) {
                // Insert the word into the misspelled trie & array
                TSTMisspelled.insert(word);
                listMisspelled.add(word);
            }
        }

        // Convert to array
        String[] arrayMisspelled = new String[listMisspelled.size()];
        return listMisspelled.toArray(arrayMisspelled);
    }
}
