import java.util.ArrayList;
import java.util.Collections;

public class CAGenerate {

    private int width, height;
    private int resolution;
    private int rulesNumStart = 0, rulesNumEnd = 256;

    private ArrayList<Integer> rulesSequence;

    public CAGenerate(int width, int height, int resolution, int rulesNumStart, int rulesNumEnd){
        this.resolution = resolution;
        settings(width,height);

        if(rulesNumStart >=0 && rulesNumEnd <= 256 && rulesNumStart < rulesNumEnd){
            this.rulesNumStart = rulesNumStart;
            this.rulesNumEnd = rulesNumEnd;
        }else{
            throw new IllegalArgumentException("Invalid arguments.");
        }

    }

    public CAGenerate(int width, int height,int resolution){

        this.resolution = resolution;
        settings(width,height);
    }

    private void settings(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private void createImage(int rule){
        Cell.setRules(rule);

        CellGrid cellGrid = new CellGrid(resolution,this.width/resolution);

        for(int i = 0 ; i < height/cellGrid.getCellSize(); i++){
            cellGrid.drawGeneration();
            cellGrid.nextGeneration();
        }

        cellGrid.saveImageOutput("rule_"+Integer.toString(rule)+".jpg");
    }

    public void run() {

        rulesSequence = new ArrayList<>();
        for(int i = rulesNumStart; i < rulesNumEnd; i ++){
            rulesSequence.add(i);
        }

        Collections.shuffle(rulesSequence);

        for(int i = 0; i < (rulesNumEnd-rulesNumStart); i++){
            int currentRule = rulesSequence.get(i);
            createImage(currentRule);
        }
    }



}
