package algorithms.mazeGenerators;

public interface IMazeGenerator {
        /**this function generate the maze
         * @param row the row of the maze
         * @param column the colum of the maze
         * @return the maze that have been created
         */
        public Maze generate(int row,int column);

        /**this function measure the finish time of the generate function
         * @param row
         * @param column
         * @return the time it take to finish
         */
        public long measureAlgorithmTimeMillis(int row,int column);
}


