package test;

import user.WordCounter;

import java.io.IOException;
import java.util.Arrays;

public class WordCounterTest {
    public static void main(String[] args) throws IOException {
        WordCounter wordCounter = new WordCounter();
        //System.out.println(Arrays.toString(wordCounter.stringArrayCreator()));
        wordCounter.wordCounter();
    }

}
