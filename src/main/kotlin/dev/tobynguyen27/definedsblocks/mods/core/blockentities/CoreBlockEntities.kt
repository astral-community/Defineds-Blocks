package dev.tobynguyen27.definedsblocks.mods.core.blockentities

import com.tterrag.registrate.util.entry.BlockEntityEntry
import dev.tobynguyen27.definedsblocks.mods.core.CoreBlocks
import net.minecraft.core.Registry

object CoreBlockEntities {
    val MIKU_BLOCK_ENTITY =
        BlockEntityEntry.cast<MikuBlockEntity>(
            CoreBlocks.MIKU.getSibling(Registry.BLOCK_ENTITY_TYPE_REGISTRY)
        )

    fun init() {}
}
