import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class HelloJack {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HelloJack() {

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome! Please enter your name: ");

        SimpleReader in = new SimpleReader1L();
        String line = in.nextLine();
        SimpleWriter out = new SimpleWriter1L();
        out.println("Hello, " + line);

        in.close();
        out.close();
    }

}
