package dev.tobynguyen27.definedsblocks.mods.core.blocks

import dev.tobynguyen27.definedsblocks.mods.core.blockentities.CoreBlockEntities
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.BaseEntityBlock
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.HorizontalDirectionalBlock
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockBehaviour.Properties
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.Shapes
import net.minecraft.world.phys.shapes.VoxelShape

class Miku(properties: Properties) : BaseEntityBlock(properties) {
    companion object {
        const val ID = "hatsune_miku_plushie"

        val AABB = Shapes.box(0.25, 0.0, 0.25, 0.75, 0.75, 0.75)
        val FACING = HorizontalDirectionalBlock.FACING
    }

    init {
        registerDefaultState(with(defaultBlockState()) { setValue(FACING, Direction.NORTH) })
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        super.createBlockStateDefinition(builder)
        builder.add(FACING)
    }

    override fun setPlacedBy(
        level: Level,
        pos: BlockPos,
        state: BlockState,
        placer: LivingEntity?,
        stack: ItemStack
    ) {
        super.setPlacedBy(level, pos, state, placer, stack)

        if (placer !is Player) return
        level.setBlock(pos, level.getBlockState(pos).setValue(FACING, placer.direction), 3)
    }

    override fun getRenderShape(state: BlockState): RenderShape {
        return RenderShape.INVISIBLE
    }

    override fun getShape(
        state: BlockState,
        level: BlockGetter,
        pos: BlockPos,
        context: CollisionContext
    ): VoxelShape {
        return AABB
    }

    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return CoreBlockEntities.MIKU_BLOCK_ENTITY.create(pos, state)
    }
}
