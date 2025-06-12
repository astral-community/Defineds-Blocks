package dev.tobynguyen27.definedsblocks.mods.core

import dev.tobynguyen27.definedsblocks.DefinedsBlocks
import dev.tobynguyen27.definedsblocks.mods.core.blockentities.MikuBlockEntity
import dev.tobynguyen27.definedsblocks.mods.core.blocks.Miku
import dev.tobynguyen27.definedsblocks.registry.MossBlockRegistry
import dev.tobynguyen27.definedsblocks.registry.MossBlockRegistry.MossBlockType
import dev.tobynguyen27.definedsblocks.utils.TextFormatting
import net.minecraft.client.renderer.RenderType
import net.minecraft.world.level.block.Block
import java.util.function.Supplier

object CoreBlocks {
    val MIKU = DefinedsBlocks.REGISTRATE.block<Miku>(Miku.ID, ::Miku).lang(TextFormatting.toEnglishName(Miku.ID)).blockEntity { type, pos, state ->
        MikuBlockEntity(type, pos, state)
    }.build().addLayer { Supplier { RenderType.translucent() } }.simpleItem().register()

    val MOSSIER_STONE_BRICKS =
        MossBlockRegistry.block("mossier_stone_bricks", MossBlockType.STONE_BRICKS, ::Block)
    val FLOWERY_MOSSY_STONE_BRICKS =
        MossBlockRegistry.block("flowery_mossy_stone_bricks", MossBlockType.STONE_BRICKS, ::Block)
    val FLOWERY_MOSSIER_STONE_BRICKS =
        MossBlockRegistry.block("flowery_mossier_stone_bricks", MossBlockType.STONE_BRICKS, ::Block)

    val MOSSY_COARSE_DIRT =
        MossBlockRegistry.block("mossy_coarse_dirt", MossBlockType.DIRT, ::Block)
    val FLOWERY_MOSSY_COARSE_DIRT =
        MossBlockRegistry.block("flowery_mossy_coarse_dirt", MossBlockType.DIRT, ::Block)

    val MOSSY_DEEPSLATE_TILES =
        MossBlockRegistry.block("mossy_deepslate_tiles", MossBlockType.DEEPSLATE, ::Block)
    val FLOWERY_MOSSY_DEEPSLATE_TILES =
        MossBlockRegistry.block("flowery_mossy_deepslate_tiles", MossBlockType.DEEPSLATE, ::Block)

    val MOSSY_DEEPSLATE_BRICKS =
        MossBlockRegistry.block("mossy_deepslate_bricks", MossBlockType.DEEPSLATE, ::Block)
    val FLOWERY_MOSSY_DEEPSLATE_BRICKS =
        MossBlockRegistry.block("flowery_mossy_deepslate_bricks", MossBlockType.DEEPSLATE, ::Block)

    fun init() {}
}
