import java.util.List;

public class NeighborSolutionHandler {
    /**
     * In every iterations we have to find the next state: so we have to consider the
     * neighbors But we have to avoid states in the tabu list (so forbidden states)
     */
    public State getBestNeighbors(State[][] states, List<State> neighborStates, List<State> tabuStates) {

        //it means we want to remove all the items present in the tabuStates from neighborStates lists
        neighborStates.removeAll(tabuStates);

        //if all the neighboring states are in the tabu list: let's go to the middle state
        if (neighborStates.size() == 0) return states[100][100];

        //simple linear search in O(n) to find the neighbor with smallest f(x) value
        State bestSolution = neighborStates.get(0);

        for (int i = 1; i < neighborStates.size(); i++)
            if (neighborStates.get(i).getZ() < bestSolution.getZ())
                bestSolution = neighborStates.get(i);
        System.out.println("Best Solution is: "+ bestSolution);

        return bestSolution;

    }
}
