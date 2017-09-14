package chapter32;

public class KMP {
    public static void main(String[] args) {
        String T = "bacbababaabcbababacaab";
        String P = "aabcbcab";
        System.out.println(search(T, P));
    }

    private static boolean search(String T, String P) {
        char[] t = T.toCharArray(), p = P.toCharArray();
        int n = p.length;
        int[] pai = computePai(p);
        int match_idx = -1;
        for (char aT : t) {
            while (match_idx > -1 && p[match_idx + 1] != aT)
                match_idx = pai[match_idx];
            if (p[match_idx + 1] == aT)
                match_idx++;
            if (match_idx == n - 1)
                return true;
        }
        return false;
    }

    private static int[] computePai(char[] p) {
        int[] pai = new int[p.length];
        pai[0] = -1;
        int k = -1;
        for ( int idx = 1; idx < p.length; idx++ ) {
            while ( k > -1 && p[k+1] != p[idx] ) {
                k = pai[k];
            }
            if ( p[k+1] == p[idx] ) {
                k = k + 1;
            }
            pai[idx] = k;
        }
        return pai;
    }
}
