package io.github.docwhomc.geometry.shapes;

import io.github.docwhomc.geometry.Shape;
import io.github.docwhomc.geometry.coordinate.Coord;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Square extends AbstractShape {
    final static Shape SHAPE = Shape.SQUARE;
    private int width;

    @Contract(pure = true)
    Square(Coord center, int width) {
        super(center);
        this.setWidth(width);
    }

    @Override
    @NotNull
    public Shape getShape() {
        return SHAPE;
    }

    public int getWidth() {
        return width;
    }

    void setWidth(int width) {
        if (width < 1)
            throw new IllegalArgumentException("expected positive width, got " + width);
        this.width = width;
        setBounds(width);
    }
}
