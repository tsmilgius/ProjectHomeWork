import java.util.Scanner;
import java.util.Arrays;



/**
 * Created by tomas on 2017-01-22.
 * Mani
 */
public class OneDimensionalArray {
    final static String GREETING_MESSAGE = "Įveskite masyvo dydį";
    final static String CREATED_MESSAGE = "Suformuotas toks masyvas:";
    final static String MANIPULATION_MESSAGE = "Po manipuliacijų masyvas atvaizduojamas taip:";
    public static Scanner Input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.println(GREETING_MESSAGE);
        int arraySize = Input.nextInt();
        OneDimensionalArray Array = new OneDimensionalArray();

        System.out.println(CREATED_MESSAGE);
        int[] originalArray = Array.createArray(arraySize);
        System.out.println(Arrays.toString(originalArray));
        System.out.println(MANIPULATION_MESSAGE);
        modifyArray(originalArray);
    }

    /**
     * Creates one dimensional array of length 'arraySize', and fills with values coressponding
     * to the position number e.g arraySize[0] = 0, arraySize[1] = 1. If value is odd it becomes
     * negative. Returns int[].
     * @param arraySize int
     * @return array of int
     */
    public int[] createArray(int arraySize){
        int[] arraym = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arraym[i] = i;
            if(arraym[i] % 2 != 0) {
                arraym[i] *= -1;
            }
        }
        return arraym;
    }

    /**
     * Modifies int[] which is given as parameter: all values which are multiples of 3 are multiplied by 2.
     * Other values are not changed. Then method prints all values from the highest position using for loop and
     * step variable 2; to ensure all the values are printed out (including  position 0) method checks if the length
     * of the given array is even. Depending on the outcome it prints 2 values at the time.
     * @param arrayForModification int[].
     */

    public static void modifyArray(int[] arrayForModification) throws InterruptedException {
        for (int i = 0;  i < arrayForModification.length; i++){
            if( arrayForModification[i] % 3 == 0) {
                arrayForModification[i] *= 2;
            }
        }

            if (arrayForModification.length % 2 == 0) {
                for(int j = arrayForModification.length - 1; j > 0; j -= 2 ) {
                    System.out.println(arrayForModification[j]);
                    System.out.println(arrayForModification[j - 1]);
                }
            } else {
                for (int j = arrayForModification.length - 1; j > 0; j -= 2) {
                    System.out.println(arrayForModification[j]);
                    System.out.println(arrayForModification[j - 1]);
                }
                System.out.println(arrayForModification[0]);

            }

    }
}
