import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * the matrix scanner class
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public class MatrixScanner {
    int len = 0;
    int[][] x;
    int[][] y;

    public MatrixScanner() {
        int c = 0;
        Boolean flag = true;
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        String temp = "";
        String temporary = "";
        System.out.println("Define the first matrix (X):");
        while (flag) {
            if (!(temp = scan.nextLine()).isEmpty()) { //if hasn't finished
                //check is that an acceptable input or not
                Pattern pattern = Pattern.compile("^(\\d,?)+$");
                Matcher matcher = pattern.matcher(temp);
                if (!matcher.matches())
                    throw new InvalidParameterException();
                //between each matrix element
                temporary += temp + "#";
            } else {
                //the finish point
                if (counter > 2) {
                    flag = false;
                }
                counter++;
                //between two matrix
                if (temp.isEmpty())
                    temporary += "&";
                //show the right massage
                if (c < 1) {
                    System.out.println("Define the second matrix (Y):");
                    c++;
                }
            }
        }//while
        //split the matrix
        String[] splitmatrixes = temporary.split("&");
        //split the lines
        String[] mat1 = splitmatrixes[0].split("#");
        String[] mat2 = splitmatrixes[1].split("#");
        String[] mat1String;
        String[] mat2String;
        //are those matrix acceptable?
        if (mat1.length != mat2.length) {
            System.out.println("INVALID MATRIX");
            throw new InvalidParameterException();

        }
        //what is the length
        else {
            len = mat1.length;
        }
        this.x = new int[len][len];
        this.y = new int[len][len];
        for (int i = 0; i < len; i++) {
            //split the elements
            mat1String = mat1[i].split(",");
            mat2String = mat2[i].split(",");
            for (int j = 0; j < len; j++) {
                this.x[i][j] = Integer.parseInt(mat1String[j]);
                this.y[i][j] = Integer.parseInt(mat2String[j]);
                //test:
//                System.out.println("x[" + i + "][" + j + "]= " + x[i][j]);
//                System.out.println("y[" + i + "][" + j + "]= " + y[i][j]);
            }
        }
    }

    /**
     * to get the length
     *
     * @return length
     */
    public int getLen() {
        return len;
    }

    /**
     * to get the x matrix
     *
     * @return x
     */
    public int[][] getX() {
        return this.x;
    }

    /**
     * to get the y matrix
     *
     * @return y
     */
    public int[][] getY() {
        return this.y;
    }
}//matrixScanner
