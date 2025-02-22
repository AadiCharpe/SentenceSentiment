import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;

import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a sentence:");
        String sentence = "";
        int value = 0;
        Map<String, Integer> words = new HashMap<>();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            sentence = in.readLine();
            in.close();
            in = new BufferedReader(new FileReader("words.txt"));
            StringTokenizer tokenizer = new StringTokenizer(in.readLine(), "|");
            in.close();
            while(tokenizer.hasMoreTokens())
                words.put(tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if(words.containsKey(token))
                value += words.get(token);
        }
        if(value > 0)
            System.out.println("The sentence was positive");
        else if(value == 0)
            System.out.println("The sentence was neutral");
        else
            System.out.println("The sentence was negative");
    }
}