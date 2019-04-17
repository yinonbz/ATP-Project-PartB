package algorithms.mazeGenerators;

import java.util.*;

public class MyMazeGenerator extends AMazeGenerator {

    /**this function generate the maze
     * @param rows the row of the maze
     * @param columns the columns of the maze
     * @return the created maze
     */

    @Override
    public Maze generate(int rows, int columns) {

        Maze myMaze = new Maze(rows, columns);
        fillWalls(myMaze);

        //generate starting position
        generateStartPoint(myMaze);

        final LinkedList<int[]> frontiers = new LinkedList<>();
        final Random random = new Random();
        int x = myMaze.getStartPosition().getRowIndex();
        int y = myMaze.getStartPosition().getColumnIndex();
        frontiers.add(new int[]{x, y, x, y});

        //prim algorithm

        while (!frontiers.isEmpty()) {
            int rand = random.nextInt(frontiers.size());
            final int[] f = frontiers.remove(rand);
            x = f[2];
            y = f[3];
            if (myMaze.getMaze()[x][y] == 1) {
                myMaze.getMaze()[f[0]][f[1]] = myMaze.getMaze()[x][y] = 0;
                if (x >= 2 && myMaze.getMaze()[x - 2][y] == 1)
                    frontiers.add(new int[]{x - 1, y, x - 2, y});
                if (y >= 2 && myMaze.getMaze()[x][y - 2] == 1)
                    frontiers.add(new int[]{x, y - 1, x, y - 2});
                if (x < rows - 2 && myMaze.getMaze()[x + 2][y] == 1)
                    frontiers.add(new int[]{x + 1, y, x + 2, y});
                if (y < columns - 2 && myMaze.getMaze()[x][y + 2] == 1)
                    frontiers.add(new int[]{x, y + 1, x, y + 2});

            }
        }

        //generate end position
        generateEndPoint(myMaze);


        return myMaze;
    }
}