package io.github.docwhomc.geometry.shapes;

import io.github.docwhomc.geometry.Shape;
import io.github.docwhomc.geometry.coordinate.ChunkCoord;
import io.github.docwhomc.geometry.coordinate.Coord;
import io.github.docwhomc.geometry.coordinate.Loc;
import io.github.docwhomc.geometry.coordinate.RegionCoord;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractShape {

    int[] xCoordOuterLim, zCoordOuterLim;
    int[] xLocOuterLim, zLocOuterLim;
    @NotNull
    Coord center;

    @Contract(pure = true)
    AbstractShape() {
        this.center = new Coord();
    }

    @Contract(pure = true)
    AbstractShape(@NotNull Coord center) {
        this.center = center;
    }

    @NotNull
    public Coord getCenter() {
        return center;
    }

    @NotNull
    public abstract Shape getShape();

    public boolean inside(@NotNull Coord coord) {
        return xCoordOuterLim[0] <= coord.x && coord.x <= xCoordOuterLim[1]
                && zCoordOuterLim[0] <= coord.z && coord.z <= zCoordOuterLim[1];
    }

    public boolean inside(@NotNull ChunkCoord coord) {
        return inside(new Coord(coord));
    }

    public boolean inside(@NotNull RegionCoord coord) {
        return inside(new Coord(coord));
    }

    public boolean inside(@NotNull Loc loc) {
        return xLocOuterLim[0] <= loc.x && loc.x <= xLocOuterLim[1]
                && zLocOuterLim[0] <= loc.z && loc.z <= zLocOuterLim[1];
    }

    public boolean outside(@NotNull Coord coord) {
        return coord.x < xCoordOuterLim[0] || xCoordOuterLim[1] < coord.x
                || coord.z < zCoordOuterLim[0] && zCoordOuterLim[1] < coord.z;
    }

    public boolean outside(@NotNull ChunkCoord coord) {
        return outside(new Coord(coord));
    }

    public boolean outside(@NotNull RegionCoord coord) {
        return outside(new Coord(coord));
    }

    public boolean outside(@NotNull Loc loc) {
        return loc.x < xLocOuterLim[0] || xLocOuterLim[1] < loc.x
                || loc.z < zLocOuterLim[0] && zLocOuterLim[1] < loc.z;
    }

    void setBounds(int fullWidth) {
        assert fullWidth > 0;
        int halfWidth = fullWidth / 2;
        if (fullWidth % 2 == 0) {
            // Even
            xCoordOuterLim = new int[]{center.x - halfWidth, center.x + halfWidth - 1};
            xLocOuterLim = new int[]{center.x - halfWidth, center.x + halfWidth};
            zCoordOuterLim = new int[]{center.z - halfWidth, center.z + halfWidth - 1};
            zLocOuterLim = new int[]{center.z - halfWidth, center.z + halfWidth};
        } else {
            // Odd
            xCoordOuterLim = new int[]{center.x - halfWidth, center.x + halfWidth};
            xLocOuterLim = new int[]{center.x - halfWidth, center.x + halfWidth + 1};
            zCoordOuterLim = new int[]{center.z - halfWidth, center.z + halfWidth};
            zLocOuterLim = new int[]{center.z - halfWidth, center.z + halfWidth + 1};
        }
    }

    void setBounds(int xFullWidth, int zFullWidth) {
        setXBounds(xFullWidth);
        setZBounds(zFullWidth);
    }

    void setXBounds(int xFullWidth) {
        assert xFullWidth > 0;
        int xHalfWidth = xFullWidth / 2;
        if (xFullWidth % 2 == 0) {
            // Even
            xCoordOuterLim = new int[]{center.x - xHalfWidth, center.x + xHalfWidth - 1};
            xLocOuterLim = new int[]{center.x - xHalfWidth, center.x + xHalfWidth};
        } else {
            // Odd
            xCoordOuterLim = new int[]{center.x - xHalfWidth, center.x + xHalfWidth};
            xLocOuterLim = new int[]{center.x - xHalfWidth, center.x + xHalfWidth + 1};
        }
    }

    void setZBounds(int zFullWidth) {
        assert zFullWidth > 0;
        int zHalfWidth = zFullWidth / 2;
        if (zFullWidth % 2 == 0) {
            // Even
            zCoordOuterLim = new int[]{center.z - zHalfWidth, center.z + zHalfWidth - 1};
            zLocOuterLim = new int[]{center.z - zHalfWidth, center.z + zHalfWidth};
        } else {
            // Odd
            zCoordOuterLim = new int[]{center.z - zHalfWidth, center.z + zHalfWidth};
            zLocOuterLim = new int[]{center.z - zHalfWidth, center.z + zHalfWidth + 1};
        }
    }
}
