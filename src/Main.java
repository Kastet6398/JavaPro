import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = List.of("bird", "fox", "cat", "bird", "dog", "cat", "cat", "fox", "dog", "racoon");
        System.out.println(countOccurrence(words, "bird"));

        Integer[] array = {1, 2, 3};
        List<Integer> list = toList(array);
        System.out.println(list);

        String[] array2 = {"cat", "bird", "cat", "racoon"};
        List<String> list2 = toList(array2);
        System.out.println(list2.getClass().getName());

        List<Integer> numbers = List.of(1, 2, 3, 1, 4, 5, 2, 0, 0, 0);
        System.out.println(findUnique(numbers));

        List<String> wordsList = List.of("bird", "fox", "cat", "bird", "dog", "cat", "cat", "fox", "dog", "racoon");
        calcOccurrence(wordsList);

        List<String> wordsList2 = List.of("bird", "fox", "cat", "bird", "dog", "cat", "cat", "fox", "dog", "racoon");
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
// Custom approach:
        List<Integer> res = new ArrayList<>();
        for (int i : list) {
            if (!res.contains(i)) {
                res.add(i);
            }
        }
        return res;

// Better one:
//        return new ArrayList<>(new HashSet<>(list));
    }

    public static void calcOccurrence(List<String> list) {
        Map<String, Integer> occurrenceMap = getOccurrenceMap(list);

        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(STR."\{entry.getKey()}: \{entry.getValue()}");
        }

    }

    public static List<Occurrence> findOccurrence(List<String> list) {
        Map<String, Integer> occurrenceMap = getOccurrenceMap(list);

        List<Occurrence> occurrences = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            occurrences.add(new Occurrence(entry.getKey(), entry.getValue()));
        }

        return occurrences;
    }

    private static Map<String, Integer> getOccurrenceMap(List<String> list) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : list) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }

        return occurrenceMap;

    }
}

