package dev.tobynguyen27.definedsblocks.mods.botania

import dev.tobynguyen27.definedsblocks.registry.GlassRegistry
import net.minecraft.world.level.block.GlassBlock

object BotaniaBlocks {
    val MANA_GLASS = GlassRegistry.block("mana_glass", ::GlassBlock)

    val ELF_GLASS = GlassRegistry.block("elf_glass", ::GlassBlock)

    fun init() {}
}