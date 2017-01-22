import java.util.Scanner;

/**
 * Created by tomas on 2017-01-22.
 * Programm asks user how many numbers he wants to enter.
 */
public class PromptNumbers {
    private static Scanner Input = new Scanner(System.in);
    private static int arraySize;


    public static void main(String[] args) {
        try {
            arraySize = Input.nextInt();
        } catch (Exception e){
            System.out.println("You can enter only numbers");
            System.exit(1);
        }



    }

    private static int[] createArray(int arraySize){
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++){

        }
        return array;

    }




}
