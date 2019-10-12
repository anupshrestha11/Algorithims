public class App {
    public static void main(String[] args) {
        State[][] states = new State[Constants.NUM_VALUES][Constants.NUM_VALUES];

        //row counter
        int row = 0;
        //column counter
        int col = 0;

        //lets create states x=[-10,10] and y=[-10,10] with stepsize 0.1
        for (double x = -10; x < 9.9; x += 0.1) {
            for (double y = -10; y < 9.9; y += 0.1) {
                states[row][col] = new State(x, y, CostFunction.f(x, y));
                col++;
            }
            col = 0;
            row++;
        }

        //set the neighbors for the first column
        for (int i = 0;i<200;i++)
            states[i][0].addNeighbor(states[i][1]);

        //set the neighbor for last column
        for (int i = 0;i<200;i++)
            states[i][199].addNeighbor(states[i][198]);

        //set the neighbor for first row
        for (int i = 0; i<200; i++)
            states[0][i].addNeighbor(states[1][i]);

        //set the neighbor for last row
        for (int i = 0; i<200; i++)
            states[199][i].addNeighbor(states[198][i]);

        //set the neighborfor middle nodes
        for (int i=1;i<199;i++){
            for (int j = 1;j<199;j++){
                states[i][j].addNeighbor(states[i-1][j]);
                states[i][j].addNeighbor(states[i+1][j]);
                states[i][j].addNeighbor(states[i][j-1]);
                states[i][j].addNeighbor(states[i][j+1]);
            }
        }

        //let's user the tabu to solve the optimization
        TabuSearch tabuSearch = new TabuSearch(states);
        //we have to define a starting point (at random)
        System.out.println(tabuSearch.solve(states[100][100]));
    }
}
