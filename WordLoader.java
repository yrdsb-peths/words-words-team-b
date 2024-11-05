import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class WordLoader {
    public static Map<String, String> loadWords(String path) {
        // Create a map to store the words with the category
        Map<String, String> words = new HashMap<String, String>();

        // Create a File object with the path
        File file = new File(path);

        try {
            // Create a BufferedReader to read the file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            // Read each line of the file
            while ((line = br.readLine()) != null) {
                // Add the word to the list and remove the space from any commas
                String[] word = line.split(",");
                words.put(word[0], word[1]);
            }

            // Close the BufferedReader
            br.close();
        } catch (java.io.IOException e) {
            // Catch IOExceptions (for example, if the file is not found)
            System.err.println("Error reading file" + path);
            e.printStackTrace();
        }

        return words;
    }

    public static String[] getRandomWord(String path) {
        // Load in the words from the path
        Map<String, String> words = loadWords(path);

        // Get all the keys (words)
        List<String> keys = new ArrayList<String>(words.keySet());

        // Get a random key (word)
        String randomKey = keys.get((int) (Math.random() * keys.size()));

        // Return an array with the random key and the word
        return new String[] { randomKey, words.get(randomKey) };
    }
}
