package dev.tobynguyen27.definedsblocks.tags

import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block

object CTags {
    val GLASS_TAG: TagKey<Block> =
        TagKey.create(
            ResourceKey.createRegistryKey(ResourceLocation("c", "glass")),
            ResourceLocation("c", "glass")
        )
}
