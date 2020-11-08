package io.github.docwhomc.geometry.shapes;

import io.github.docwhomc.geometry.Shape;
import io.github.docwhomc.geometry.coordinate.Coord;
import io.github.docwhomc.geometry.coordinate.Loc;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class CubeCross extends AbstractShape {
    final static Shape SHAPE = Shape.CUBE;
    int[] xCoordLim, zCoordLim;
    int[] xLocLim, zLocLim;
    private int width;

    @Contract(pure = true)
    CubeCross(Coord center, int width) {
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

    @Override
    public boolean inside(@NotNull Coord coord) {
        if (super.outside(coord)) return false;
        if (xCoordLim[0] <= coord.x && coord.x <= xCoordLim[1]) return true;
        return zCoordLim[0] < coord.z && coord.z < zCoordLim[1];
    }

    @Override
    public boolean inside(@NotNull Loc loc) {
        if (super.outside(loc)) return false;
        if (xLocLim[0] <= loc.x && loc.x <= xLocLim[1]) return true;
        return zLocLim[0] < loc.z && loc.z < zLocLim[1];
    }

    @Override
    public boolean outside(@NotNull Coord coord) {
        if (super.outside(coord)) return true;
        return (coord.x < xCoordLim[0] || xCoordLim[1] < coord.x) && (coord.z < zCoordLim[0] || zCoordLim[1] < coord.z);
    }

    @Override
    public boolean outside(@NotNull Loc loc) {
        if (super.outside(loc)) return true;
        return (loc.x < xLocLim[0] || xLocLim[1] < loc.x) && (loc.z < zLocLim[0] || zLocLim[1] < loc.z);
    }

    @Override
    void setBounds(int width) {
        super.setBounds(width * 4, width * 3);
        int halfWidth = width / 2;
        xCoordLim = new int[]{center.x, center.x + width - 1};
        xLocLim = new int[]{center.x, center.x + width};
        if (width % 2 == 0) {
            // Even
            zCoordLim = new int[]{center.z - halfWidth, center.z + halfWidth - 1};
            zLocLim = new int[]{center.z - halfWidth, center.z + halfWidth};
        } else {
            // Odd
            zCoordLim = new int[]{center.z - halfWidth, center.z + halfWidth};
            zLocLim = new int[]{center.z - halfWidth, center.z + halfWidth + 1};
        }
    }
}
