package Laborator1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        String sentence = "";
        int wordLength = 0;

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(is);

        try {
            System.out.println("Introdu propozitia: ");
            sentence = bis.readLine();
            System.out.println("Introdu lungimea cuvantului inlocuit: ");
            wordLength = Integer.parseInt(bis.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Text myText = new Text(sentence, wordLength);
        myText.extractWords();
        System.out.println("Cuvintele extrase:\n" + myText.getExtractedWords());
    }
}

class Text {

    private String originalSentence;
    private int wordLength;
    private StringBuilder extractedWords = new StringBuilder();

    public Text(String originalSentence, int wordLength) {
        this.originalSentence = originalSentence;
        this.wordLength = wordLength;
    }

    public String getExtractedWords() {
        return extractedWords.toString();
    }

    public void extractWords() {
        String[] words = originalSentence.split("\\s+");
        for (String word : words) {
            if (word.length() == wordLength && isConsonant(word.charAt(0))) {
                extractedWords.append(word).append(" ");
            }
        }
    }

    private boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1;
    }
}
