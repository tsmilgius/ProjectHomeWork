import java.util.Random;
import java.util.Scanner;

/**
 * Created by tomas on 2017-01-22.
 * Simple number guessing game. User gues
 */


public class TheGame {

    final static String WELCOME_MESSAGE = "Labas, pabandyk atspėti skaičių nuo 1 iki 10. Jei nori pabaigti spausk 0";
    final static String GUESSED_MESSAGE = " Atpėjai! ";
    final static String MISSED_MESSAGE = "Neatspėjai,";
    final static String GOODBYE_MESSAGE = "Viso gero! ";
    final static String ONE_MORE_TIME = " bandom iš naujo";
    final static String GENERATED_MESSAGE = " mano sugalvotas skaičius buvo ";
    final static String ERROR_MESSAGE = "Galima įvesti tik skaičius nuo 1 iki 10 arba 0 išėjimui";
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
    public  int generateNumber(){
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

    /**
     * Checks the answer and generates message according the outcome. It also changes gameState variable to false if
     * win/exit conditions are met. If input is higher than 11 it terminates the program and
     * @param guess
     * @return
     */

    public void checkIfGuessed(int guess, int generated){
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
