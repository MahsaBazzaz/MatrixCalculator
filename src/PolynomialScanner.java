import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * the polynomial scanner class
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public class PolynomialScanner {
    int zaribeX;
    int zaribeY;
    String operand;

    public PolynomialScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your polynomial expression: ");
        String input = scanner.nextLine();
        // removing all the spaces and lowercase all
        input = input.replaceAll(" ", "").toLowerCase();
        //the input pattern
        Pattern pattern = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        Matcher matcher = pattern.matcher(input);
        //find out Coefficient of x and y
        int i = 0;
        String[] detail = new String[3];
        while (matcher.find()) {

            detail[i++] = matcher.group(1);

        }
        //let's check the conditions
        //if wrong input
        if (detail.length == 0) {
            System.out.println("INVALID INPUT!!");
            throw new InvalidParameterException();
        }
        //if there was no Y
        else if (!input.contains("x")) {
            if (detail[0].replace('x', ' ').trim().equals("")) {
                detail[0] = "1x";
            }
            zaribeY = Integer.parseInt(detail[0]);
            operand = "y";
        }
        //if there was not x
        else if (!input.contains("y")) {
            if (detail[1] == null) {
                detail[1] = "1";
            }
            zaribeX = Integer.parseInt(detail[0].replace('x', ' ').trim());
            operand = "x";
        }
        //there are x and y
        else {
            int xindex = input.indexOf("x");
            int yindex = input.indexOf("y");
            //if x is ahead
            if (yindex > xindex) {
                //what's the operand
                operand = input.substring(xindex + 1, xindex + 2);
                //check if the Coefficient of x is 1
                if (detail[0].replace('x', ' ').trim().equals("")) {
                    detail[0] = "1x";
                }
                //check if the Coefficient of y is 1
                if (detail[1] == null) {
                    detail[1] = "1";
                }
                //Coefficient change string to int
                zaribeX = Integer.parseInt(detail[0].replace('x', ' ').trim());
                zaribeY = Integer.parseInt(detail[1]);

            }
            //if y is ahead
            else { //yindex<xindex
                //what's the operand
                operand = input.substring(yindex + 1, yindex + 2);
                //let's check the special conditions first
                //check if Coefficient of y is 1
                if (detail[1] == null) {
                    zaribeY = 1;
                    String a = detail[0].replace('x', ' ').trim();
                    String b = a.replace('-', ' ').trim();
                    if (b.equals("")) {
                        b = "1";
                    }
                    zaribeX = Integer.parseInt(b);
                }
                //check if Coefficient of x is 1
                else if (detail[1].replace('x', ' ').trim().equals("")) {
                    detail[1] = "1x";
                    if (detail[0] == null) {
                        detail[0] = "1";
                    }
                    zaribeX = Integer.parseInt(detail[1].replace('x', ' ').trim());
                    zaribeY = Integer.parseInt(detail[0]);
                }
                //
                else if (detail[1].replace('x', ' ').trim().equals("-")) {
                    zaribeX = -1;
                    zaribeY = Integer.parseInt(detail[0]);
                }
                //the general condition
                else {
                    zaribeX = Integer.parseInt(detail[1].replace('x', ' ').trim());
                    zaribeY = Integer.parseInt(detail[0]);
                }
            }
            //considering the special conditions
            if (!operand.equals("*") && Math.abs(zaribeY) > 1) {
                operand = "+";
            }

        }
//        test:
//        System.out.println("operand is:" +operand);
//        System.out.println("zaribe x: " + zaribeX);
//        System.out.println("zaribe y: " + zaribeY);
    }

    /**
     * to get Coefficient of x
     *
     * @return zaribe x
     */
    public int getZaribeX() {
        return zaribeX;
    }

    /**
     * to get Coefficient of y
     *
     * @return zaribe y
     */
    public int getZaribeY() {
        return zaribeY;
    }

    /**
     * to get the operand
     *
     * @return operand
     */
    public String getOperand() {
        return operand;
    }
}
