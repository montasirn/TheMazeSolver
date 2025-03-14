import java.util.List;
import java.util.Objects;

public class DepthFirst {

    /**
     * Recursively traverse the 2d array of strings looking for the endpoint, always the bottom right corner
     *
     * @param maze a 2d array of strings where . is a traversable segment and # is not
     * @param x The starting x coordinate to start traversing the maze from
     * @param y The starting y coordinate to start traversing the maze from
     * @param path An empty list of integers that will be filled with the path taken by the method to reach the endpoint
     * @return true if the end point of the maze (bottom left corner) is reached, returns false otherwise
     */

    public static boolean searchPath(String[][] maze, int x, int y, List<Integer> path){

        // Specifies the endpoint as the bottom right corner of the maze
        int[] endPoint = new int[]{maze.length -1, maze[maze.length - 1].length -1};

        // Checks if the index being checked is out of bounds
        if (x < 0 | y < 0 | x >= maze.length | y >= maze[maze.length - 1].length){
            return false;
        }

        // Checks if the index being checked is the endpoint
        if (x == endPoint[0] && y == endPoint[1]){
            path.add(x);
            path.add(y);
            return true;
        }

        // Checks if the index being checked has not been visited yet, marks as visited after (+)
        if (Objects.equals(maze[x][y], ".")){
            maze[x][y] = "+";

            // Checks left
            if (checkLeft(maze, x, y, path)) return true;

            // Checks right
            if (checkRight(maze, x, y, path)) return true;

            // Checks down
            if (checkDown(maze, x, y, path)) return true;

            // Checks up
            if (checkUp(maze, x, y, path)) return true;

        }

        return false;
    }

    /**
     * Checks to the left of the most recently traversed index, calls on the searchPath method inside the
     * searchPath method, recursively searching
     *
     * @param maze a 2d array of strings where . is a traversable segment and # is not
     * @param x The starting x coordinate to start traversing the maze from
     * @param y The starting y coordinate to start traversing the maze from
     * @param path An empty list of integers that will be filled with the path taken by the method to reach the endpoint
     * @return true if the endpoint is found
     */
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

    /**
     * Checks to the right of the most recently traversed index, calls on the searchPath method inside the
     * searchPath method, recursively searching
     *
     * @param maze a 2d array of strings where . is a traversable segment and # is not
     * @param x The starting x coordinate to start traversing the maze from
     * @param y The starting y coordinate to start traversing the maze from
     * @param path An empty list of integers that will be filled with the path taken by the method to reach the endpoint
     * @return true if the endpoint is found
     */
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

    /**
     * Checks underneath the most recently traversed index, calls on the searchPath method inside the
     * searchPath method, recursively searching
     *
     * @param maze a 2d array of strings where . is a traversable segment and # is not
     * @param x The starting x coordinate to start traversing the maze from
     * @param y The starting y coordinate to start traversing the maze from
     * @param path An empty list of integers that will be filled with the path taken by the method to reach the endpoint
     * @return true if the endpoint is found
     */
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

    /**
     * Checks above the most recently traversed index, calls on the searchPath method inside the
     * searchPath method, recursively searching
     *
     * @param maze a 2d array of strings where . is a traversable segment and # is not
     * @param x The starting x coordinate to start traversing the maze from
     * @param y The starting y coordinate to start traversing the maze from
     * @param path An empty list of integers that will be filled with the path taken by the method to reach the endpoint
     * @return true if the endpoint is found
     */
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

    /**
     * Formats the path List so that each pair of points is an array, [x,y]
     *
     * @param path A list of integers that is filled with the path taken by searchPath, from endpoint to [0,0]
     * @return a 2d array that where every element is an array of ints length 2 where each array is a point traversed
     *         [x,y]
     */

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
