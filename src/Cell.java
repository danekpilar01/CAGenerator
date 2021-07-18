public class Cell {

    private static final int[] possibleStates = {0,1};

    private int state;
    private static final int[] rules = {0,1,0,1,1,0,1,0};

    public Cell(int state){
        this.state = state;
    }

    public Cell(){
        state = 0;
    }

    public int getState(){
        return state;
    }

    public void setState(int state){
        for (int i : possibleStates){
            if(state == i){
                this.state = state;
                return;
            }
        }
        throw new IllegalArgumentException("");
    }

    public int calculateNextState(Cell left, Cell right) {

        String stringFormat = "" + left.getState() + getState() + right.getState();

        return rules[Integer.parseInt(stringFormat, 2)];
    }



}
