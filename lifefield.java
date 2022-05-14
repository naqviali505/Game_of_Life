import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*; // for graphics
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class lifefield extends JPanel implements ActionListener {

    int x_field=1300;

    int y_field= 700;
    int s=10;
    int [][] B_life=new int[x_field/s][y_field/s];
    int  [][] array_of_life=new int[x_field/s][y_field/s];
    boolean starts = true ;
    public lifefield()
    {
        setSize(x_field,y_field);
        setLayout(null);
        setBackground(Color.BLACK);
        new Timer(80,this).start();
    }
    public void printComponents(Graphics gra)
    {
       super.printComponents(gra);
        //gra.setColor(Color.ORANGE );
        grid(gra);
        spawn(gra);
        display(gra);
    }
    // making grid
    private void grid (Graphics gra)
    {
        gra.setColor(Color.orange);

        for (int i=0;i<array_of_life.length;i++)
        {
            gra.drawLine(0,i * s,x_field,i * s); // for rows
            gra.drawLine(i * s,0,i * s,y_field);  // for columns
        }
    }

    private void spawn (Graphics gra)
    {
       if(starts)
       {
           for(int i=0;i<array_of_life.length;i++)
           {
               for (int j=0;j<(y_field/s);j++)
               {
                   if((int)(Math.random()*5) == 0 )
                   {
                       array_of_life[i][j]=1;
                   }
               }
           }
           starts= false;
       }
    }
    private  void display(Graphics gra)
    {
        gra.setColor(Color.ORANGE );
        a_copy();
        for(int i=0;i<array_of_life.length;i++)
        {
            for (int j=0;j<(y_field/s);j++)
            {
                if(array_of_life[i][j]==1 ) {
                    gra.fillRect(i * s, j * s, s, s);
                }
            }
        }
    }
     
    private int check_kro(int x, int y)
    {
        int alive=0;
        alive +=array_of_life[x-1][y-1];
        alive+=array_of_life[x][y-1];
        alive+=array_of_life[x+1][y-1];
        alive+=array_of_life[x-1][y];
        alive+=array_of_life[x+1][y];
        alive+=array_of_life[x-1][y+1];
        alive+=array_of_life[x][y+1];
        alive+=array_of_life[x+1][y+1];

        return alive;

    }
    public void actionPerformed(ActionEvent ae)
    {
        int alive;

        for(int i=0;i<array_of_life.length;i++)
        {
            for (int j=0;j<(y_field/s)-1;j++)
            {
               alive= check_kro(i,j);

               if (alive ==3){
                   B_life[i][j]=1;

               }
               else if (alive==2 && array_of_life[i][j]==1 )
               {
                   B_life[i][j]=1;
               }
               else{
                   B_life[i][j]=0;
               }
            }
        }

        repaint();
    }
    private void a_copy()
    {
        for(int i=0;i<array_of_life.length;i++)
        {
            for (int j=0;j<(y_field/s);j++)
            {
                array_of_life[i][j] = B_life[i][j];
            }
        }
    }
}
