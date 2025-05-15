package dev.tobynguyen27.definedsblocks.datagen

import dev.tobynguyen27.definedsblocks.DefinedsBlocks
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraftforge.common.data.ExistingFileHelper

class DefinedsBlocksDataGen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val helper = ExistingFileHelper.withResourcesFromArg()

        DefinedsBlocks.REGISTRATE.setupDatagen(fabricDataGenerator, helper)
    }
}
