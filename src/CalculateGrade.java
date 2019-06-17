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
	
	
	
	
	public static void main(String[] args) {
		
		/*
        GUI f = new GUI();
        f.setVisible(true);
		*/
		//initialize the scanner object
		Scanner scanner = new Scanner(System.in);
	
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
		
		System.out.print("Enter the possible points(Number) for the assignment: ");
		possiblePoints = scanner.nextInt();
		
		otherGrades = currentGrade - (currentPointsCat / possiblePointsCat) * weight; 
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		
		//finds lowest possible score you can get
		double lowestPoints = possiblePoints;
		double percentWithLowScore = 100.0;
		
		for(double i = possiblePoints; i >= 0; i-=0.1) {
			
			double newGrade = calculatePercent(i);
			if(newGrade < 90) {
				break;
			}
			percentWithLowScore = calculatePercent(i);
			lowestPoints = i;
			
		}
		
		double lowestPercent = lowestPoints/possiblePoints;

		
		//finds the highest class percentage you can possibly achieve
		double percentWithHighScore = calculatePercent(possiblePoints);

		//round everything to two decimal places
		lowestPoints = (double)((int)(((double)lowestPoints)*100))/100;
		lowestPercent = (double)((int)(((double)(lowestPercent * 100))*100))/100;
		percentWithLowScore = (double)((int)(((double)percentWithLowScore)*100))/100;
		percentWithHighScore = (double)((int)(((double)percentWithHighScore)*100))/100;
				
		
		
		
				

		
		//prints out everything
		System.out.println("Your current grade is " + currentGrade + " in " + className);
		System.out.println("To get above a 90% in " + className + ", your grade on the assignment "
								+ "needs to be at least " + lowestPoints + "/" + possiblePoints 
								+ " or about " + lowestPercent + "%");
		System.out.println("Getting this score would put your grade at " + percentWithLowScore + "%");
		
		System.out.println("\n\nIf you get 100% on this test, your grade in this class would be " + percentWithHighScore);
		
		
		System.out.println("\n\nThis program was created by Ansh Verma");
	}
	
	public static double calculatePercent(double points) {
		return ((points + currentPointsCat) / 
				(possiblePointsCat + possiblePoints) * 
				weight) + otherGrades;		
	}
}
	
