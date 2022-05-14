package Game-of-life.Model;

import java.util.Random;
import java.util.ArrayList;


public class Field 
{

    private int fHeight;
    private int fWidth;
    private int NumGeneration;
    private Random rnd = new Random();
    private ArrayList<ArrayList<Cell>> C_step, N_step;

    public Field() 
    {
      fWidth = 100;
      fHeight = (fWidth/16)*9;
      NumGeneration = 0;
      
      C_step = new ArrayList<ArrayList<Cell>>(fHeight);
      
      for(int h = 0; h < fHeight; h++) 
      {
        C_step.add(h, new ArrayList<Cell>(fWidth));
      }

        populateGrid();
//        N_step = new ArrayList<ArrayList<Cell>>(C_step);
    }

    public Field(int inputHeight, int inputWidth) 
    {
        fHeight = inputHeight;
        fWidth = inputWidth;
        NumGeneration = 0;

        C_step = new ArrayList<ArrayList<Cell>>(fHeight);

        for(int h = 0; h < fHeight; h++) {
            C_step.add(h, new ArrayList<Cell>(fWidth));
        }

        populateGrid();
//        N_step = new ArrayList<ArrayList<Cell>>(C_step);
    }

    /**
     Generating First cells with initial at 0
     */
    public void setInitialGeneration() {
        clearGrid();

        int numOfAttempts = rnd.nextInt((fHeight*fWidth)/2);
        for(int i = 0; i < numOfAttempts; i++) {
            if(rnd.nextBoolean()) {
                Cell currentCell = getCellAt(rnd.nextInt(fHeight), rnd.nextInt(fWidth));
                if(!currentCell.isAlive()) {
                    currentCell.revive();
                }
            }
        }

    }

    
    public void nextGeneration() {

//        N_step = new ArrayList<ArrayList<Cell>>(C_step);
        NumGeneration++;

        for (int h = 0; h < C_step.size(); h++) {
            for (int w = 0; w < C_step.get(h).size(); w++) {
                getCellAt(h, w).advanceOnce();
//                N_step.get(h).get(w).setNumOfNeighbors(countNeighbors(h, w));
//                N_step.get(h).get(w).advanceOnce();
            }
        }
//        C_step = new ArrayList<ArrayList<Cell>>(N_step);
    }


   
    public void updateAllCells() {
        for (int h = 0; h < C_step.size(); h++) {
            for (int w = 0; w < C_step.get(h).size(); w++) {
                getCellAt(h, w).setNumOfNeighbors(countNeighbors(h, w));
            }
        }
    }

    public int getHeight() { return fHeight; }

    public int getWidth() { return fWidth; }

    public void clearGrid() {
        NumGeneration = 0;
        for (int h = 0; h < C_step.size(); h++) {
            for (int w = 0; w < fWidth; w++) {
                getCellAt(h, w).kill();

            }
        }
    }

    public Cell getCellAt(int h, int w) {
        return C_step.get(h).get(w);
    }

    public boolean getCellStateAt(int h, int w) { return getCellAt(h, w).isAlive(); }

    public int getGenerationNum() { return NumGeneration; }

   
    private void populateGrid() {
        for (int h = 0; h < C_step.size(); h++) {
            for (int w = 0; w < fWidth; w++) {
                C_step.get(h).add(w, new Cell());
            }
        }
    }

   
    private int countNeighbors(int height, int width) {
        int neighborCount = 0;

        for(int i = -1; i < 2; i ++) {
            for(int j = -1; j < 2; j++) {
                if(i == 0 && j == 0) {
                    //do nothing.
                } else {
                    if ((height + i >= 0 && height + i < fHeight) &&
                            (width + j >= 0 && width + j < fWidth)) {
                        if (getCellAt(height + i, width + j).isAlive()) {
                            neighborCount++;
                        }
                    }
                }
            }
        }
        return neighborCount;
    }

}
