package io.github.docwhomc.geometry.coordinate;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public abstract class AbstractCoord {
    final static int CHUNK_WIDTH_IN_BLOCKS = 16;
    final static int REGION_WIDTH_IN_CHUNKS = 32;
    final static int REGION_WIDTH_IN_BLOCKS = REGION_WIDTH_IN_CHUNKS * CHUNK_WIDTH_IN_BLOCKS;
    public final int x, z;

    public AbstractCoord() {
        this(0, 0);
    }

    public AbstractCoord(int x, int z) {
        this.x = x;
        this.z = z;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCoord abstractCoord = (AbstractCoord) o;
        return x == abstractCoord.x && z == abstractCoord.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, z);
    }
}
