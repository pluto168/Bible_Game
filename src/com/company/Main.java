package com.company;

import com.company.GameView.DisasterView;
import com.company.GameView.GameView;
import com.company.Sprite.Moses;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    public static final int CELL = 50;    //每一格佔多少像素
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public static final int ROW = HEIGHT / CELL;  //橫行
    public static final int COLUMN = WIDTH / CELL;   //直行

    Moses moses;
    public static GameView gameView;

    public Main(){
        moses = new Moses(1,1);
        gameView = new DisasterView();
    }


    @Override
    public Dimension getPreferredSize(){
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g){
        gameView.drawView(g);
        moses.draw(g);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }
}
