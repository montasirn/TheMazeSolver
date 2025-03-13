import java.util.List;
import java.util.Objects;

public class DepthFirst {
    public static boolean searchPath(String[][] maze, int x, int y, List<Integer> path){

        int[] endPoint = new int[]{maze.length -1, maze[maze.length - 1].length -1};

        if (x < 0 | y < 0 | x >= maze.length | y >= maze[maze.length - 1].length){
            return false;
        }

        if (x == endPoint[0] && y == endPoint[1]){
            path.add(x);
            path.add(y);
            return true;
        }

        if (Objects.equals(maze[x][y], ".")){
            maze[x][y] = "+";

            if (checkLeft(maze, x, y, path)) return true;

            if (checkRight(maze, x, y, path)) return true;

            if (checkDown(maze, x, y, path)) return true;

            if (checkUp(maze, x, y, path)) return true;

        }

        return false;
    }

    public static boolean checkLeft(String[][] maze, int x, int y, List<Integer> path){
        int dx = -1;
        int dy = 0;

        if (DepthFirst.searchPath(maze, x + dx,y + dy, path)){
            path.add(x);
            path.add(y);
            return true;
        }
        return false;
    }

    public static boolean checkRight(String[][] maze, int x, int y, List<Integer> path){
        int dx = 1;
        int dy = 0;

        if (DepthFirst.searchPath(maze, x + dx,y + dy, path)){
            path.add(x);
            path.add(y);
            return true;
        }

        return false;
    }

    public static boolean checkDown(String[][] maze, int x, int y, List<Integer> path){
        int dx = 0;
        int dy = -1;

        if (DepthFirst.searchPath(maze, x + dx,y + dy, path)){
            path.add(x);
            path.add(y);
            return true;
        }

        return false;
    }

    public static boolean checkUp(String[][] maze, int x, int y, List<Integer> path){
        int dx = 0;
        int dy = 1;

        if (DepthFirst.searchPath(maze, x + dx,y + dy, path)){
            path.add(x);
            path.add(y);
            return true;
        }

        return false;
    }

    public static int[][] findPath(List<Integer> path){
        int[][] pathFound = new int[path.size()/2][2];

        int counter = 0;
        for (int i = path.size() - 2; i >= 0; i -= 2){
            pathFound[counter][0] = path.get(i);
            pathFound[counter][1] = path.get(i + 1);
            counter ++;
        }

        return pathFound;
    }

}
