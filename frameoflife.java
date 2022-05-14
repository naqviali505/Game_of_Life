
import javax.swing.JFrame;


public class frameoflife extends JFrame{

    public frameoflife()
    {

        add(new lifefield());
        setSize(1300,700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // this will stop the gui
    }


    public static void main(String[] args) {
        // write your code here
        new frameoflife();

    }








}