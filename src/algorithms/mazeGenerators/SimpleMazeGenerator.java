package algorithms.mazeGenerators;

import java.util.Arrays;

public class SimpleMazeGenerator extends AMazeGenerator {

    /**this function generate a simple maze
     * @param row the row of the maze
     * @param column the column of the maze
     * @return the maze that have been created
     */
    @Override
    public Maze generate(int row, int column) {
        Maze simpleMaze = new Maze(row,column);
        //initialize all in ones
        EmptyMazeGenerator empty = new EmptyMazeGenerator();
        Maze emp = empty.generate(row,column);
        //create the start & end points;
        generateStartPoint(emp);
        generateEndPoint(emp);
        fillWalls(simpleMaze);
        Position start = emp.getStartPosition();
        Position end = emp.getGoalPosition();
        simpleMaze.setStartPosition(start);
        simpleMaze.setGoalPosition(end);
        //create a path
        if(start.getRowIndex()<end.getRowIndex()){
            for(int i=start.getRowIndex();i<=end.getRowIndex();i++ ){
                simpleMaze.getMaze()[i][start.getColumnIndex()]=0;
            }
        }

        if(start.getRowIndex()>end.getRowIndex()){
            for(int i=start.getRowIndex();i>=end.getRowIndex();i-- ){
                simpleMaze.getMaze()[i][start.getColumnIndex()]=0;
            }
        }

        if(start.getColumnIndex()<end.getColumnIndex()){
            for(int i=start.getColumnIndex();i<=end.getColumnIndex();i++ ){
                simpleMaze.getMaze()[end.getRowIndex()][i]=0;
            }
        }
        if(start.getColumnIndex()>end.getColumnIndex()) {
            for (int i = start.getColumnIndex(); i >= end.getColumnIndex(); i--) {
                simpleMaze.getMaze()[end.getRowIndex()][i] = 0;
            }
        }

            //creates a random walls and paths

        for (int i=0; i<row;i++){
            for(int j=0;j<column;j++) {
                if(simpleMaze.getMaze()[i][j]==1){
                    if(Math.random()<0.5) {
                        simpleMaze.getMaze()[i][j] =0;
                    }
                    else{
                        simpleMaze.getMaze()[i][j] =1;
                    }
                }
            }
        }

            return simpleMaze;


        }
}
