package algorithms.search;

import java.util.ArrayList;

public class Solution {
    private ArrayList<AState> algosolved;

    /**a constructor of the solution that receiving a array list that contains thee solution path
     * @param sol the array list that contains thee solution path
     */

    public Solution( ArrayList<AState> sol){

        this.algosolved = new ArrayList<>(sol);
    }

    /**this function is a getter that return the array list of the path solution
     * @return the array list of the path solution
     */

    public ArrayList<AState> getSolutionPath() {
        if (algosolved == null){
            return null;
        }
        ArrayList<AState> copy = new ArrayList<>(this.algosolved);
        return copy;
    }
}
