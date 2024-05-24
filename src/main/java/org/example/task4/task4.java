package org.example.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class task4 {
    public static void main(String[] args) {
        String fileName = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<Integer> nums = new ArrayList<>();

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                int num = Integer.parseInt(line);
                nums.add(num);
            }
            nums.sort(Integer::compareTo);

            int sum = 0;
            int median;

            if (nums.size() % 2 == 0) {
                median = (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 + 1)) / 2;
            } else {
                median = nums.get(nums.size() / 2);
            }

            for (int num : nums) {
                sum += Math.abs(num - median);
            }

            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
