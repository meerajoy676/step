import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class WordFrequencyReport {
    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            boolean stopWord = false;

            for (int j = 0; j < stopWords.length; j++) {
                if (words[i].equals(stopWords[j])) {
                    stopWord = true;
                    break;
                }
            }

            if (!stopWord)
                frequency.put(words[i],
                        frequency.getOrDefault(words[i], 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        Collections.sort(list, (a, b) ->
                b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list)
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter feedback:");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);
    }
}