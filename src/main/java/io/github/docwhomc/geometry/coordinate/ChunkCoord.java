package io.github.docwhomc.geometry.coordinate;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.floorDiv;

public class ChunkCoord extends AbstractCoord {
    public ChunkCoord() {
        super();
    }

    public ChunkCoord(int x, int z) {
        super(x, z);
    }

    public ChunkCoord(@NotNull Coord coord) {
        this(floorDiv(coord.x, CHUNK_WIDTH_IN_BLOCKS), floorDiv(coord.z, CHUNK_WIDTH_IN_BLOCKS));
    }

    public ChunkCoord(@NotNull ChunkCoord coord) {
        this(coord.x, coord.z);
    }

    public ChunkCoord(@NotNull RegionCoord coord) {
        this(coord.x * REGION_WIDTH_IN_CHUNKS, coord.z * REGION_WIDTH_IN_CHUNKS);
    }
}
