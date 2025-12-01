class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       int n = matrix.length;
       PriorityQueue <Integer> result = new  PriorityQueue<>(Collections.reverseOrder ());
       for(int i=0;i<n;i++){
        for(int j = 0;j<n;j++){
            if(result.size()<k){
                result.add(matrix[i][j]);
            }else{
            if(result.peek()>matrix[i][j]){
                result.poll();
                result.add(matrix[i][j]);
            }}
        }
       }
       return result.poll();
    }
}