/**
 * the operation class
 *
 * @author Mahsa Bazzaz 9631405
 * @version 0.0
 */
public class Operation {
    int[][] result;

    public Operation(String op, int[][] x, int[][] y, int zaribex, int zaribeY, int len) {
        int[][] result = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                x[i][j] *= zaribex;
                y[i][j] *= zaribeY;
            }
        }
        switch (op) {
            case "+": {
                //int addition[][] = new int[len][len];
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        result[i][j] = x[i][j] + y[i][j];
                    }
                }
                break;
            }
            case "-": {
                //int addition[][] = new int[len][len];
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        result[i][j] = x[i][j] - y[i][j];
                    }
                }
                break;
            }
            case "*": {
                //int multiplication[][] = new int[len][len];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        this.result[i][j] = 0;
                    }
                    break;
                }
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        this.result[i][j] += (x[i][j] * y[j][i]);
                    }
                }
            }
            case "x": {
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        this.result[i][j] = x[i][j];
                    }
                    break;
                }
            }
            case "y": {
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        this.result[i][j] = y[i][j];
                    }
                    break;
                }
            }
        }
        //Print the result
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.printf("%d\t", result[i][j]);
            }
            System.out.println(" ");
        }
    }//operation


}
