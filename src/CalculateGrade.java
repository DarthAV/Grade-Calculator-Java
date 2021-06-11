/* Ansh Verma
 * 
 * 
 * Helps you figure out the lowest score 
 * you can get on any assignment
 * without going below 90%
 * 
 */

import java.util.*;

public class CalculateGrade {

	public static String className = "";
	public static double otherGrades = 0.0;
	public static int weight = 0;
	public static double currentGrade = 0.0;
	public static double possiblePointsCat = 0.0;
	public static double currentPointsCat = 0.0;
	public static int possiblePoints = 0;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		GUI f = new GUI();
		f.setVisible(true);

		// boolean again = true;
		// while (again) {
		// ask();
		// calculate();
		// while (true) {
		// System.out.println("Do you want to calculate another assignment in this
		// class? (Y or N)");
		// String input = scanner.next();
		// if (input.compareToIgnoreCase("n") == 0) {
		// break;
		// } else if (input.compareToIgnoreCase("y") == 0) {
		// calculate();

		// } else {
		// System.out.println("Invalid Input: Please try again. Input must be \"Y\" or
		// \"N\"");
		// }
		// }
		// System.out.println("Do you want to calculate another assignment? (Y or N)");
		// while (true) {
		// String input = scanner.next();
		// if (input.compareToIgnoreCase("n") == 0) {
		// again = false;
		// break;
		// } else if (input.compareToIgnoreCase("y") == 0) {
		// again = true;
		// break;
		// } else {
		// System.out.println("Invalid Input: Please try again. Input must be \"Y\" or
		// \"N\"");
		// }
		// }
		// className = "";
		// otherGrades = 0.0;
		// weight = 0;
		// currentGrade = 0.0;
		// possiblePointsCat = 0.0;
		// currentPointsCat = 0.0;
		// possiblePoints = 0;
		// }
		// System.out.println("\n\nThank You!\nThis program was created by Ansh Verma");

	}

	public static void ask() {

		scanner = new Scanner(System.in);
		System.out.print("Enter your class name: ");
		className = scanner.nextLine();

		System.out.print("Enter the weight(Number) of the category the assignment is in: ");
		weight = scanner.nextInt();

		System.out.print("Enter your current class grade(Decimal): ");
		currentGrade = scanner.nextDouble();

		System.out.print("Enter the possible points(Decimal) in the category: ");
		possiblePointsCat = scanner.nextDouble();

		System.out.print("Enter your current points(Decimal) in the category: ");
		currentPointsCat = scanner.nextDouble();

		otherGrades = currentGrade - (currentPointsCat / possiblePointsCat) * weight;

	}

	public static void askPointsAssignment() {
		System.out.print("Enter the possible points(Number) for the assignment: ");
		possiblePoints = scanner.nextInt();
	}

	public static void calculate() {

		askPointsAssignment();

		// finds lowest possible score you can get
		double lowestPoints = possiblePoints;
		double percentWithLowScore = 100.0;

		for (double i = possiblePoints; i >= 0; i -= 0.1) {

			double newGrade = calculatePercent(i);
			if (newGrade < 90) {
				break;
			}
			percentWithLowScore = calculatePercent(i);
			lowestPoints = i;

		}

		double lowestPercent = lowestPoints / possiblePoints;

		// finds the highest class percentage you can possibly achieve
		double percentWithHighScore = calculatePercent(possiblePoints);

		// round everything to two decimal places
		lowestPoints = (double) ((int) (((double) lowestPoints) * 100)) / 100;
		lowestPercent = (double) ((int) (((double) (lowestPercent * 100)) * 100)) / 100;
		percentWithLowScore = (double) ((int) (((double) percentWithLowScore) * 100)) / 100;
		percentWithHighScore = (double) ((int) (((double) percentWithHighScore) * 100)) / 100;

		try {
			Thread.sleep(100);

			System.out.println("\n\n\n-----------------------------------");

			// prints out everything
			System.out.println("Your current grade is " + currentGrade + " in " + className);
			Thread.sleep(500);
			System.out.println(
					"To get above a 90% in " + className + ", your grade on the assignment " + "needs to be at least "
							+ lowestPoints + "/" + possiblePoints + " or about " + lowestPercent + "%");
			System.out.println("\nGetting this score would put your grade at " + percentWithLowScore + "%");
			Thread.sleep(500);
			System.out
					.println("If you get 100% on this test, your grade in this class would be " + percentWithHighScore);

			System.out.println("-----------------------------------\n");
			Thread.sleep(1500);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static double calculatePercent(double points) {
		return ((points + currentPointsCat) / (possiblePointsCat + possiblePoints) * weight) + otherGrades;
	}
}
