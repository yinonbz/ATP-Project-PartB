package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    /**this function create a empty maze
     * @param row the row of the empty maze
     * @param column the column of the empty maze
     * @return the empty maze
     */
    @Override
    public Maze generate(int row, int column) {
        Maze emptyMaze = new Maze(row,column);
        for (int i=0; i<row;i++){
            for(int j=0;j<column;j++){
                emptyMaze.getMaze()[i][j]=0;
            }
        }

        generateStartPoint(emptyMaze);
        generateEndPoint(emptyMaze);
        return emptyMaze;
    }
}
