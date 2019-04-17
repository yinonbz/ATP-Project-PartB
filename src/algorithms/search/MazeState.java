package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import javax.swing.text.StyleContext;
import java.util.*;

public class MazeState extends AState {
    private Position position;

    /**this is a constructor of the Maze state that receiving a int cost and Position
     * @param cost the cost of the current Maze State
     * @param position the Position of the mazeState
     */

    public MazeState(int cost, Position position) {
        super(cost);
        this.position = position;
    }

    /**this function is a getter that return the Position of the maze state
     * @return the position of the Astate
     */

    public Position getPosition() {
        Position copy = new Position(this.position.getRowIndex(),this.position.getColumnIndex());
        return copy;
    }

    /** this function receiving a object and check if the position of the maze state is equals of the current State
     * @param obj the other Object that need to be compered
     * @return true of false if the Project is the same
     */

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MazeState){
            MazeState Mobj = (MazeState) obj;
            if(this.position.getRowIndex() == Mobj.getPosition().getRowIndex() && this.position.getColumnIndex() == Mobj.getPosition().getColumnIndex()){
                return true;
            }
        }
        return false;
    }

    /**this function return the position of the location in the hash set
     * @return
     */

    @Override
    public int hashCode() {
        return this.position.getRowIndex()*31 + this.position.getColumnIndex();
    }

    /**this function return a string that represent the current position in the maze state
     * @return
     */

    @Override
    public String toString() {
        return "MazeState{" + "position=" + position + '}';
    }

    /**this function compare between this Astate and other Astate and return 1 if
     * the current cost is  bigger then the other state
     * or -1 if the other state cost is bigger or 0 f equals
     * @param o mazeState that been compared
     * @return 1 if the current cost is  bigger then the other state
     * or -1 if the other state cost is bigger or 0 f equals
     */

    @Override
    public int compareTo(AState o) {
        if(this.getCost()<o.getCost()){
            return -1;
        }
        if(this.getCost()>o.getCost()){
            return 1;
        }
        return 0;
    }
}
