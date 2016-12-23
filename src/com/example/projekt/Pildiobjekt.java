package com.example.projekt;

import javafx.scene.image.ImageView;

/**
 * Created by lotte-triin on 23.12.2016.
 */

public class Pildiobjekt extends ImageView {

    public Pildiobjekt(String url) {
        super(url);
    }

    public void setCenterX(double X) {
        this.setX(X - this.getImage().getHeight()/2);
    }
    public void setCenterY(double Y) {
        this.setY(Y - this.getImage().getWidth()/2);
    }
}
