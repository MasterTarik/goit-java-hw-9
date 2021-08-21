package user;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordCounter {
    private final String fileDirectory = "src\\main\\resources\\file3.txt";
    private HashMap<String, Integer> wordCounter = new HashMap<>();

    public void wordCounter() throws IOException {
        for (String word : stringArrayCreator()) {
            if (wordCounter.containsValue(word)) {
                System.out.println(" if ");
                int counter = wordCounter.get(word);
                System.out.println(" count " + counter);
                wordCounter.remove(word);
                wordCounter.put(word, ++counter);
                System.out.println(" count = " + counter);
            } else {
                System.out.println(" else ");
                wordCounter.put(word, 1);
                System.out.println(wordCounter.toString());
            }
        }
        System.out.println(wordCounter.toString());
    }

    public void sorted() {

    }

    private String[] stringArrayCreator() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try (FileReader fileReader = new FileReader(fileDirectory)) {
            BufferedReader br = new BufferedReader(fileReader);
            String str;
            while ((str = br.readLine()) != null) {
                if (!str.strip().equals("")) {
                    stringBuffer.append(str.strip().concat(" "));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString().split(" ");
    }

    @Override
    public String toString() {
        return "WordCounter{" +
                "wordCounter=" + wordCounter +
                '}';
    }
}
