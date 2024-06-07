package meghana;
import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int TotalMarks=0;
		float Percentage=0;
		
		System.out.println("WELCOME TO THE GRADE CALCULATOR!!!");
		System.out.println("Enter the total number of subjects");
		
		int NumberOfSubjects= scanner.nextInt();
		
		int[] MarksObtained= new int[NumberOfSubjects];
		
		System.out.println("Enter the marks obtained in each subject(out of 100)");
		
		for(int i=0;i<NumberOfSubjects;i++)
		{
			System.out.println("Enter the marks obtained in subject"+(i+1)+":\t");
			MarksObtained[i]=scanner.nextInt();
			TotalMarks =TotalMarks + MarksObtained[i];
		}
		
		Percentage=(float)(TotalMarks/NumberOfSubjects);
		
		System.out.println("The total marks obtained by the student is: "+TotalMarks);
		System.out.println("The percentage obtained by the student is: "+Percentage);
		
		if (91.0 <= Percentage && Percentage <= 100.0) {
		    System.out.println("The grade obtained by the student is A1");
		} else if (81.0 <= Percentage && Percentage < 91.0) {
		    System.out.println("The grade obtained by the student is A2");
		} else if (71.0 <= Percentage && Percentage < 81.0) {
		    System.out.println("The grade obtained by the student is B1");
		} else if (61.0 <= Percentage && Percentage < 71.0) {
		    System.out.println("The grade obtained by the student is B2");
		} else if (51.0 <= Percentage && Percentage < 61.0) {
		    System.out.println("The grade obtained by the student is C1");
		} else if (41.0 <= Percentage && Percentage < 51.0) {
		    System.out.println("The grade obtained by the student is C2");
		} else if (33.0 <= Percentage && Percentage < 41.0) {
		    System.out.println("The grade obtained by the student is D");
		} else {
		    System.out.println("The grade obtained by the student is E");
		}

		}

}
