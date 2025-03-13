import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[][] maze = ParseMaze.getMaze("src/mazeInput");

        List<Integer> path = new ArrayList<>();

        DepthFirst.searchPath(maze,0,0,path);

        int[][] pathFound = DepthFirst.findPath(path);

        System.out.println(Arrays.deepToString(pathFound));

    }
}