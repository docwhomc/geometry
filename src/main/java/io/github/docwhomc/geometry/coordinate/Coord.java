package io.github.docwhomc.geometry.coordinate;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Coord extends AbstractCoord {
    public Coord() {
        super();
    }

    @Contract(pure = true)
    public Coord(int x, int z) {
        super(x, z);
    }

    public Coord(@NotNull Coord coord) {
        this(coord.x, coord.z);
    }

    public Coord(@NotNull ChunkCoord coord) {
        this(coord.x * CHUNK_WIDTH_IN_BLOCKS, coord.z * CHUNK_WIDTH_IN_BLOCKS);
    }

    public Coord(@NotNull RegionCoord coord) {
        this(coord.x * REGION_WIDTH_IN_BLOCKS, coord.z * REGION_WIDTH_IN_BLOCKS);
    }
}
