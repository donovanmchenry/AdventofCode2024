import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        // Read the numbers
        try (BufferedReader reader = new BufferedReader(new FileReader("nums.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");
                if (numbers.length == 2) {
                    leftList.add(Integer.parseInt(numbers[0]));
                    rightList.add(Integer.parseInt(numbers[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculate similarity score
        long totalScore = 0;
        for (int leftNum : leftList) {
            int occurrences = 0;
            // Count how many times this left number appears in right list
            for (int rightNum : rightList) {
                if (leftNum == rightNum) {
                    occurrences++;
                }
            }
            
            long score = (long) leftNum * occurrences;
            totalScore += score;
            
            // Print details for each number
            System.out.println("Number " + leftNum + " appears " + occurrences + 
                             " times in right list, contributing: " + score);
        }

        System.out.println("Total similarity score: " + totalScore);
    }
}
