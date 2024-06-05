import java.util.*;

public class UniqueWordsCounter {
    public static void main(String[] args) {
        String[] wordsArray = {"Toyota", "Honda", "Toyota", "Ford", "Honda", "BMW", "Toyota", "Ford", "Tesla", "Toyota", "Mercedes"};

        Set<String> uniqueWords = new HashSet<>();
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : wordsArray) {
            uniqueWords.add(word);
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Список уникальных слов:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
        
        System.out.println("\nКоличество встреч каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
