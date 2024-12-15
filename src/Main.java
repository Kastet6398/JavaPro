import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random random;

    public static void main(String[] args) {
        random = new Random();
        System.out.println(findSymbolOccurrence("hello", 'l'));
        System.out.println(findSymbolOccurrence("hello", 'm'));
        System.out.println(findWordPosition("Apollo", "pollo"));
        System.out.println(findWordPosition("Apollo", "ha"));
        System.out.println(stringReverse("Hello"));
        System.out.println(isPalindrome("ERE"));
        System.out.println(isPalindrome("not"));
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        playWordGuessingGame(words);
    }


    public static int findSymbolOccurrence(String str, char symbol) {
        int count = 0;
        for (char i : str.toCharArray()) {
            if (i == symbol) {
                count++;
            }
        }
        return count;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        return str.equals(stringReverse(str));
    }

    public static void playWordGuessingGame(String[] words) {
        String chosenWord = words[random.nextInt(0, words.length)];
        StringBuilder guessedWord = new StringBuilder();
        guessedWord.append("#".repeat(15));
        Scanner scanner = new Scanner(System.in);
        while (!guessedWord.toString().equals(chosenWord)) {
            System.out.println(STR."Guess the word: \{guessedWord}");
            System.out.print("Your guess: ");
            String guess = scanner.nextLine().toLowerCase();
            if (guess.equals(chosenWord)) {
                System.out.println("Congratulations! You guessed the word!");
                break;
            } else {
                StringBuilder feedback = getFeedback(chosenWord, guess);

                System.out.println(feedback);
            }
        }
        scanner.close();
    }

    private static StringBuilder getFeedback(String chosenWord, String guess) {
        StringBuilder feedback = new StringBuilder();
        int j = -1;
        for (int i = 0; i < Math.min(guess.length(), chosenWord.length()); i++) {
            if (chosenWord.charAt(i) == guess.charAt(i)) {
                j = i;
            }
        }
        for (int i = 0; i < chosenWord.length(); i++) {
            if (i < chosenWord.length() - 1 && j == -1) {
                feedback.append("#".repeat(15));
                break;
            } else if (i < chosenWord.length() - 1 && i == j) {
                feedback.append(guess.charAt(i)).append("#".repeat(15));
                break;
            } else if (i < guess.length() && guess.charAt(i) == chosenWord.charAt(i)) {
                feedback.append(chosenWord.charAt(i));
            } else {
                feedback.append("#");
            }
        }

        return feedback;
    }
}