class UI_implementation implements UI_interface{



     public boolean [][] arr(boolean[][] arr,int h,int w ){


         ConwayWorld world = new ConwayWorld(h,w);   
          for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
            {
                if(arr[i][j]==false)       // if UI cell is null then make BL cell also null
                {
                    ConwayCell c = new ConwayCell(i, j, world);
                    c.setIsAlive(false);
                    world.replaceCell(c); // replace the single cell.


                }
                else if(arr[i][j]==true)  // if UI cell is fill then make BL cell also fill
                {
                    ConwayCell c = new ConwayCell(i, j, world);
                    c.setIsAlive(true);
                    world.replaceCell(c); // replace the single cell.
                }

            }

        }
        // apply rules
         world.advanceToNextGeneration();

         boolean arr2[][]=new boolean[h][w];
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
            {
                if(world.isAlive(i,j)==true)
                {
                    arr2[i][j]=true;
                }
                else
                {
                    arr2[i][j]=false;
                }
            }
        }
     return arr2;



     }



}
