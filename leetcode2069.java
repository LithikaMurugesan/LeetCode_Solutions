class Robot {
    private int width, height;
    private int x, y;
    private int dir;
    
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static final String[] DIR_NAMES = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0; 
    }
    
    public void step(int num) {
        int perimeter = 2 * (width + height - 2);
        num %= perimeter;              
        if (num == 0) num = perimeter; 
        
        for (int i = 0; i < num; i++) {
            int nx = x + DX[dir];
            int ny = y + DY[dir];
            
            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                dir = (dir + 1) % 4;
                nx = x + DX[dir];
                ny = y + DY[dir];
            }
            
            x = nx;
            y = ny;
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return DIR_NAMES[dir];
    }
}
