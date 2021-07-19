class Tools{
    public static int[] createRule(int num){
        if(num >= 0 && num < 256){
            int[] output = new int[8];
            String shortBinary = Integer.toBinaryString(num);
            char[] array = ("00000000"+shortBinary).substring(shortBinary.length()).toCharArray();
            for(int i = 0; i < array.length;i++){
                output[i]=Integer.parseInt(Character.toString(array[i]));
            }
            return output;
        }
        return new int[]{0,0,0,0,0,0,0,0};
    }
}

public class Cell {

    private static final int[] possibleStates = {0,1};

    private int state;
    static int[] rules = {0,0,0,0,0,0,0,0};

    public static void setRules(int rule){
        Cell.rules = Tools.createRule(rule);
    }

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
