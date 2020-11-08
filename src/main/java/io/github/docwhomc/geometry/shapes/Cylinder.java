package io.github.docwhomc.geometry.shapes;

import io.github.docwhomc.geometry.Shape;
import io.github.docwhomc.geometry.coordinate.Coord;

public class Cylinder extends Rectangle {
    static Shape SHAPE = Shape.CYLINDER;
    private char wrap;

    public Cylinder(Coord center, int xWidth, int zWidth, char wrap) {
        super(center, xWidth, zWidth);
        setWrap(wrap);
    }

    public char getWrap() {
        return wrap;
    }

    public void setWrap(char wrap) {
        if (wrap != 'x' && wrap != 'z')
            throw new IllegalArgumentException("expected wrap to be 'x' or 'z', got '" + wrap + "'");
        this.wrap = wrap;
    }
}
