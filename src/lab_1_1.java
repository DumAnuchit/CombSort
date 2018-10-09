
import java.util.*;

public class lab_1_1 {

    public int[][] per;
    int path = 1;

    public lab_1_1(int n, int m) {
        per = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                per[i][j] = 0;
            }
        }
    }

    public boolean SnakeWord(char[][] matrix, String word, int a, int b) {
        int n = a;
        int m = b;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Snake(matrix, word, i, j, 0, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Snake(char[][] matrix, String word, int row, int col,
            int index, int a) {
        if (per[row][col] != 0 || word.charAt(index) != matrix[row][col]) {
            return false;
        }
        if (index == word.length() - 1) {
            per[row][col] = path++;
            return true;
        }
        per[row][col] = path++;
        if (row + 1 < a && Snake(matrix, word, row + 1, col, index + 1, a)) {
            return true;
        }
        if (row - 1 >= 0 && Snake(matrix, word, row - 1, col, index + 1, a)) {																				// up
            return true;
        }
        if (col + 1 < a && Snake(matrix, word, row, col + 1, index + 1, a)) {
            return true;
        }
        if (col - 1 >= 0 && Snake(matrix, word, row, col - 1, index + 1, a)) {
            return true;
        }
        per[row][col] = 0;
        path--;
        return false;
    }

    public void print() {
        int nubcount = 0;
        for (int i = 0; i < per.length; i++) {
            for (int j = 0; j < per[i].length; j++) {
                if (per[i][j] > nubcount) {
                    nubcount = per[i][j];
                }
            }
        }
        for (int a = 1; a <= nubcount; a++) {
            for (int i = 0; i < per.length; i++) {
                for (int j = 0; j < per[i].length; j++) {
                    if (per[i][j] == 0) {
                    }
                    if (per[i][j] == a) {
                        System.out.print((i + 1) + " " + (j + 1));
                        System.out.println("");
                    }
                }
            }
        }
        for (int i = 0; i < per.length; i++) {
            for (int j = 0; j < per[i].length; j++) {
                per[i][j] = 0;
            }
        }
        path = 1;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int x = kb.nextInt();
        int y = kb.nextInt();
        char[][] arr = new char[x][y];
        lab_1_1 w = new lab_1_1(x, y);
        for (int i = 0; i < x; i++) {
            String rub = kb.next().toUpperCase();;

            for (int j = 0; j < y; j++) {
                arr[i][j] = rub.charAt(j);
            }
        }
        int rubnumber = kb.nextInt();
        for (int i = 0; i < rubnumber; i++) {
            String a = kb.next().toUpperCase();;
            if (w.SnakeWord(arr, a, x, y)) {
                w.print();
            } else {
                System.out.println("No Matching Word");
            }
        }
    }
}
