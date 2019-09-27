
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * the main class
 *
 * @author Mahsa Bazzzaz 9631405
 * @version 0.0
 */


public class Main {
    public static void main(String[] args) {
        try {

        //scan the matrix
        MatrixScanner scanner = new MatrixScanner();
        //scan the polynomial expression
        PolynomialScanner s = new PolynomialScanner();
        //do the math and print
        Operation op = new Operation(s.getOperand(), scanner.getX(), scanner.getY(), s.zaribeX, s.zaribeY, scanner.getLen());
        //manage the exceptions
        } catch (Exception e){
            System.out.println("ERROR::THE INPUT IS INVALID");
        }
    }//main
}//Main
