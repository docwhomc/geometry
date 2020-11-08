package io.github.docwhomc.geometry.shapes;

import io.github.docwhomc.geometry.Shape;
import io.github.docwhomc.geometry.coordinate.Coord;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Rectangle extends AbstractShape {
    static Shape SHAPE = Shape.RECTANGLE;
    private int xWidth, zWidth;

    @Contract(pure = true)
    public Rectangle(Coord center, int xWidth, int zWidth) {
        super(center);
        setWidth(xWidth, zWidth);
    }

    @Override
    @NotNull
    public Shape getShape() {
        return SHAPE;
    }

    public int getXWidth() {
        return xWidth;
    }

    void setXWidth(int xWidth) {
        if (xWidth < 1)
            throw new IllegalArgumentException("expected positive xWidth, got " + xWidth);
        this.xWidth = xWidth;
        setXBounds(xWidth);
    }

    public int getZWidth() {
        return zWidth;
    }

    void setZWidth(int zWidth) {
        if (zWidth < 1)
            throw new IllegalArgumentException("expected positive zWidth, got " + zWidth);
        this.zWidth = zWidth;
        setZBounds(zWidth);
    }

    void setWidth(int xWidth, int zWidth) {
        setXWidth(xWidth);
        setZWidth(zWidth);
    }
}
