package dev.tobynguyen27.definedsblocks.mods.core.blockentities

import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

class MikuBlockEntity(type: BlockEntityType<MikuBlockEntity>, pos: BlockPos, state: BlockState): BlockEntity(type, pos, state) {
}
