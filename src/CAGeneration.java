import processing.core.*;

public class CAGeneration extends PApplet{

    CellGrid cellGrid;

    public static void main(String[] args){
        PApplet.main("CAGeneration");
    }

    @Override
    public void settings() {
        size(900,900);
    }

    @Override
    public void setup() {

        final int resolution = 150;

        cellGrid = new CellGrid(resolution,this.width/resolution);

        for(int i = 0 ; i < height/cellGrid.getCellSize(); i++){
            cellGrid.show(this);
            cellGrid.nextGeneration();
        }
    }

    @Override
    public void draw() {

    }

}

