package dev.tobynguyen27.definedsblocks.client

import dev.tobynguyen27.definedsblocks.client.renderer.MikuBlockEntityRenderer
import dev.tobynguyen27.definedsblocks.mods.core.blockentities.CoreBlockEntities
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry

class DefinedsBlocksClient : ClientModInitializer {
    override fun onInitializeClient() {

        BlockEntityRendererRegistry.register(
            CoreBlockEntities.MIKU_BLOCK_ENTITY.get(),
            ::MikuBlockEntityRenderer
        )
    }
}
