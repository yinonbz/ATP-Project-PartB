package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {
    private Maze maze;
    private AState startState;
    private AState goalState;

    /**
     * this constructor gets maze and creates new searchable maze object
     * @param maze
     */

    public SearchableMaze(Maze maze) {//need to be implement
        this.maze = maze;
        this.startState = new MazeState(0, maze.getStartPosition());
        this.goalState = new MazeState(0, maze.getGoalPosition());
    }

    /**
     * this function returns the starting state of the searchable maze
     * @return Astate
     */

    @Override
    public AState getStartState() {

        if (this.startState == null) {
            return null;
        }

        return new MazeState(this.startState.getCost(), new Position(maze.getStartPosition().getRowIndex(), maze.getStartPosition().getColumnIndex()));
    }

    /**
     * this function returns the end state of the searchable maze
     * @return Astate
     */

    @Override
    public AState getGoalState() {

        if (this.goalState == null) {
            return null;
        }

        return new MazeState(this.goalState.getCost(), new Position(maze.getGoalPosition().getRowIndex(), maze.getGoalPosition().getColumnIndex()));
    }

    /**
     * this function gets aState and return list of all valid neighbour cells.
     * @param aState
     * @return Array List of Astate
     */

    @Override
    public ArrayList<AState> getAllPossibleStats(AState aState) {
        if (aState == null) {
            return null;
        }
        ArrayList<AState> allAState = new ArrayList<>();
        if (aState instanceof MazeState) {
            MazeState temp = (MazeState) aState;
            Position p = temp.getPosition();
            int x = p.getRowIndex();
            int y = p.getColumnIndex();
            int row = maze.getRow();
            int col = maze.getColumn();
            if (maze.isValid(x + 1, y)) {
                allAState.add(new MazeState(10, new Position(x + 1, y)));
            }
            if (maze.isValid(x - 1, y)) {
                allAState.add(new MazeState(10, new Position(x - 1, y)));
            }
            if (maze.isValid(x, y + 1)) {
                allAState.add(new MazeState(10, new Position(x, y + 1)));
            }
            if (maze.isValid(x, y - 1)) {
                allAState.add(new MazeState(10, new Position(x, y - 1)));
            }
            if (maze.isValid(x + 1, y + 1) && (maze.isValid(x, y + 1) || maze.isValid(x + 1, y))) {
                allAState.add(new MazeState(5, new Position(x + 1, y + 1)));
            }
            if (maze.isValid(x - 1, y - 1) && (maze.isValid(x, y - 1) || maze.isValid(x - 1, y))) {
                allAState.add(new MazeState(5, new Position(x - 1, y - 1)));
            }
            if (maze.isValid(x - 1, y + 1) && (maze.isValid(x - 1, y) || maze.isValid(x, y + 1))) {
                allAState.add(new MazeState(5, new Position(x - 1, y + 1)));
            }
            if (maze.isValid(x + 1, y - 1) && (maze.isValid(x + 1, y) || maze.isValid(x, y - 1))) {
                allAState.add(new MazeState(5, new Position(x + 1, y - 1)));
            }
            return allAState;
        }
        return null;
    }
}
