package com.company.Sprite;


import com.company.GameView.DisasterView;
import com.company.Main;
import com.company.Sprite.DisasterViewSprite.Bug;
import com.company.Sprite.DisasterViewSprite.Frog;
import com.company.Sprite.DisasterViewSprite.Ice;
import com.company.Sprite.DisasterViewSprite.Tombstone;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Moses extends Sprite{
    public Moses(int x, int y){
        setPosition(x,y);
        img = new ImageIcon("Moses.png");
    }

    @Override
    public String overlap(int x, int y) {
        if(Main.gameView instanceof DisasterView){
            //check for bugs and frogs
            ArrayList<Frog> frogs = ((DisasterView) Main.gameView).getFrogs();
            ArrayList<Bug> bugs = ((DisasterView) Main.gameView).getBugs();
            for(Frog f: frogs){
                if (f.getRelativePosition() != null && x == f.getRelativePosition().x && y == f.getRelativePosition().y){
                    return "Die";
                }
            }
            for(Bug b: bugs){
                if (b.getRelativePosition() != null && x == b.getRelativePosition().x && y == b.getRelativePosition().y){
                    return "Die";
                }
            }
            //check for Ice and stone
            ArrayList<Ice> ices = ((DisasterView) Main.gameView).getIceCubes();
            ArrayList<Tombstone> tombstones = ((DisasterView) Main.gameView).getStones();
            for(Tombstone s: tombstones){
                if (s.getRelativePosition() != null && x == s.getRelativePosition().x && y == s.getRelativePosition().y){
                    return "Cannot move";
                }
            }
            for(Ice i: ices){
                if (i.getRelativePosition() != null && x == i.getRelativePosition().x && y == i.getRelativePosition().y){
                    return "Cannot move";
                }
            }

        }
        return "none";
    }

}
