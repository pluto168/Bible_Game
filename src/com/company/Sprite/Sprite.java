package com.company.Sprite;


import com.company.Main;

import javax.swing.*;
import java.awt.*;

public abstract class Sprite {                          //抽象类是一种特殊的类，无法直接实例化，只能被继承。

    protected ImageIcon img;             //每一個Sprite都有自己的圖片
    protected Point relativePosition;   //相對位子,是一个类，表示二维平面上的一个点，通常由 x 和 y 坐标表示。
    protected Point absolutePosition;   //絕對位子

    public void draw(Graphics g){
        img.paintIcon(null, g, absolutePosition.x, absolutePosition.y);
    }

    public void setPosition(Point p){
        setPosition(p.x,p.y);
    }

    public void setPosition(int x,int y){
        relativePosition = new Point(x,y);
        absolutePosition = new Point((x-1) * Main.CELL,(y-1) * Main.CELL);
    }

    public void setNullPosition(){
        relativePosition = null;
        absolutePosition = null;
    }

    public Point getRelativePosition(){
        if(relativePosition == null){
            return null;
        }else{
            return new Point(relativePosition);
        }
    }

    public  abstract String overlap(int x, int y);
}
