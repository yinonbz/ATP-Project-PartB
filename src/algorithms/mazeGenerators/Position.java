package algorithms.mazeGenerators;

public class Position {
    private int row;
    private int  column;

    /**
     * this constructor gets 2 ints of num of rows and column and create a new position
     * @param row
     * @param column
     */
    public Position(int row,int column){
        this.row = row;
        this.column = column;
    }

    /**this function is a getter that return the row of the current position
     * @return the row of the position
     */
    public int getRowIndex(){
        return this.row;
    }

    /**this function is a getter that return the column of the current position
     * @return the column of the position
     */

    public int getColumnIndex(){
        return this.column;
    }

    /**this function return the string that represent the row and the column index of the position
     * @return the string of the index of the position
     */
    public String toString() {
        return "{"+getRowIndex() +"," + getColumnIndex()+"}";
    }

    /**this function checks if the position is equals or not
     * @param other the other Position
     * @return true or false if the position is equals
     */
    public boolean equals(Position other){
        if(this.getRowIndex() == other.row && this.getColumnIndex() == other.column){
            return true;
        }
        return false;
    }
}
