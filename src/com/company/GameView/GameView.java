package com.company.GameView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import com.company.Main;
import com.company.Sprite.*;
import com.company.Sprite.RedSeaViewSprite.Cat;

public abstract class GameView {                //抽象类是一种特殊的类，无法直接实例化，只能被继承。

    protected ArrayList<Sprite> elements;        //Sprite就是一個圖檔,可以到處移動
    protected Door door;                         //把Door import進來
    protected ImageIcon img;                     //每一個gameView都有自己的背景

    public void drawView(Graphics g){
        img.paintIcon(null, g, 0, 0);
        g.setColor(new Color(0f,0f,0f,.3f)); //背景黑色遮罩
        g.fillRect(0,0, Main.WIDTH,Main.HEIGHT);
        for(Sprite s : elements){
            s.draw(g);
        }
    }

    public Door getDoor(){
        return this.door;
    }

    public ArrayList<Sprite> getElements(){
        return this.elements;
    }

}
