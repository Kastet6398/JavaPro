import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("bird", "fox", "cat", "bird", "dog", "cat");
        System.out.println(countOccurrence(words, "bird"));
        Integer[] array = {1, 2, 3};
        List<Integer> list = toList(array);
        System.out.println(list);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 4, 5, 2);
        System.out.println(findUnique(numbers));
        List<String> wordsList = Arrays.asList("bird", "fox", "cat", "bird", "dog", "cat");
        calcOccurrence(wordsList);

        List<String> wordsList2 = Arrays.asList("bird", "fox", "cat", "bird", "dog", "cat");
        System.out.println(findOccurrence(wordsList2));
    }

    public static int countOccurrence(List<String> list, String word) {
        int count = 0;
        for (String str : list) {
            if (str.equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static <T> List<T> toList(T[] arr) {
// Manual copy:
        List<T> res = new ArrayList<>();
        for (T element : arr) {
            res.add(element);
        }
        return res;

// Better one:
//        return Arrays.asList(arr);
    }

    public static List<Integer> findUnique(List<Integer> list) {
        Set<Integer> uniqueSet = new HashSet<>(list);
        return new ArrayList<>(uniqueSet);
    }

    public static void calcOccurrence(List<String> list) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : list) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(STR."\{entry.getKey()}: \{entry.getValue()}");
        }
    }

    public static List<Occurrence> findOccurrence(List<String> list) {
        List<Occurrence> occurrences = new ArrayList<>();
        for (String word : list) {
            boolean found = false;
            for (Occurrence occurrence : occurrences) {
                if (occurrence.getName().equals(word)) {
                    occurrence.increaseCount();
                    found = true;
                    break;
                }
            }
            if (!found) {
                occurrences.add(new Occurrence(word, 1));
            }
        }
        return occurrences;
    }
}

