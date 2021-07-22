import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CellGrid {

    private Cell[] grid;
    private int width, cellSize, generation;
    private BufferedImage imageOutput;


    CellGrid(int width, int cellSize){
        this.width = width;
        this.cellSize = cellSize;
        grid = new Cell[width];
        for(int i = 0; i<width; i++)
            grid[i]=new Cell();
        grid[width/2].setState(1);
        generation = 0;
        imageOutput = new BufferedImage(width*cellSize, width*cellSize,BufferedImage.TYPE_INT_RGB);
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

    public int getCellSize(){
        return cellSize;
    }

    public void drawGeneration()
    {
        int y = cellSize * generation;
        for(int i = 0; i < grid.length; i++){
            int x = cellSize * i;

            Cell cell = grid[i];

            Graphics2D graph = imageOutput.createGraphics();

            Color color = cell.getState() == 1 ? Color.WHITE : Color.BLACK;
            graph.setColor(color);
            graph.fill(new Rectangle(x,y,cellSize,cellSize));
            graph.dispose();
        }
    }

    public void saveImageOutput(String fileName){
        File output = new File(fileName);
        try{
            ImageIO.write(imageOutput,"jpg",output);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
