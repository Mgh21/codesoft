// Problem Statement
//1.Generate a random number with a specified range
//2.Prompt the user to provide a guess
//3.compare the user guess to the generated number and provide feedback with message
//4.limited number of guesses for each user
 

package meghana;
import java.util.Scanner;
import java.util.Random;

public class NumberGame {

	public static void main(String[] args) {
		
		// To generate a random number in the range(1,50)
		Random rand=new Random();
		int min=1;
		int max=50;
		int randomNumber=rand.nextInt(max-min)+min;
		
		//Taking the guess from the user
		Scanner scanner= new Scanner(System.in);
		System.out.println("WELCOME TO NUMBER GAME!!");
		System.out.println("A number is chosen between 1 to 50.\nGuess the number within 5 trials.");
		
		// The number of tries the player is allowed, k=5
		int k=5;
		int count=1;
		for(int i=0;i<k;i++)
		{
			
			System.out.println("Enter your guess: ");
			int guess= scanner.nextInt();
			if (guess==randomNumber)
			{
				System.out.println("You guessed the correct number!!");
				break;
			}
			else if(guess<randomNumber && i != k - 1)
			{
				System.out.println("The guessed number is less then the generated number.");
				count++;
				continue;
			}
			else if (guess>randomNumber && i != k - 1)
			{
				System.out.println("The guessed number is more then the generated number.");
				count++;
				continue;
			}
			else {
				System.out.println("You have exhausted"+ " K trials.");
			}
			
		}		
			System.out.println("The number was " + randomNumber);
		    System.out.println("The number is guessed after "+count+" number of times");
		    
		    
	}
}