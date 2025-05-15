package dev.tobynguyen27.definedsblocks.registry

import com.tterrag.registrate.util.DataIngredient
import com.tterrag.registrate.util.entry.BlockEntry
import dev.tobynguyen27.definedsblocks.DefinedsBlocks.Companion.REGISTRATE
import dev.tobynguyen27.definedsblocks.tags.CTags
import dev.tobynguyen27.definedsblocks.utils.TextFormatting
import net.minecraft.client.renderer.RenderType
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import java.util.function.Supplier

object GlassRegistry {
    fun <T : Block> block(
        name: String,
        englishName: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block<T>(name, blockSupplier)
            .lang(englishName)
            .properties { p -> p.strength(0.3f).sound(SoundType.GLASS).noOcclusion() }
            .initialProperties(Material.GLASS)
            .tag(BlockTags.IMPERMEABLE, CTags.GLASS_TAG)
            .simpleItem()
            .recipe { ctx, prov ->
                prov.stonecutting(DataIngredient.stacks(Blocks.GLASS.asItem().defaultInstance)) {
                    ctx.get()
                }
            }
            .addLayer { Supplier {RenderType.translucent()} }
            .register()
    }

    fun <T : Block> block(
        name: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return block(name, TextFormatting.toEnglishName(name), blockSupplier)
    }
}
