import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 
 */
public class SingleNumber {


    /**
     * Given a non-empty array of integers nums,
     * every element appears twice except for one. 
     * Find that single one.
     * 
     * Will use a set on this first attempt.
     * 
     * Runtime: 23 ms, faster than 9.88% of Java online submissions.
     * Memory Usage: 39.1 MB, less than 67.29% of Java online submissions.
     */
    static int singleNumber0(int[] nums) {

        // **** initialization ****
        TreeSet<Integer> set = new TreeSet<Integer>();

        // **** traverse the array ****
        for (int i = 0; i < nums.length; i++) {

            // **** check if in set ****
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
                
        }
        
        // **** return single number ****
        return set.first();
    }


    /**
     * Given a non-empty array of integers nums,
     * every element appears twice except for one. 
     * Find that single one.
     * 
     * Will use XOR on the second attempt.
     * 
     * Runtime: 1 ms, faster than 95.11% of Java online submissions.
     * Memory Usage: 38.8 MB, less than 94.63% of Java online submissions.
     */
    static int singleNumber(int[] nums) {

        // **** initialization ****
        int xor = nums[0];

        // **** loop through all entries in the array ****
        for (int i = 1; i < nums.length; i++)
            xor ^= nums[i];

        // **** return single number ****
        return xor;
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read the input into a int[] ****
        int[] arr = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close the buffere reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));

        // **** solve and display result ****
        System.out.println("main <<< output: " + singleNumber0(arr));

        // **** solve and display result ****
        System.out.println("main <<< output: " + singleNumber(arr));
    }
}