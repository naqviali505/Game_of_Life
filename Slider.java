import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider implements ChangeListener{

    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;

    Slider(JFrame  frame1){

        frame =frame1;
        panel =new JPanel();
        label = new JLabel();
        slider = new JSlider(0,100,50);

        slider.setPreferredSize(new Dimension(550,50));

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);

        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,8));
        label.setFont(new Font("MV Boli",Font.PLAIN,10));

        //slider.setOrientation(SwingConstants.HORIZONTAL);
       // slider.setOrientation(SwingConstants.VERTICAL);

        label.setText("°C = "+ slider.getValue());

        slider.addChangeListener(this);

        panel.add(slider);
        panel.add(label);
        frame.add(panel,BorderLayout.SOUTH);
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        label.setText("°C = "+ slider.getValue());
        //setspeed(slider.getValue());
        //This function shall be implemented by BL

    }

}