import java.util.List;
import java.util.Objects;

public class DepthFirst {

    private final String[][] maze;
    private final List<Integer> path;

    /**
     *  Initializes the values for methods in the class
     *
     * @param maze 2d array of strings where "." is traversable and "#" is not
     * @param path empty List that will contain the path taken from start to end in reverse order
     */
    public DepthFirst(String[][] maze, List<Integer> path){
        this.maze = maze;
        this.path = path;
    }

    /**
     * Recursively traverse the 2d array of strings looking for the endpoint, always the bottom right corner
     *
     * @param x starting x coordinate to traverse from
     * @param y starting y coordinate to traverse from
     * @return true if the end point of the maze (bottom left corner) is reached, returns false otherwise
     */

    public boolean searchPath(int x, int y){

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
            if (checkLeft(x, y)) return true;

            // Checks right
            if (checkRight(x, y)) return true;

            // Checks down
            if (checkDown(x, y)) return true;

            // Checks up
            if (checkUp(x, y)) return true;

        }

        return false;
    }

    /**
     * Checks to the left of the most recently traversed index, calls on the searchPath method inside the
     * searchPath method, recursively searching
     *
     * @param x starting x coordinate to traverse from
     * @param y starting y coordinate to traverse from
     * @return true if the endpoint is found
     */
    public boolean checkLeft(int x, int y){
        int dx = -1;
        int dy = 0;

        if (searchPath(x + dx, y + dy)){
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
     * @param x starting x coordinate to traverse from
     * @param y starting y coordinate to traverse from
     * @return true if the endpoint is found
     */
    public boolean checkRight(int x, int y){
        int dx = 1;
        int dy = 0;

        if (searchPath(x + dx, y + dy)){
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
     * @param x starting x coordinate to traverse from
     * @param y starting y coordinate to traverse from
     * @return true if the endpoint is found
     */
    public boolean checkDown(int x, int y){
        int dx = 0;
        int dy = -1;

        if (searchPath(x + dx, y + dy)){
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
     * @param x starting x coordinate to traverse from
     * @param y starting y coordinate to traverse from
     * @return true if the endpoint is found
     */
    public boolean checkUp(int x, int y){
        int dx = 0;
        int dy = 1;

        if (searchPath(x + dx, y + dy)){
            path.add(x);
            path.add(y);
            return true;
        }

        return false;
    }

    /**
     * Formats the path List so that each pair of points is an array, [x,y]
     *
     * @return a 2d array that where every element is an array of ints length 2 where each array is a point traversed
     *         [x,y]
     */

    public int[][] findPath(){
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
