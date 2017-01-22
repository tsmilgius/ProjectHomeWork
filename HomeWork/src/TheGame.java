import java.util.Random;
import java.util.Scanner;

/**
 * Created by tomas on 2017-01-22.
 * Simple number guessing game. User guess number between 1 and 10. The game continues until number is guessed, or
 * user selects 0 as an answer. If gusee is incorrect new number is generated and game continues. Program terminates
 * if user's guess is higher than 10 or not a number. After guessingcorrect number, the programm shows how many tries
 * it took to guess the right number.
 */


public class TheGame {

    private final static String WELCOME_MESSAGE = "Labas, pabandyk atspėti skaičių nuo 1 iki 10. Jei nori pabaigti spausk 0";
    private final static String GUESSED_MESSAGE = " Atpėjai! ";
    private final static String MISSED_MESSAGE = "Neatspėjai,";
    private final static String GOODBYE_MESSAGE = "Viso gero! ";
    private final static String ONE_MORE_TIME = " bandom iš naujo";
    private final static String GENERATED_MESSAGE = " mano sugalvotas skaičius buvo ";
    private final static String ERROR_MESSAGE = "Galima įvesti tik skaičius nuo 1 iki 10 arba 0 išėjimui";
    private static int generated;
    private static  TheGame Game = new TheGame();
    private static Scanner Input = new Scanner(System.in);
    private static int guess;
    private static boolean gameState = true;


    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        int counter = 0;
        while(gameState) {
            try {
                generated = Game.generateNumber();
                counter++;
                guess = Input.nextInt();
                Game.checkIfGuessed(guess, generated);

            } catch (Exception e){
                System.out.println(ERROR_MESSAGE);
                System.exit(1);
            }
        }
        System.out.println("Tau prireikė " + counter + " kartų, kad atspėtum mano sugalvotą skaičių");
    }

    /**
     * generates a random number between 1 and 10 and returs it
     */
    private  int generateNumber(){
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

    /**
     * Checks the answer and generates message according the outcome. It also changes gameState variable to false if
     * win/exit conditions are met. If input is higher than 11 it terminates the program shows ERROR_MESSAGE.
     * @param guess and genereated - integers;
     *
     */

    private void checkIfGuessed(int guess, int generated){
        if(guess == generated){
            System.out.println(GUESSED_MESSAGE + GOODBYE_MESSAGE);
            gameState = false;
        }
        else if (guess == 0){
            System.out.println(GOODBYE_MESSAGE + GENERATED_MESSAGE + generated );
            gameState = false;
        }
        else if (guess > 10){
            System.out.println(ERROR_MESSAGE);
            System.exit(1);
        }
        else{
            System.out.println(MISSED_MESSAGE + GENERATED_MESSAGE + generated + ONE_MORE_TIME);
            gameState = true;
        }
    }
}
