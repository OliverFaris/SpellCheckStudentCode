import java.util.ArrayList;
import java.util.Arrays;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Oliver Faris
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all misspelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        Trie trieDict = new Trie();
        // Insert dictionary into trie
        for (String word : dictionary) {
            trieDict.insert(word);
        }

        Trie trieMisspelled = new Trie();
        ArrayList<String> listMisspelled = new ArrayList<>();
        // Iterate through text
        for (String word : text) {
            // Checks if word is misspelled and we have caught it before
            if (!trieDict.lookup(word) && !trieMisspelled.lookup(word)) {
                // Insert the word into the misspelled trie & array
                trieMisspelled.insert(word);
                listMisspelled.add(word);
            }
        }

        // Convert to array
        String[] arrayMisspelled = new String[listMisspelled.size()];
        arrayMisspelled = listMisspelled.toArray(arrayMisspelled);

        return arrayMisspelled;
    }
}
