import java.util.*;

public class StudentGradesTracker {

    public static void main(String[] args) {
        ArrayList<Double> grades = collectGrades();
        
        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
            return;
        }
        
        double average = calculateAverage(grades);
        double highest = findHighest(grades);
        double lowest = findLowest(grades);
        
        displayResults(average, highest, lowest);
    }

    // Function to collect grades from the teacher
    private static ArrayList<Double> collectGrades() {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        
        System.out.println("Enter student grades. Type 'done' to finish:");
        while (true) {
            System.out.print("Enter grade: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double grade = Double.parseDouble(input);
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade.");
            }
        }
        scanner.close();
        
        return grades;
    }

    // Function to calculate the average grade
    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Function to find the highest grade
    private static double findHighest(ArrayList<Double> grades) {
        double highest = Double.MIN_VALUE;
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Function to find the lowest grade
    private static double findLowest(ArrayList<Double> grades) {
        double lowest = Double.MAX_VALUE;
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    // Function to display the results
    private static void displayResults(double average, double highest, double lowest) {
        System.out.println("\nGrades Summary:");
        System.out.println("Average score: " + average);
        System.out.println("Highest score: " + highest);
        System.out.println("Lowest score: " + lowest);
    }
}
