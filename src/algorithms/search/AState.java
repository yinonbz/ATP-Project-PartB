package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import javafx.geometry.Pos;
import java.util.*;

public abstract class AState implements Comparable<AState> {
    private int cost;
    private AState previous;

    /**the constructor thar construct a AState
     * @param cost the cost of the state
     */

    public AState(int cost) {
        this.cost = cost;
        this.previous = null;
    }


    /**this function set the previous AState of the current state
     * @param previous the previous state of the current state
     */

    protected void setPrevious(AState previous)
    {
        if (previous != null){
            this.previous = previous;
        }
        else{
            this.previous = null;
        }
    }

    /** this is a getter that return the previous state
     * @return the previous state
     */

    protected AState getPrevious() {
        return this.previous;
    }

    /**this is a getter that return the cost of the state
     * @return  the cost of the state
     */

    public int getCost() {
        return this.cost;
    }

    /**this function compare between this Astate and other Astate and return 1 if
     * the current cost is  bigger then the other state
     * or -1 if the other state cost is bigger or 0 f equals
     * @param other Astate that been compared
     * @return 1 if the current cost is  bigger then the other state
     * or -1 if the other state cost is bigger or 0 f equals
     */

    @Override
    public int compareTo(AState other) {
        if(this.cost<other.getCost()){
            return -1;
        }
        if(this.cost>other.getCost()){
            return 1;
        }
        return 0;
    }

}
