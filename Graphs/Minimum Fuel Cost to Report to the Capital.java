/** 
1. The total number of cars required to move p passengers with each car had S seats then ceil( P/S)
2. The total fuel costs to reach a node from bottom is Ceil(Total Passengers came from Bottom / seats) 
3. Now return total Passengers from current node;
*/




class Solution {
    long res = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i<roads.length+1; i++) graph.add(new ArrayList<>());
        for(int[] edge : roads){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1, graph,seats);
        return res;
    }

    public int dfs(int node, int parent, List<List<Integer>> graph, int seats){
         int passengers = 1;
         for(int child : graph.get(node)){
             if(child!=parent){
                   int p = dfs(child, node, graph, seats);
                   passengers += p;
                   System.out.println("p " +p);
                   System.out.println(p/seats+1);
                   res += Math.ceil((p*1.0)/(1.0*seats));
             }
         }
         
         return passengers;
    }
}