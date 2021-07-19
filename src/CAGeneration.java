import processing.core.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CAGeneration extends PApplet{

    CellGrid cellGrid;

    public static void main(String[] args){
        PApplet.main("CAGeneration");
    }

    private final int resolution = 300;

    private ArrayList<Integer> rulesSequence;

    @Override
    public void settings() {
        size(900,900);
    }

    private void createImage(int rule){
        Cell.setRules(rule);

        cellGrid = new CellGrid(resolution,this.width/resolution);

        for(int i = 0 ; i < height/cellGrid.getCellSize(); i++){
            cellGrid.show(this);
            cellGrid.nextGeneration();
        }
    }

    @Override
    public void setup() {
        int rulesNum = 256;
        rulesSequence = new ArrayList<>();
        for(int i = 0; i < rulesNum; i ++){
            rulesSequence.add(i);
        }

        Collections.shuffle(rulesSequence);

        for(int i = 0; i < rulesNum; i++){
            clear();
            int currentRule = rulesSequence.get(i);
            createImage(currentRule);
            save("out/rule_"+Integer.toString(currentRule)+".png");
        }
        exit();
    }

    @Override
    public void draw() {

    }

}

