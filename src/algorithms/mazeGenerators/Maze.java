package algorithms.mazeGenerators;

import java.util.Arrays;
import java.util.Base64;

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

    public Maze(byte[] b) {
        String s_Row = "" + b[0] + b[1] + b[2] + b[3] + b[4];
        String s_Col = "" + b[5] + b[6] + b[7] + b[8] + b[9];
        String s_XStart = "" + b[10] + b[11] + b[12] + b[13] + b[14];
        String s_YStart = "" + b[15] + b[16] + b[17] + b[18] + b[19];
        String s_XGoal = "" + b[20] + b[21] + b[22] + b[23] + b[24];
        String s_YGoal = "" + b[25] + b[26] + b[27] + b[28] + b[29];
        this.row = Integer.parseInt(s_Row);
        this.column = Integer.parseInt(s_Col);
        Position start = new Position(Integer.parseInt(s_XStart), Integer.parseInt(s_YStart));
        Position goal = new Position(Integer.parseInt(s_XGoal), Integer.parseInt(s_YGoal));
        this.startPostion = start;
        this.goalPosition = goal;
        this.maze = new int[row][column];
        int r = 0;
        int c = 0;
        int i = 30;
        //for (int i = 30; i < b.length; i++) {
        while ((r != this.row - 1 || c != this.column - 1)) {
            maze[r][c] = b[i];
            i++;
            //move by one to the right
            if (r <= this.row - 1 && c != this.column - 1) {
                c++;
                //one line down
            } else if (r < this.row - 1 && c == this.column - 1) {
                c = 0;
                r++;
            }
        }
        maze[this.row - 1][this.column - 1] = b[b.length - 1];

    }

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

    public byte[] toByteArray(){

        byte[] BMaze = new byte[5 + 5 + 5 + 5 + 5 + 5 + (getRow() * getColumn())];
        int rowNum = this.getRow();
        int columnNum = this.getColumn();
        int factor =10000;

        BMaze = intToDigit(rowNum,BMaze, factor,0);
        BMaze = intToDigit(columnNum,BMaze, factor,5);
        BMaze = intToDigit(getStartPosition().getRowIndex(), BMaze,factor,10);
        BMaze = intToDigit(getStartPosition().getColumnIndex(),BMaze,factor,15);
        BMaze = intToDigit(getGoalPosition().getRowIndex(),BMaze,factor,20);
        BMaze = intToDigit(getGoalPosition().getColumnIndex(),BMaze,factor,25);

        for(int i = 0; i < getMaze().length; i ++)
        {
            for(int s = 0; s < getMaze()[0].length; s ++)
            {
                BMaze[(30 + (i * getMaze().length)) + s] = (byte) getMaze()[i][s];
            }
        }

        return BMaze;

    }

    private byte[] intToDigit (int number, byte[] BArray,int factor, int cell){
        int temp = 0;
        while (factor >0){
            temp = number / factor;
            number = number % factor;
            factor = factor / 10;
            BArray[cell] = (byte) temp;
            cell++;
        }
        return BArray;
    }

}
