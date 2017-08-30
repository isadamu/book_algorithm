package chapter15;

// 15.4-3 带备忘录版本
public class LCSMemo {
    public static void main(String[] args) {
//        String x = "ABCBDAB";
//        String y = "BDCABA";
        String x = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String y = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        System.out.printf(findLCS(x, y));
    }

    private static String findLCS(String x, String y) {
        char[] xx = x.toCharArray(), yy = y.toCharArray();
        int m = xx.length, n = yy.length;
        int[][] b = new int[m][n], len = new int[m][n];
        dpLCS(xx, yy, m - 1, n - 1, b, len);
        StringBuilder sb = new StringBuilder();
        printLCS( sb, xx, b, m - 1, n - 1);
        sb.reverse();
        return sb.toString();
    }

    private static int dpLCS(char[] x, char[] y, int i, int j, int[][] b, int[][] len) {
        if ( i == -1 || j == -1 ) {
            return 0;
        }
        if ( b[i][j] != 0) {
            return len[i][j];
        }
        if ( x[i] == y[j]  ) {
            b[i][j] = 1;
            len[i][j] = 1 + dpLCS( x, y, i - 1, j - 1, b, len);
        } else {
            int d1 = dpLCS( x, y, i - 1, j, b, len);
            int d2 = dpLCS( x, y, i, j - 1, b, len);
            if ( d1 > d2 ) {
                b[i][j] = 2;
                len[i][j] = d1;
            } else {
                b[i][j] = 3;
                len[i][j] = d2;
            }
        }
        return len[i][j];
    }

    private static void printLCS(StringBuilder sb, char[] xx, int[][] b, int i, int j) {
        if ( i == -1 || j == -1 )
            return;
        if ( b[i][j] == 1 ) {
            sb.append(xx[i]);
            printLCS( sb, xx, b, i - 1, j - 1);
        } else if ( b[i][j] == 2 ) {
            printLCS( sb, xx, b, i - 1, j);
        } else {
            printLCS( sb, xx, b, i, j - 1);
        }
    }
}
