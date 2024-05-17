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
	int numOfWords = 0;
	List<Map.Entry<String, Long>> sortedWordList;

        try (Stream<String> lines = Files.lines(bookFile.toPath())) {
	    List<String> lineList = lines.collect(Collectors.toList());
	    numOfWords = new HashSet<String>(lineList).size();
            sortedWordList = lineList
		    .stream()
                    .flatMap(line -> Arrays.stream(line.replaceAll("[^a-zA-Z\\s]", "").split("\\s+")))
                    .filter(word -> word.length() > 2)
                    .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(
                            s -> s,
                            Collectors.counting()
                        ),
                        map -> {
                            List<Map.Entry<String, Long>> entryList = new ArrayList<>(map.entrySet());
                            entryList.sort(Map.Entry.<String, Long>comparingByValue().reversed());
                            return entryList;
                        }
    		    ));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        // Most popular words
        System.out.println("10 most popular words with length > 2:");
        sortedWordList.stream()
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // Output the number of unique words
        System.out.println("Number of unique words: " + sortedWordList.size());

        // Write the statistics into the stats file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookName + "_statistics.txt"))) {
            sortedWordList.forEach(entry -> {
                try {
                    writer.write(entry.getKey() + " -> " + entry.getValue());
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.write("Number of unique words: " + (sortedWordList != null ? sortedWordList.size() : 0));
        } catch (IOException e) {
            System.out.println("Error writing the statistics to file: " + e.getMessage());
        }
    }
}

