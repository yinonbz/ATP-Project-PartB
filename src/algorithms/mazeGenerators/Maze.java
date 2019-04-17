package algorithms.mazeGenerators;

import java.util.Arrays;

public class Maze {
    private int maze [][];
    private int row;
    private int column;
    private Position startPostion;
    private Position goalPosition;


    /**this function sets the starting Position of the maze
     * @param startPos the starting position
     */

    protected void setStartPosition(Position startPos) {

        this.startPostion = new Position(startPos.getRowIndex(),startPos.getColumnIndex());
    }

    /**this function sets the goal Position of the maze
     * @param goalPos the goal position
     */

    protected void setGoalPosition(Position goalPos) {
        this.goalPosition = new Position(goalPos.getRowIndex(),goalPos.getColumnIndex());
    }

    /**the condtructor of maze
     * @param row the row of the maze
     * @param column the column of the maze
     */

    public Maze(int row, int column){
        //set default values if input is invalid
        if (row <=3 || column <=3) {
            System.out.println("invalid rows or columns number");
            this.row = 25;
            this.column = 25;
            this.maze = new int[row][column];
        }
        //set input values
        else{
            this.row = row;
            this.column = column;
            this.maze = new int[row][column];
        }
    }

    /**this function return the starting position
     * @return the starting position
     */

    public Position getStartPosition(){
        Position CopyPosition = new Position(startPostion.getRowIndex(),startPostion.getColumnIndex());

        return CopyPosition;
    }

    /**this function return the goal position
     * @return the goal position
     */

    public Position getGoalPosition(){
        Position CopyPosition = new Position(goalPosition.getRowIndex(),goalPosition.getColumnIndex());
        return CopyPosition;
    }

    /**
     * @return the row of the maze
     */

    public int getRow() {
        return row;
    }

    /**
     * @return the column of the maze
     */

    public int getColumn() {
        return column;
    }

    /**
     * @return the maze array
     */

    protected int[][] getMaze() {
        return maze;
    }

    /**this function checks if the gicen parameters is in the limet of the array and
     * that the cell isnt a wall(0)
     * @param x the cell row
     * @param y the cell column
     * @return return true or false if the cell is valid cell
     */

    public boolean isValid(int x, int y) {
        return ((x >= 0) && (x < getRow()) && (y >= 0) && (y < getColumn())&&(this.maze[x][y]!=1));
    }

    /**
     * this function print the maze
     */

    public void  print(){

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == startPostion.getRowIndex() && j == startPostion.getColumnIndex()) {//startPosition
                        System.out.print(" " + "S" + " ");
                } else if (i == goalPosition.getRowIndex() && j == goalPosition.getColumnIndex()) {//goalPosition
                    System.out.print(" " + "E" + " ");
                } else if (maze[i][j] == 1) System.out.print(" " + "1" + " ");
                else System.out.print(" " + "0" + " ");
            }
            System.out.println();
        }
    }

}
