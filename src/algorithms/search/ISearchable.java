package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.*;

public interface ISearchable {

    /**this function is a getter that return the start state
     * @return the start state
     */

    public  AState getStartState();

    /**this function is a getter that return the Goal state
     * @returnthe Goal state
     */
    public AState getGoalState();

    /**this function reciving a AState and returning all the Possible Stats that can be reached via the current Astate
     * @param aState
     * @return
     */

    public ArrayList<AState> getAllPossibleStats(AState aState);
}
