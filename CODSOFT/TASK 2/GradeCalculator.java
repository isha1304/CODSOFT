import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total number of subjects: ");
        int num = sc.nextInt();

        double total_marks = 0;
        for (int i = 1; i <= num; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            double marks = sc.nextDouble();
            total_marks += marks;
        }

        double averagePercentage = total_marks / num;

        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
         sc.close();
        System.out.println("Total Marks: " + total_marks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}