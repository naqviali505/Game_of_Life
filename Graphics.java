import java.awt.*;
import javax.swing.*;

public class Graphics {

    public static void wlcom(int array[])
    {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(new GridLayout(3,1));

            frame.add(new JButton("Welcome to game of life"));
        JButton newgame= new JButton("Load New Game");
        newgame.addActionListener(e -> loadGrid(3,array));
        frame.add(newgame);
        frame.add(new JButton("Load Saved Game"));


        frame.setVisible(true);
    }
    public static void colorInverter(JButton button[],int arrayofcells[],int i)
    {
        if(arrayofcells[i]==0)
        {
            button[i].setBackground(Color.white);
            arrayofcells[i]=1;
        }
        else
        {button[i].setBackground(Color.black);
            arrayofcells[i]=0;}
    }
    public static void setControls(JFrame frame)
    {JPanel panel=new JPanel();
        panel.setSize(550,100);
    JButton starts=new JButton();
    JButton stop=new JButton();
    JButton restart=new JButton();
        starts.setLabel("Start");
        stop.setLabel("Stop");
        restart.setLabel("Restart");

        //starts.addActionListener(e->startGame());
       //startGame function to be implemented by BL
        //stop.addActionListener(e->stopGame());
       //stopGame function to be implemented by BL
        //restart.addActionListener(e->restartGame());
       //restartGame function to be implemented by BL

        panel.add(starts);
        panel.add(stop);
        panel.add(restart);

        frame.add(panel,BorderLayout.NORTH);
    }
    public static void loadGrid(int noofboxes,int arrayofcells[])
    {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);

        JPanel panel=new JPanel();
        panel.setSize(550,550);
        setControls(frame);

        panel.setLayout(new GridLayout(noofboxes,noofboxes));
        JButton [] buttons=new JButton[noofboxes*noofboxes];
        for (int i=0;i<noofboxes*noofboxes;i++)
        {
            buttons[i]=new JButton("");
            int num=i;
            if(arrayofcells[i]==1)
            {
                buttons[i].setBackground(Color.black);


            }
            else if(arrayofcells[i]==0)
            {
                buttons[i].setBackground(Color.white);



            }
            buttons[i].addActionListener(e->colorInverter(buttons,arrayofcells,num));
            panel.add(buttons[i]);

        }
        frame.add(panel);
        Slider slider=new Slider(frame);
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {int array[]={1,1,1,1,1,0,1,1,1};
        wlcom(array);
      //  loadGrid(3,array);//pass this func ana array and no of cells

    }
}
