package UI;
import  BL.UI_interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import BL.UI_implementation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.AncestorListener;


public class grid implements ActionListener {
    private JPanel maingrid;
    private JPanel top;
    private JPanel controlpanel;
    private JFrame frame;
    private JButton[][] cellmap;
    boolean[][] state;
    private JButton strt;
    private JButton nxt;
    private JButton reset;
    private int hieght;
    private int width;
    private JLabel name;
    boolean gameRunning = false;

    public grid() {
        width = 50;
        hieght = 50;
        frame = new JFrame();

        maingrid = new JPanel();
        top = new JPanel();
        controlpanel = new JPanel();
        name = new JLabel("John Conway's Game of Life");
        name.setFont(new Font("Calibri", Font.PLAIN, 20));

        cellmap = new JButton[hieght][width];

        strt = new JButton("Start");
        nxt = new JButton("Next");
        reset = new JButton("Reset");
        //load = new JButton("Load");

    }

    public void initite_JButton_grid() {

        state = new boolean[hieght][width];

        for (int i = 0; i < hieght; i++) {
            for (int j = 0; j < width; j++) {
                cellmap[i][j] = new JButton();
                maingrid.add(cellmap[i][j]);
                cellmap[i][j].setBackground(Color.black);
                state[i][j] = false;
                int xnum = i;
                int ynum = j;
                cellmap[i][j].addActionListener(e -> cellmap[xnum][ynum].setBackground(Color.white));
            }
        }
    }

    public void display_state() {
        for (int i = 0; i < hieght; i++) {
            for (int j = 0; j < width; j++) {

                if (state[i][j]) {
                    cellmap[i][j].setBackground(Color.white);
                } else {
                    cellmap[i][j].setBackground(Color.black);
                }
            }
        }
    }

    public void setup_panels() {
        maingrid.setBackground(Color.black);
        controlpanel.setBackground(Color.white);
        top.setBackground(Color.gray);
        maingrid.setLayout(new GridLayout(hieght, width));
        top.add(name);


        controlpanel.setLayout(new GridLayout(1, 4));
        controlpanel.add(reset);
        reset.addActionListener(this);
        reset.setBackground(Color.orange);
        controlpanel.add(strt);
        strt.addActionListener(this);
        strt.setBackground(Color.orange);
        controlpanel.add(nxt);
        nxt.addActionListener(this);
        nxt.setBackground(Color.orange);
        top.setPreferredSize(new Dimension(500, 40));
        controlpanel.setPreferredSize(new Dimension(500, 40));

    }

    public void setup_frame() {
        frame.add(top, BorderLayout.NORTH);
        frame.add(controlpanel, BorderLayout.SOUTH);
        frame.add(maingrid, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sameed's UI");

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public void start_fun() {
        UI_interface ui = new UI_implementation();

        state = ui.arr(state, hieght, width);

    }
    public void make_UI(grid g)
    {
        g.initite_JButton_grid();
         g.setup_panels();
         g.setup_frame();
         g.set_initial_state();



    }
    public void set_initial_state()
    {
        for (int i = 0; i < 15; i++) {
           state[15][15 + i] = true;
        }
    }
    @Override
    public synchronized void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object userAction = e.getSource();
        // start button
        if (userAction == strt) {
//           gameRunning=true;
//            System.out.println("Start");
        }
        if (userAction == nxt) {
            grid g=new grid();
            g.make_UI(g);


            gameRunning=true;
            System.out.println("Start");
        }
//        // stop button
//        if(userAction == bStop)
//            timer.stop();
//            gameRunning = false;
//            bStop.setEnabled(false);
//            bStart.setEnabled(true);
//            return;
//        }
//
//        // the clear button
//        if(userAction == bClear) {
//            timer.stop();
//            gameRunning = false;
//            bStop.setEnabled(false);
//            bStart.setEnabled(true);
//
//            // clear all cells
//            for(int r = 1; r < board.length -1; r++) {
//                for(int c = 1; c < board[r].length -1; c++) {
//                    board[r][c].clear();
//                }
//            }
    }

    public static void main(String[] args) {
        grid my = new grid();
        my.initite_JButton_grid();
        my.setup_panels();
        my.setup_frame();
        for (int i = 0; i < 15; i++) {
            my.state[15][15 + i] = true;
        }
        my.display_state();
        Scanner scan = new Scanner(System.in);
            do {
                my.display_state();
                my.start_fun();


                System.out.print("Another? (y/n): ");
            } while (scan.nextLine().charAt(0) == 'y');


//        while (my.gameRunning== true)
//        {
//            my.start_fun();
//            my.display_state();
//            my.gameRunning=false;
//        }


//

    }




}
