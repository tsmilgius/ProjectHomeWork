import java.util.Scanner;

/**
 * Created by tomas on 2017-01-22.
 * Programm asks user how many numbers he wants to enter. Then prompts to input every value. Results
 * display only those values that met conditions: larger that 50 and even.
 */
public class PromptNumbers {
    private static Scanner Input = new Scanner(System.in);
    private static int arraySize;
    private static final String WELLCOME_MESSAGE = "Hi, please enter how many numbers you would like to enter..";
    private static final String ERROR_MESSAGE = "You can enter only numbers! Program will terminate..";
    private static final String RESULT_MESSAGE = "These are number that met conditions: ";

    public static void main(String[] args) {
        System.out.println(WELLCOME_MESSAGE);
        try {
            arraySize = Input.nextInt();
        } catch (Exception e){
            System.out.println(ERROR_MESSAGE);
        }

        checkConditions(createArray(arraySize));

    }

    /**
     * makes array of int by prompting for every value
     * @param arraySize integer
     * @return array of integers
     */

    private static int[] createArray(int arraySize){
        int[] numbers = new int[arraySize];
        for (int i = 0; i < arraySize; i++){
            try {
                System.out.println("Please enter a number " + (i+1));
                numbers[i] = Input.nextInt();
            } catch (Exception e){
                System.out.println(ERROR_MESSAGE);
                System.exit(1);
            }
        }
        return numbers;
    }

    /**
     * Checks if conditions for displaying values are met
     * @param numbers integer
     */

    private static void checkConditions(int[] numbers){

        for (int number : numbers) {

            if (number > 50 && number % 2 == 0) {

                System.out.print(number);
            }
        }
    }






}
