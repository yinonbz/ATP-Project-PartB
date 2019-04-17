package algorithms.search;

public interface ISearchingAlgorithm {

    /**his function receiving  a ISearchable domain and return the Solution path of the current domain using ISearchingAlgorithm
     * @param domain the ISearchable problem that need to be solved
     * @return the solution/path of the current problem that the domain represent
     */

    public Solution solve(ISearchable domain);

    /** this function is a getter that return the name of the ISearchingAlgorithm
     * @return a strung that contains the name of the ISearchingAlgorithm
     */

    public String getName();

    /**this function return the number of nodes that have been Evaluated
     * @return number of nodes that have been Evaluated
     */

    public int getNumberOfNodesEvaluated();
}
