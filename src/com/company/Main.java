package com.company;

import com.company.GameView.DisasterView;
import com.company.GameView.GameView;
import com.company.Sprite.Moses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {      //implements KeyListener使用鍵盤

    public static final int CELL = 50;    //每一格佔多少像素px
    public static final int WIDTH = 500;     //整個螢幕500x500
    public static final int HEIGHT = 500;

    public static final int ROW = HEIGHT / CELL;  //橫行的數量
    public static final int COLUMN = WIDTH / CELL;   //直行的數量

    Moses moses;
    public static GameView gameView;
    private int level;    //目前關卡的level在那裡

    public Main(){
        resetGame(new DisasterView());
        addKeyListener(this);

    }

    public void resetGame(GameView game){
        level = 1;
        //指定 Moses 对象的初始位置。
        moses = new Moses(1,1);
        gameView = game;
        repaint();
    }


    @Override
    public Dimension getPreferredSize(){
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g){
        // 在画板上绘制游戏视图
        gameView.drawView(g);
        // 绘制 Moses 对象
        moses.draw(g);
        //
        requestFocusInWindow();
    }

    public static void main(String[] args) {
        // 创建一个 JFrame 对象
        JFrame window = new JFrame();
        // 设置窗口关闭操作为退出应用程序
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 将 Main 对象设置为窗口的内容面板
        window.setContentPane(new Main());
        // 调整窗口大小以适应内容面板的大小
        window.pack();
        // 将窗口位置设置为屏幕中央
        window.setLocationRelativeTo(null);
        // 设置窗口可见
        window.setVisible(true);
        // 禁用窗口的调整大小功能
        window.setResizable(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point mossPoint = moses.getRelativePosition();
        //System.out.println(mossPoint.x+ ", "+ mossPoint.y);  //查看方向鍵座標
        switch (e.getExtendedKeyCode()){
            case KeyEvent.VK_UP:
                if(mossPoint.y > 1){
                    String result = moses.overlap(mossPoint.x,mossPoint.y - 1);
                    if(result.equals("Die")){
                        //reset game
                        JOptionPane.showMessageDialog(this,"你已經GG,請重新開始");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot move")){     //如果他不是遇到他不能動的情況
                        mossPoint.y -= 1;      //要按往上
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                if(mossPoint.y < ROW){
                    String result = moses.overlap(mossPoint.x,mossPoint.y + 1);
                    if(result.equals("Die")){
                        //reset game
                        JOptionPane.showMessageDialog(this,"你已經GG,請重新開始");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot move")){     //如果他不是遇到他不能動的情況
                        mossPoint.y += 1;      //按往下
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(mossPoint.x < COLUMN){
                    String result = moses.overlap(mossPoint.x + 1,mossPoint.y);
                    if(result.equals("Die")){
                        //reset game
                        JOptionPane.showMessageDialog(this,"你已經GG,請重新開始");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot move")){     //如果他不是遇到他不能動的情況
                        mossPoint.x += 1;      //往右
                    }
                }
                break;
            case KeyEvent.VK_LEFT:
                if(mossPoint.x > 1){     //>1代表可以在往左邊走
                    String result = moses.overlap(mossPoint.x - 1,mossPoint.y);
                    if(result.equals("Die")){
                        //reset game
                        JOptionPane.showMessageDialog(this,"你已經GG,請重新開始");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot move")){     //如果他不是遇到他不能動的情況
                        mossPoint.x -= 1;    //往左
                    }
                }
                break;
        }
        moses.setPosition(mossPoint);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
