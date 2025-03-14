import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[][] maze = ParseMaze.getMaze("src/mazeInput");

        List<Integer> path = new ArrayList<>();

        DepthFirst search = new DepthFirst(maze,path);

        search.searchPath(0,0);


        int[][] pathFound = search.findPath();

        System.out.println(Arrays.deepToString(pathFound));

    }
}