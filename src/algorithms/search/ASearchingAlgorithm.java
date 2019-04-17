package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected int numberOfNodes;
    private String name;

    /**the constructor of the abstract AsearchingAlgorithm
     * @param name the name of the given algorithm
     */

    public ASearchingAlgorithm(String name) {
        this.name = name;
        numberOfNodes = 0;
    }

    /**this function return the Solution that contains the path to the goal state
     * @param solved the array list that contain the path
     * @param visited the hashSet that contains all the cell that have been visited
     * @param curr the current state that contains the previous states
     * @return the Solution that contains the path to the goal state
     */

    protected Solution getSolutionPath(ArrayList<AState> solved, HashSet<AState> visited, AState curr){
        while (visited.size() > 0 && curr != null) {
            solved.add(curr);
            curr = curr.getPrevious();
        }
        Solution solution = new Solution(solved);
        return solution;
    }

    /**a getter the return the name for the algorithm
     * @return the name for the algorithm
     */

    @Override
    public String getName() {
        return this.name;
    }

    /**this function return the number of nodes that have been Evaluated
     * @return number of nodes that have been Evaluated
     */

    @Override
    public int getNumberOfNodesEvaluated() {
        return this.numberOfNodes;
    }

    /**this function set the name of the algorithm
     * @param name of the algorithm
     */

    protected void setName(String name){
    this.name = name;
    }
}
