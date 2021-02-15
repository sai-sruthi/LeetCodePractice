class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int result = -1;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        if(grid[0][0]!=0 || grid[n-1][m-1]!=0){
            return result;
        }else if(n ==1 && m== 1 && grid[0][0]==0){
            return 1;
        }
        visited[0][0] = 1;
        int max = n+m-1;
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{0,0});
        while(!list.isEmpty()){
                int[] temp = list.remove();
                for(int k = 0;k<dirs.length;k++){
                    int tempx = temp[0]+dirs[k][0];
                    int tempy = temp[1]+dirs[k][1];
                    if(tempx >=0 && tempx<n && tempy >=0 && tempy<m && visited[tempx][tempy]==0 && grid[tempx][tempy]==0){
                        visited[tempx][tempy] = visited[temp[0]][temp[1]]+1;
                        list.add(new int[]{tempx,tempy});
                        if(tempx == n-1 && tempy == m-1 && visited[tempx][tempy]<max){
                            result = visited[tempx][tempy];
                            max = visited[tempx][tempy];
                        }
                    }
                }
        }
        
        return result;
    }
}
