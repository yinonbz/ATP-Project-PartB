package algorithms.mazeGenerators;//ido add

import java.util.Random;

public abstract class AMazeGenerator implements IMazeGenerator {

    /** this function  measure the time it takes to generate maze
     * @param row the row of the maze
     * @param column the column of th maze
     * @return the time its take to generate maze
     */
    @Override
    public long measureAlgorithmTimeMillis(int row, int column) {
        long start =  System.currentTimeMillis();
        generate(row,column);
        long end = System.currentTimeMillis();
        return  end - start;
    }

    /** this function generate the maze and fill it with walls(1)
     * @param maze
     */

    protected void fillWalls(Maze maze){
        for (int i=0; i<maze.getRow();i++){
            for(int j=0;j<maze.getColumn();j++){
                maze.getMaze()[i][j]=1;
            }
        }
    }

    /**this function create the random starting point
     * @param maze
     */

    protected void generateStartPoint(Maze maze) {
        Random random = new Random();

        maze.setStartPosition(new Position(random.nextInt(maze.getRow()/2),random.nextInt(maze.getColumn()/2)));

    }

    /** this function creates a random goal/end point of the maze
     * @param maze
     */

    protected void generateEndPoint(Maze maze) {
        Random random = new Random();
        maze.setGoalPosition(new Position(random.nextInt(maze.getRow()/2)+(maze.getRow()/2),random.nextInt((maze.getColumn()/2))+(maze.getColumn()/2)));

        while (maze.getMaze()[maze.getGoalPosition().getRowIndex()][maze.getGoalPosition().getColumnIndex()] !=0 ||
                maze.getGoalPosition().equals(maze.getStartPosition())){
            maze.setGoalPosition(new Position(random.nextInt(maze.getRow()/2)+(maze.getRow()/2),random.nextInt((maze.getColumn()/2))+(maze.getColumn()/2)));
        }

    }
}
