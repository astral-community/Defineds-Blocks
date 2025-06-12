package dev.tobynguyen27.definedsblocks.mods.core

import com.tterrag.registrate.util.DataIngredient
import dev.tobynguyen27.definedsblocks.DefinedsBlocks
import dev.tobynguyen27.definedsblocks.mods.core.blockentities.MikuBlockEntity
import dev.tobynguyen27.definedsblocks.mods.core.blocks.Miku
import dev.tobynguyen27.definedsblocks.registry.MossBlockRegistry
import dev.tobynguyen27.definedsblocks.registry.MossBlockRegistry.MossBlockType
import dev.tobynguyen27.definedsblocks.utils.TextFormatting
import net.minecraft.client.renderer.RenderType
import net.minecraft.data.recipes.RecipeProvider.has
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.tags.BlockTags
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.material.Material
import java.util.function.Supplier

object CoreBlocks {
    val MIKU = DefinedsBlocks.REGISTRATE.block<Miku>(Miku.ID, ::Miku).lang(TextFormatting.toEnglishName(Miku.ID)).blockEntity { type, pos, state ->
        MikuBlockEntity(type, pos, state)
    }.build().addLayer { Supplier { RenderType.translucent() } }.item().defaultModel().build().recipe { ctx, prov ->
        ShapedRecipeBuilder.shaped(ctx.entry).pattern(" A ").pattern("BCB").pattern(" B ").define("B".toCharArray()[0], Items.WHITE_WOOL).define("C".toCharArray()[0], Items.LIGHT_GRAY_WOOL).define("A".toCharArray()[0], Items.LIGHT_BLUE_WOOL).unlockedBy("has_wool", has(Items.WHITE_WOOL)).save(prov)
    }
        .tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .initialProperties(Material.STONE).register()

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
