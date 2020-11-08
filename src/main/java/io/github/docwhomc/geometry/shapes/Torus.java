package io.github.docwhomc.geometry.shapes;

import io.github.docwhomc.geometry.Shape;
import io.github.docwhomc.geometry.coordinate.Coord;

public class Torus extends Rectangle {
    static Shape SHAPE = Shape.TORUS;

    public Torus(Coord center, int xWidth, int zWidth) {
        super(center, xWidth, zWidth);
    }
}
