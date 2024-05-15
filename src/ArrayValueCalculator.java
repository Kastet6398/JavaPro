import java.util.Arrays;

public class ArrayValueCalculator {
    public static int doCalc(String[][] numbers) throws ArraySizeException, ArrayDataException {
        if (numbers.length != 4) {
            throw new ArraySizeException("The size of the numbers must be 4x4");
        }

        for (String[] arr : numbers) {
            if (arr.length != 4) {
                throw new ArraySizeException("The size of the numbers must be 4x4");
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(numbers[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Malformed data in cell: row: " + i + ", column: " + j, i, j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] numbers = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = doCalc(numbers);
            System.out.println("Result: " + result);
        } catch (ArraySizeException e) {
            System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (ArrayDataException e) {
            System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
