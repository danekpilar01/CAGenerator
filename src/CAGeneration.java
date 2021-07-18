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

    }

    @Override
    public void draw() {

    }

    @Override
    public void keyPressed() {
        cellGrid.nextGeneration();
        cellGrid.show(this);
    }
}

