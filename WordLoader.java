import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WordLoader {
    public List<String> loadWords(String path) {
        // Create a list to store the words
        List<String> words = new ArrayList<>();
        
        // Create a File object with the path
        File file = new File(path);

        try {
            // Create a BufferedReader to read the file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            // Read each line of the file
            while ((line = br.readLine()) != null) {
                // Add the word to the list
                words.add(line);
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

    public String getRandomWord(List<String> words) {
        // Grabs a random word from the given list of words
        int index = (int) (Math.random() * words.size());
        return words.get(index);
    }
}
