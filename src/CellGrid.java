import processing.core.PApplet;

public class CellGrid {

    Cell[] grid;
    int width, cellSize, generation;

    CellGrid(int width, int cellSize){
        this.width = width;
        this.cellSize = cellSize;
        grid = new Cell[width];
        for(int i = 0; i<width; i++)
            grid[i]=new Cell();
        grid[width/2].setState(1);
        generation = 0;
    }

    public void nextGeneration(){
        Cell[] tmp = new Cell[width];
        for(int i = 0; i < width ; i++)
            tmp[i] = new Cell();

        tmp[0].setState(grid[0].getState());
        tmp[grid.length-1].setState(grid[grid.length-1].getState());
        for(int i = 1; i < grid.length-1 ; i++){
            tmp[i].setState(grid[i].calculateNextState(grid[i-1],grid[i+1]));
        }

        grid = tmp;
        generation++;
    }


    public void show(PApplet pApplet)
    {
        for(int i = 0; i < grid.length; i++){
            int x = cellSize * i;
            int y = cellSize * generation;
            pApplet.rect(cellSize*i,cellSize*generation, x+cellSize, y+cellSize);
        }
    }
}
