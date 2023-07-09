package com.company.GameView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import com.company.Sprite.*;

public abstract class GameView {                //抽象类是一种特殊的类，无法直接实例化，只能被继承。

    protected ArrayList<Sprite> elements;        //Sprite就是一個圖檔,可以到處移動
    protected Door door;                         //把Door import進來
    protected ImageIcon img;                     //每一個gameView都有自己的背景

    public void drawView(Graphics g){
        img.paintIcon(null, g, 0, 0);
        for(Sprite s : elements){
            s.draw(g);
        }
    }
}
