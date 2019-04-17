package algorithms.search;
import java.util.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestFirstSearch extends BreadthFirstSearch{
    //private PriorityQueue<AState>Best_Q;
    private  ArrayList<AState> solved;


    /**
     * the constructor of the Best first search class
     */
    public BestFirstSearch() {
        super();
        this.setName("Best First Search");
        super.Q_Bfs = new PriorityQueue<AState>(AState::compareTo);
        this.solved = new ArrayList<>();
    }

    /**this function reciving a ISearchable domain and return the Solution path of the current domain using Best
     * Firat Search
     * @param domain the ISearchable problem that need to be solved
     * @return the solution of the current problem that the domain represent
     */
    /*
    @Override
    public Solution solve(ISearchable domain) {

        boolean isfinal=false;
        HashSet<AState> visited = new HashSet<>();
        AState start = domain.getStartState();
        AState goal = domain.getGoalState();
        AState curr = null;
        Best_Q.add(start);
        while (!Best_Q.isEmpty()&&isfinal == false) {
            curr = Best_Q.poll();
            visited.add(curr);
            numberOfNodes++;
            if (curr.equals(goal)) {
                goal = curr;
                break;
            }
            for (AState state : domain.getAllPossibleStats(curr)) {
                if (!visited.contains(state) && !Best_Q.contains(state)) {
                    if (state.equals(goal)) {
                        isfinal =true;
                        state.setPrevious(curr);
                        curr = state;
                        break;
                    }
                    else {
                        Best_Q.add(state);
                        state.setPrevious(curr);
                    }
                }
            }
        }

        Solution solution = getSolutionPath(solved,visited,curr);
        return solution;
    }

/*
    /**this function is a getter that return the string of the name
     * @return
     */
    //  @Override
    // public String getName() {
    //   return "Best First Search";
    // }

}
