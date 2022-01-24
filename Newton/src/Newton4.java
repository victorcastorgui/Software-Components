import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program will compute the square root of x. x will be given by the user
 * as it will prompt user.
 *
 * @author Victor Castor
 *
 */
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     * This is Newton's iteration method. This time it will receive two
     * parameter which is double x and double error. The user will input the
     * value of x and error and with that, we will calculate.
     *
     * @param x
     * @param error
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x, double error) {

        if (x < 0) {
            return Double.NaN;
        }
        if (x == 0) {
            return 0;
        }
        double squareRoot = x;
        while (Math.abs(squareRoot - x / squareRoot) > error * squareRoot) {
            squareRoot = (x / squareRoot + squareRoot) / 2.0;
        }
        return squareRoot;
    }

    /**
     * Main method where sqrt(double x) will be used. This will also prompt user
     * to enter number and keyboard loop or stop. Unlike the newton3. This main
     * method will not prompt the user for continue after calculation. Instead,
     * user can quit the program when negative value is entered.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        double x = 0.0;
        double errorNumber = 0.0;

        while (true) {
            if (x >= 0) {
                out.println("Please enter ε: ");
                errorNumber = in.nextDouble();
                out.println(
                        "Please enter a positive number to find square root: ");
                x = in.nextDouble();
                out.println("The Square Root is: " + sqrt(x, errorNumber));
            } else {
                out.println("You entered negative number program ended.");
                break;
            }
        }

        in.close();
        out.close();

    }

}
