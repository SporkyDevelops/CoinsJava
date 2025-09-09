import java.text.DecimalFormat;
import java.util.Scanner;

//WARNING very unoptomized
public class App {
    public static void main(String[] args) {

        //ANSI unix color codes (Found on overflow)
        //https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
        final String CLEAR_ANSI = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_BLUE = "\u001B[34m";

        //Setup scanner for input
        Scanner scanner = new Scanner(System.in);

        //initialize arrays
        String[] coin = {"Quarters", "Dimes", "Nickels", "Pennies"};
        double[] value = {0.25, 0.10, 0.05, 0.01};
        int[] roll = {40, 50, 40, 50};

        //Declares numCoin as a new array with size of 4
        //Switched from int to long to increase max value (up to 9223372036854775806 coins)
        long[] numCoin = new long[4];

        DecimalFormat currencyDecimalFormat = new DecimalFormat("$#.##");

        System.out.println(ANSI_BLUE + "Welcome to Coin Program!");


        System.out.println(ANSI_GREEN + "\nInput the number of coins you have below \u2193");

            for (int i = 0; i < 4; i++) {

                try {
                    //Prints Coin Names then takes input for each
                    System.out.print(ANSI_GREEN + coin[i] + ": " + CLEAR_ANSI);
                    numCoin[i] = scanner.nextLong();
                }

                catch (Exception e){
                    //Exits program if input type is wrong
                    System.out.println(ANSI_RED + "Err: Please input an integer");
                    System.exit(i);
                }

            }

            scanner.close();
            //Clear text coloring
            System.out.println(CLEAR_ANSI + "\nPart 1: ");

            //interates through and prints values per coins
            for (int i = 0; i < 4; i++) {

                System.out.print("There are " + ANSI_GREEN + numCoin[i] + CLEAR_ANSI + " " + coin[i] + " worth: ");
                //Prints cash value in propper 2 decimal place format
                System.out.println(ANSI_GREEN + currencyDecimalFormat.format((numCoin[i]*value[i])) + CLEAR_ANSI);
            }

            System.out.println( "\nPart 2: ");

            for (int i = 0; i < 4; i++){

                long numRoll = numCoin[i] / roll[i];
                long extraCoin = numCoin[i] % roll[i];

                //multiplies the ammount of rolls, how many coins are in it, and how much its worth
                //e.g. (4 rolls * 40 * 0.25)
                double valueInRoll = numRoll * roll[i] * value[i];

                /* tested output
                System.out.println(coin[i] + " " + numCoin[i] + " " + numRoll + " " + extraCoin + " " + moneyInRoll); */

                System.out.println("There are: " + ANSI_GREEN + numRoll + CLEAR_ANSI + " rolls of " + ANSI_GREEN + coin[i] + CLEAR_ANSI);

                System.out.println("There are: " + ANSI_RED + extraCoin + " " + coin[i] + CLEAR_ANSI + " extra");

                System.out.println("The total value of " + ANSI_GREEN + coin[i] + CLEAR_ANSI + " in rolls is: " + ANSI_GREEN + currencyDecimalFormat.format(valueInRoll) + CLEAR_ANSI);
                System.out.println("The total value of " + ANSI_RED + coin[i] + CLEAR_ANSI + " extra coins is: " + ANSI_RED + currencyDecimalFormat.format(extraCoin * value[i]) + CLEAR_ANSI + "\n");
            }

            System.out.println("\nPart 3:");

            double total = 0.0;
            for (int i = 0; i < 4; i++) {

                total += numCoin[i]*value[i];
            }

            System.out.print(ANSI_BLUE + "The total value of all coins is: " + currencyDecimalFormat.format(total));
            
    }
}
