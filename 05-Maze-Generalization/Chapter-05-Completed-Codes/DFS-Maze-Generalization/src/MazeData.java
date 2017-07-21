public class MazeData {

    public static final char ROAD = ' ';
    public static final char WALL = '#';

    private int entranceX, entranceY;
    private int exitX, exitY;

    private int N, M;
    public char[][] maze;
    public boolean[][] visited;

    public MazeData(int N, int M){

        if( N < 2 || M < 1)
            throw new IllegalArgumentException("Maze size is invalid!");

        if( N%2 == 0 || M%2 == 0)
            throw new IllegalArgumentException("Our Maze Generalization Algorihtm requires the width and height of the maze are odd numbers");

        this.N = N;
        this.M = M;

        maze = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0 ; i < N ; i ++)
            for(int j = 0 ; j < M ; j ++){
                if(i%2 == 1 && j%2 == 1)
                    maze[i][j] = ROAD;
                else
                    maze[i][j] = WALL;

                visited[i][j] = false;
            }

        this.entranceX = 1;
        this.entranceY = 0;
        this.exitX = N - 2;
        this.exitY = M - 1;
    }

    public int N(){ return N; }
    public int M(){ return M; }
    public int getEntranceX(){ return entranceX; }
    public int getEntranceY(){ return entranceY; }
    public int getExitX(){ return exitX; }
    public int getExitY(){ return exitY; }

    public boolean inArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
