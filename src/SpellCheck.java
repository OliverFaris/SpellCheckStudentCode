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
        int index = (dictionary.length-1)/2;
        int low = 0;
        int high = dictionary.length -1;
        boolean isInDictionary = false;
        ArrayList<String> badWords = new ArrayList<>();

        // Iterate through each word in the text
        for (String word : text) {
            // Makes sure there are no dupes
            if (!badWords.contains(word)) {
                while (index != high && index != low) {
                    // The word is deeper in the dictionary
                    if (word.compareTo(dictionary[index]) > 0) {
                        low = (high +low) /2;
                        index = (high +low) /2;
                    }
                    // The word is lower in the dictionary
                    else if (word.compareTo(dictionary[index]) < 0) {
                        high = (high +low) /2;
                        index = (high +low) /2;
                    }
                    // The word exists in the dictionary
                    if (word.equals(dictionary[index])) {
                        isInDictionary = true;
                        break;
                    }
                }
                if (!isInDictionary)
                    badWords.add(word);

                // Reset variables
                isInDictionary = false;
                index = (dictionary.length-1)/2;
                low = 0;
                high = dictionary.length -1;
            }
        }
        // Change to an array
        String[] misspelledWords = new String[badWords.size()];
        for (int i = 0; i < misspelledWords.length; i++) {
            misspelledWords[i] = badWords.get(i);
        }

        return misspelledWords;
    }
}
