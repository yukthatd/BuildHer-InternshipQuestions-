//MajoritElement.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MajorityElement {

    public static List<Integer> findMajorityElements(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        int n = nums.length;

        if (count1 > n / 3) {
            result.add(candidate1);
        }

        if (count2 > n / 3 && candidate1 != candidate2) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        while (true) {
            System.out.print("Enter the size of the array (n): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); 
        }

        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            while (true) {
                if (scanner.hasNextInt()) {
                    nums[i] = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next();
            }
        }

        List<Integer> majorityElements = findMajorityElements(nums);
        System.out.println("Majority Elements: " + majorityElements);
    }
}
