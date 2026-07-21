import java.util.Scanner;

public class studentgrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3; // number of subjects
        int[] marks = new int[n];
        int total = 0;

        // Loop to input marks for each subject
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];
        }

        double average = (double) total / n;

        // Determine grade using if-else
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 60) {
            grade = 'C';
        } else if (average >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\n--- Result ---");
        System.out.println("Total Marks : " + total);
        System.out.println("Average     : " + average);
        System.out.println("Grade       : " + grade);

        sc.close();
    }
}