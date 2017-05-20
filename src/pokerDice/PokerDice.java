package pokerDice;

import java.util.Arrays;
import java.util.Random;
import java.io.BufferedReader;
/*
 * WORK IN PROGRESS 5/20/17
 */
import java.io.InputStreamReader;

/* This is an app for rolling and evaluating  dice. 
 * The app builds an array of possible sides. 
 * Each die is "rolled" randomly selects a "side" from the array and assigns a value adding it to the "hand" array. 
 * Once the "hand" has been filled and sorted, it is evaluated and produces the highest possible poker value * 
 */

public class PokerDice {
	
public static void main(String args[]) {
	
	 //initialize dicePool and call method to Try-Catch input conversion;
	int dicePool = convertInput();
	
		
	//pass number of dice to be Rolled
	int[] hand = RollDice(dicePool);
	
	//once dice values have been returned, sort them in numerical order and add the totals
	Arrays.sort(hand);
	int sum = AddDice(hand);
	
	//print the result of each die and the total sum
	for (int i = 0; i < hand.length; i++){
		System.out.println("You rolled a " + hand[i] + "!");
	}	
	System.out.println("Total Value: " + sum);
					
					
}//end main()

static int convertInput(){
	//accept user input and attempt to verify that it is a positive whole number
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("How many dice are you rolling?");
	int x = 0;
	try {
		String diceInput = br.readLine();
		x = Integer.parseInt(diceInput);		
	
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Whoa, Comrade...let's try this again using a whole number");
		convertInput();
	}	
	if (x <= 0){
		System.out.println("Come on man, how you gonna roll " + x + " dice?");
		x = convertInput();}	
	return x;
	}// end ConvertInput

static int[] RollDice(int x) {
	//accept number of dice in the pool, create an array of possible dice sides,
	//"roll" each die by selecting a random element, then return the entire array
		
	int arrayOfSides[] = {1,2,3,4,5,6};
	int hand[] = new int[x];  
	Random random = new Random();
	
	for (int i=0; i<hand.length; i++){
		hand[i] = random.nextInt(arrayOfSides.length);		
	}
	return hand;
			
}//end RollRice()
	
static int AddDice(int x[]){
	//accept the hand array and add up all the dice
	int sum = 0;
	for (int i=0; i < x.length; i++)
		sum = sum + x[i];	
	return sum;
			
}
	
}//end PokerDice class

/* MUST HAVE Checklist:
 * 
 * 1.) Die object
 * 2.) array of sides
 * 3.) Roll() method
 * 4.) Hand array
 * 5.) evaluation and presentation
 * 
 * WOULD LIKE checklist: 
 * 1.) Option to reroll individual dice
 * 2.) graphics
 * 3.) option to add more dice
 * 4.) evaluate multiple hands against each other *  
 *  
 */




