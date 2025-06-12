package dev.tobynguyen27.definedsblocks

import com.tterrag.registrate.Registrate
import dev.tobynguyen27.definedsblocks.mods.ae2.AE2Mod
import dev.tobynguyen27.definedsblocks.mods.botania.BotaniaBlocks
import dev.tobynguyen27.definedsblocks.mods.core.CoreBlocks
import dev.tobynguyen27.definedsblocks.mods.core.CoreMod
import dev.tobynguyen27.definedsblocks.utils.Identifier
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import org.slf4j.LoggerFactory

class DefinedsBlocks : ModInitializer {
    companion object {
        val MOD_ID = "definedsblocks"
        val MOD_NAME = "Defined's Blocks"
        val LOGGER = LoggerFactory.getLogger(MOD_NAME)

        val REGISTRATE = Registrate.create(MOD_ID)

        val ITEM_GROUP =
            FabricItemGroupBuilder.build(Identifier("general")) {
                CoreBlocks.MOSSIER_STONE_BRICKS.get().asItem().defaultInstance
            }
    }

    override fun onInitialize() {
        REGISTRATE.creativeModeTab { ITEM_GROUP }
        REGISTRATE.addRawLang("itemGroup.${MOD_ID}.general", "Defined's Blocks")

        CoreMod.init()
        AE2Mod.init()
        BotaniaBlocks.init()

        REGISTRATE.register()
    }
}
