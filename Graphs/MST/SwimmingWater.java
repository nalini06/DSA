import java.util.PriorityQueue;
// we are using greedy approch, always moving towards lowest time to get into
// example if we move to cell value 24 we need to wait 24 units of time, but 1 can move to right cell in 1 unit of time
// And Use vis array to avoid multiple entry
// And each every time get max of all time, to reach (x, y)  cell
class SwimmingWater {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        q.add(new int[]{0, 0, grid[0][0]});

        int maxTime = 0;
        vis[0][0] = true;

        int[][] dir =  { {-1, 0}, {0, -1}, {0, 1}, {1, 0} };
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            int time = q.peek()[2];
            q.poll();
            maxTime = Math.max(maxTime, time);
            if(row == m-1 && col == n-1) return maxTime;
            for(int e[]: dir){
                int adjRow = e[0] + row;
                int adjCol = e[1] + col;
                if(adjRow <0 || adjRow >= m || adjCol< 0 || adjCol >=n || vis[adjRow][adjCol]) continue;
                vis[adjRow][adjCol] = true;
                q.add(new int[]{adjRow, adjCol, grid[adjRow][adjCol]});
            }
        }

        return maxTime;
    }
}