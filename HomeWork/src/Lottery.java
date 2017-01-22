import java.util.Scanner;

/**
 * Created by tomas on 2017-01-22.
 * Program checks if 6 digit lotto ticket is lucky. The winning conditions are met if the sum of the first three digits
 * equals to the sum of the last three digits. As additional feature it may print all lucky 6 digit numbers (uncomment
 * line 19)
 */
public class Lottery {
    private static Scanner Input = new Scanner(System.in);
    private static int lottoNumber;
    private static final int DIGIT_NUMBERS = 6;
    private static final String WIN_MESSAGE = "Jūsų bilietas laimėjo!";
    private static final String TRY_AGAIN_MESSAGE = "Jūsų bilietas nieko nelaimėjo, bandykite dar kartą";
    private  static final String INVALID_NUMBER = "Greičiausiai tai ne šios loterijos bilietas";
    private static final String WELCOME_MESSAGE = "Sveiki, įveskite šešiaženklį loterijos numerį.";

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        //generateAllLuckyNumbers();
        try{
        lottoNumber = Input.nextInt();
        } catch (Exception e){
            System.out.println(INVALID_NUMBER);
            System.exit(1);
        }
        if(validateTicketNumber(lottoNumber)){
            if (checkWin(lottoNumber)) {
                System.out.println(WIN_MESSAGE);
            } else {
                System.out.println(TRY_AGAIN_MESSAGE);
            }
        } else {
            System.out.println(INVALID_NUMBER);
        }
    }

    /**
     * manualy separate all 6 digits of the lottery ticket tnumber to produce an array of integers
     * @param lottoNumber integer
     * @return int[6]
     */
    private static int[] separateDigits(int lottoNumber){
        int[] digits = new int[DIGIT_NUMBERS];
        digits[0] = lottoNumber / 100000;
        digits[1] = (lottoNumber / 10000)%10;
        digits[2] = (lottoNumber / 1000)%10;
        digits[3] = (lottoNumber / 100)%10;
        digits[4] = (lottoNumber / 10)%10;
        digits[5] = lottoNumber % 10;
        return digits;
    }

    /**
     * Checks if both winning conditions are met.
     * @return boolean true if win, false otherwise
     */
    private static boolean checkWin(int lottoNumber){
        return compareSums(separateDigits(lottoNumber)) && checkIfDigitsAreDistinct(separateDigits(lottoNumber));
    }

    /**
     * Checks on of the winning condition. If the Sum of he first three digits is the same as the
     * sum of the last three digits
     * @param lottoNumbers int[]
     * @return true if sums are equal, false otherwise.
     */
    private static boolean compareSums(int[] lottoNumbers){
        int sumFirstThreeDigits = 0;
        int sumLastThreeDigits = 0;
        for (int i = 0; i < 3; i++){
            sumFirstThreeDigits += lottoNumbers[i];
        }
        for (int j = 3; j < 6; j++){
            sumLastThreeDigits += lottoNumbers[j];
        }
        return sumFirstThreeDigits == sumLastThreeDigits;
    }

    /**
     * Check if on of the winning condition is met: if all digits are not equal.
     * @param lottonumbers int[]
     * @return true or false
     */
    private static boolean checkIfDigitsAreDistinct(int[] lottonumbers){
        //boolean condition = false;
        for (int i = 0; i < lottonumbers.length-1; i++) {
            for(int j = i + 1; j < lottonumbers.length; j++){
                if(i != j && lottonumbers[i] == lottonumbers[j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Validates if ticket number: 6 only digits;
     */
    private static boolean validateTicketNumber(int lottoNumber){
        return (int) (Math.log10(lottoNumber) + 1) == 6;
    }

    /**
     * Generates all lucky numbers and prints them with total lucky numbers count.
     */
    private static void generateAllLuckyNumbers(){
        int counter = 0;
        for(int i = 0; i <= 999999; i++){
            if(checkWin(i) && validateTicketNumber(i)){
                    System.out.println("Lucky " + i);
                    counter++;
                }
            }
        System.out.println("Total lucky numbers: " + counter);
    }

}
