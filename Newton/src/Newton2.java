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
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     * This is Newton's iteration method. The error will be 0.0001. In this
     * static method, the program now be able to receive 0 but not negative
     * values.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {

        if (x < 0) {
            System.out.println("Invalid number.");
            return Double.NaN;
        }
        if (x == 0) {
            return 0;
        }
        double squareRoot = x;
        final double error = 0.0001; //1E-15 //
        while (Math.abs(squareRoot - x / squareRoot) > error * squareRoot) {
            squareRoot = (x / squareRoot + squareRoot) / 2.0;
        }
        return squareRoot;
    }

    /**
     * Main method where sqrt(double x) will be used. This will also prompt user
     * to enter number and keyboard loop or stop.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        double x = 0.0;
        String y;

        while (true) {
            out.println("Please enter a positive number to find square root: ");
            x = in.nextDouble();
            out.println("The Square Root is: " + sqrt(x));
            out.println(
                    "Press y to coninue (any other will end the program): ");
            y = in.nextLine();
            if (y.equalsIgnoreCase("y") || y.equalsIgnoreCase("Y")) {
                continue;
            } else {
                out.println("You entered other than y so the program ended");
                break;
            }
        }

        in.close();
        out.close();

    }

}
