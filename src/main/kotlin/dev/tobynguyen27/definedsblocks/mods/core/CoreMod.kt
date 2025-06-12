package dev.tobynguyen27.definedsblocks.mods.core

import dev.tobynguyen27.definedsblocks.mods.core.blockentities.CoreBlockEntities

object CoreMod {
    fun init() {
        CoreBlocks.init()
        CoreBlockEntities.init()
    }
}
