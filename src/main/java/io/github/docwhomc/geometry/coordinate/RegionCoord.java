package io.github.docwhomc.geometry.coordinate;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.floorDiv;

public class RegionCoord extends AbstractCoord {
    public RegionCoord() {
        super();
    }

    public RegionCoord(int x, int z) {
        super(x, z);
    }

    public RegionCoord(@NotNull Coord coord) {
        this(floorDiv(coord.x, REGION_WIDTH_IN_BLOCKS), floorDiv(coord.z, REGION_WIDTH_IN_BLOCKS));
    }

    public RegionCoord(@NotNull ChunkCoord coord) {
        this(floorDiv(coord.x, REGION_WIDTH_IN_CHUNKS), floorDiv(coord.z, REGION_WIDTH_IN_CHUNKS));
    }

    public RegionCoord(@NotNull RegionCoord coord) {
        this(coord.x, coord.z);
    }
}
