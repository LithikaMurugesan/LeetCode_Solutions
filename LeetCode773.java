class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start += board[i][j];
            }
        }

        int[][] neighbors = {
            {1, 3},   
            {0, 2, 4}, 
            {1, 5},    
            {0, 4},    
            {1, 3, 5}, 
            {2, 4}     
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String curr = queue.poll();

                if (curr.equals(target)) return steps;

                int zeroIndex = curr.indexOf('0');

                for (int next : neighbors[zeroIndex]) {
                    String newBoard = swap(curr, zeroIndex, next);
                    if (!visited.contains(newBoard)) {
                        visited.add(newBoard);
                        queue.offer(newBoard);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
