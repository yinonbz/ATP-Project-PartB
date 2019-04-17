package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    protected Queue<AState>Q_Bfs;
    private  ArrayList<AState> solved;

    /**
     * the constructor of the Bfs
     */

    public BreadthFirstSearch() {
        super("BFS");
        this.Q_Bfs = new ArrayDeque<>();;
        this.solved = new ArrayList<>();
    }

    /**this function reciving a ISearchable domain and return the Solution path of the current domain using Bread
     * First Search
     * @param domain the ISearchable problem that need to be solved
     * @return the solution of the current problem that the domain represent
     */

    @Override
    public Solution solve(ISearchable domain) {

        if(domain == null || domain.getStartState() == null || domain.getGoalState() == null){
            return null;
        }

        HashSet<AState> visited = new HashSet<>();
        AState start = domain.getStartState();
        AState goal = domain.getGoalState();
        AState curr = null;
        Q_Bfs.add(start);
        while (!Q_Bfs.isEmpty()) {
                curr = Q_Bfs.poll();
                visited.add(curr);
                numberOfNodes++;
                if (curr.equals(goal)) {
                    goal = curr;
                    break;
                }
                for (AState state : domain.getAllPossibleStats(curr)) {
                    if (!visited.contains(state) && !Q_Bfs.contains(state)) {
                        Q_Bfs.add(state);
                        state.setPrevious(curr);
                    }
                }
            }


        Solution solution = getSolutionPath(solved,visited,curr);
        return solution;
    }

}
