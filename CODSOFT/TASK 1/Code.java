import java.util.*;
public class Code{
	public static void NumberGame(){

        while(true){
		Scanner sc = new Scanner(System.in);
		int number = 1 + (int)(100 * Math.random());			
		int attempts = 5;
		int i, guess;

		System.out.println("A number is to be chosen between 1 to 100.");
		System.out.println("Guess the number within 5 trials.");

    
        for (i = 0; i < attempts; i++) {
			System.out.println("Guess the number:");
			guess = sc.nextInt();

			if (number == guess) {
				System.out.println("Congratulations! You have guessed the number.");
				break;
			}
			else if (number > guess) {
				System.out.println("The number is greater than " + guess);
			}
			else if (number < guess) {
				System.out.println("The number is less than " + guess);
			}
		}

		if (i == attempts) {
			System.out.println("You have exhausted all the trials.");
			System.out.println("The number was " + number);
		}

        System.out.println("Do you want to continue yes or no");
        String c = sc.next();

        if(c.equalsIgnoreCase("no")){ 
            break;
        }
      } 
	}

	public static void main(String args[]){
		NumberGame();
	}
}