import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class BookAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the book name from the user
        System.out.println("Enter a book name:");
        String bookName = scanner.nextLine();

        // Check if the book exists
        File bookFile = new File(bookName + ".txt");
        if (!bookFile.exists()) {
            System.out.println("The book couldn't be found.");
            return;
        }

        // Read the book and analyze text
        int numOfUniqueWords = 0;
        long numOfUniqueWordsWithLengthMoreThanTwo = 0;
        List<Map.Entry<String, Long>> topTenWords;

        try (Stream<String> lines = Files.lines(bookFile.toPath())) {
            List<String> wordList = lines.flatMap(line -> Arrays.stream(line.toLowerCase().replaceAll("[^\\p{L}\\s]", "").split("\\s+"))).collect(Collectors.toList());
            Set<String> wordSet = new HashSet<>(wordList);
	    numOfUniqueWordsWithLengthMoreThanTwo = wordSet.stream().filter(word -> word.length() > 2).count();
	    numOfUniqueWords = wordSet.size();
            topTenWords = wordList
        	    .stream()
        	    .filter(word -> word.length() > 2)
                    .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(
                            s -> s,
                            Collectors.counting()
                        ),
                        map -> {
                            List<Map.Entry<String, Long>> entryList = new ArrayList<>(map.entrySet());
                            entryList.sort(Map.Entry.<String, Long>comparingByValue().reversed());
                            return entryList.subList(0, Math.min(entryList.size(), 10));
                        }
            	    ));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        // Most popular words
        System.out.println("10 most popular words with length > 2:");
	for (Map.Entry<String, Long> word : topTenWords) {
	    System.out.println(word.getKey() + " -> " + word.getValue());
	}

        // Output the number of unique words
        System.out.println("Number of unique words: " + numOfUniqueWords);

        System.out.println("Number of unique words with length > 2: " + numOfUniqueWordsWithLengthMoreThanTwo);
        // Write the statistics into the stats file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookName + "_statistics.txt"))) {
            writer.write("10 most popular words with length > 2:");
            writer.newLine();
	    topTenWords.forEach(entry -> {
                try {
                    writer.write(entry.getKey() + " -> " + entry.getValue());
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.write("Number of unique words: " + numOfUniqueWords);
	    writer.newLine();
            writer.write("Number of unique words with length > 2: " + numOfUniqueWordsWithLengthMoreThanTwo);
        } catch (IOException e) {
            System.out.println("Error writing the statistics to file: " + e.getMessage());
        }
    }
}

