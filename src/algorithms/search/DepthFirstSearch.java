package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm {
    private ArrayList<AState> sol;
    private Solution solution;

    /**
     * the constructor of the Dfs
     */

    public DepthFirstSearch() {
        super("DFS");
        this.sol = new ArrayList<AState>();
    }

    /**this function reciving a ISearchable domain and return the Solution path of the current domain using Depth
     * First Search
     * @param domain the ISearchable problem that need to be solved
     * @return the solution of the current problem that the domain represent
     */

    @Override
    public Solution solve(ISearchable domain) {

        if(domain == null || domain.getStartState() == null || domain.getGoalState() == null){
            return null;
        }

        Stack<AState> stack = new Stack<>();
        HashSet<AState> visited = new HashSet<>();
        AState tmp=null;

        stack.push(domain.getStartState());
        while(!stack.isEmpty()) {
            tmp = stack.pop();
            visited.add(tmp);
            numberOfNodes++;


            if (tmp.equals(domain.getGoalState())) {
                break;
            }

            for (AState state : domain.getAllPossibleStats(tmp)) {
                if (!visited.contains(state)) {
                    stack.push(state);
                    state.setPrevious(tmp);
                }
            }

        }

        Solution solution = getSolutionPath(sol,visited,tmp);
        return solution;

    }
}
