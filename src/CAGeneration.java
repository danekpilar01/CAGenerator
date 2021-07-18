import processing.core.*;

public class CAGeneration extends PApplet{

    CellGrid cellGrid;

    public static void main(String[] args){
        PApplet.main("CAGeneration");
    }

    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {

        final int resolution = 60;


        cellGrid = new CellGrid(resolution,this.width/resolution);

        for(int i = 0; i < 40; i++){
            cellGrid.nextGeneration();
            //cellGrid.show(this);
        }

    }

    @Override
    public void draw() {

    }
}

