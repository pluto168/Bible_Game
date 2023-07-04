package com.company.Sprite;


import com.company.Main;

import javax.swing.*;
import java.awt.*;

public abstract class Sprite {

    protected ImageIcon img;
    protected Point relativePosition;   //相對位子
    protected Point absolutePosition;   //絕對位子

    public void draw(Graphics g){
        img.paintIcon(null, g, absolutePosition.x, absolutePosition.y);
    }

    public void setPosition(int x,int y){
        relativePosition = new Point(x,y);
        absolutePosition = new Point((x-1) * Main.CELL,(y-1) * Main.CELL);
    }
}
