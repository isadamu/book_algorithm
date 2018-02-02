package chapter15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TH15_3 {

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
//        nodes.add(new Node(0,6));
//        nodes.add(new Node(1,0));
//        nodes.add(new Node(2,3));
//        nodes.add(new Node(5,4));
//        nodes.add(new Node(6,1));
//        nodes.add(new Node(7,5));
//        nodes.add(new Node(8,2));

        // 27.2 = 12 + 8 + 3.6 + 3.6
        nodes.add(new Node(0,0));
        nodes.add(new Node(2,3));
        nodes.add(new Node(4,0));
        nodes.add(new Node(6,3));
        nodes.add(new Node(8,0));
        nodes.add(new Node(10,3));
        nodes.add(new Node(12,0));
        System.out.println(TSP2(nodes));
    }

    private static class Node {
        public int x;
        public int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * dp[i][j] 表示将 点 i 与 点 j 直接相连 的时候
     *          在 前 i 个点中的最优环游长度 减去 dis( i, j)
     */
    private static double TSP( List<Node> nodes ) {
        if ( nodes == null || nodes.size() < 3 )
            return -1;
        int n = nodes.size();
        Collections.sort(nodes, Comparator.comparingInt(node -> node.x));
        double[][] dis = getDis(nodes);
        double[][] dp = new double[n+1][n+1];
        dp[3][1] = dis[3][2] + dis[2][1];
        dp[3][2] = dis[3][1] + dis[2][1];
        for ( int i = 4; i <= n; i++ ) {
            double min = Double.MAX_VALUE;
            for ( int j = 1; j < i-1; j++ ) {
                dp[i][j] = dp[i-1][j] + dis[i][i-1];
                min = Math.min(min, dp[i-1][j] + dis[i][j]);
            }
            dp[i][i-1] = min;
        }
        return dp[n][n-1] + dis[n][n-1];
    }

    private static double[][] getDis(List<Node> nodes) {
        int n = nodes.size();
        double[][] dis = new double[n+1][n+1];
        for ( int i = 1; i < n; i++ ) {
            Node node1 = nodes.get(i-1);
            for ( int j = i + 1; j <= n; j++ ) {
                Node node2 = nodes.get(j-1);
                dis[i][j] = dis[j][i] =
                        Math.sqrt(Math.pow(node1.x - node2.x, 2) + Math.pow(node1.y - node2.y, 2));
            }
        }
        return dis;
    }

    private static double TSP2( List<Node> nodes ) {
        if ( nodes == null || nodes.size() < 3 )
            return -1;
        int n = nodes.size();
        Collections.sort(nodes, Comparator.comparingInt(node -> node.x));
        double[][] dp = new double[2][n+1];
        dp[0][1] = getDis2(nodes.get(2), nodes.get(1)) + getDis2(nodes.get(1), nodes.get(0));
        dp[0][2] = getDis2(nodes.get(2), nodes.get(0)) + getDis2(nodes.get(1), nodes.get(0));
        for ( int i = 4; i <= n; i++ ) {
            double min = Double.MAX_VALUE, len = getDis2(nodes.get(i-1), nodes.get(i-2));
            for ( int j = 1; j < i-1; j++ ) {
                dp[1][j] = dp[0][j] + len;
                min = Math.min(min, dp[0][j] + getDis2(nodes.get(i-1), nodes.get(j-1)));
            }
            dp[1][i-1] = min;
            double[] ex = dp[0];
            dp[0] = dp[1];
            dp[1] = ex;
        }
        return dp[0][n-1] + getDis2(nodes.get(n-1), nodes.get(n-2));
    }

    private static double getDis2( Node node1, Node node2 ) {
        return Math.sqrt(Math.pow(node1.x - node2.x, 2) + Math.pow(node1.y - node2.y, 2));
    }
}
