import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Task3 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int secondNumber = target - nums[i];
            if (numberMap.containsKey(secondNumber)) {
                return new int[] { numberMap.get(secondNumber), i };
            }
            numberMap.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[] {3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[] {3,3}, 6)));
    }
}
