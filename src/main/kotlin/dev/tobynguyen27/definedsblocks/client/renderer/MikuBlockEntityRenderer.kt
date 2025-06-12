package dev.tobynguyen27.definedsblocks.client.renderer

import com.mojang.blaze3d.vertex.DefaultVertexFormat
import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.blaze3d.vertex.VertexFormat
import dev.tobynguyen27.definedsblocks.mods.core.blockentities.MikuBlockEntity
import dev.tobynguyen27.definedsblocks.utils.Identifier
import net.minecraft.client.renderer.GameRenderer
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.RenderStateShard
import net.minecraft.client.renderer.RenderStateShard.ShaderStateShard
import net.minecraft.client.renderer.RenderStateShard.TextureStateShard
import net.minecraft.client.renderer.RenderType
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.core.Direction
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.HorizontalDirectionalBlock
import tobynguyen27.codebebelib.math.MathHelper
import tobynguyen27.codebebelib.render.CCModel
import tobynguyen27.codebebelib.render.CCRenderState
import tobynguyen27.codebebelib.render.model.OBJParser
import tobynguyen27.codebebelib.vec.Matrix4
import tobynguyen27.codebebelib.vec.Rotation

class MikuBlockEntityRenderer(ctx: BlockEntityRendererProvider.Context): BlockEntityRenderer<MikuBlockEntity> {
    companion object {
        val MIKU = RenderType.create(
            "definedblocks:miku", DefaultVertexFormat.BLOCK, VertexFormat.Mode.TRIANGLES, 256,
            RenderType.CompositeState.builder()
                .setShaderState(ShaderStateShard { GameRenderer.getRendertypeCutoutShader() })
                .setTextureState(
                    TextureStateShard(
                        Identifier("textures/obj/miku.png"),
                        false,
                        false
                    )
                )
                .setTransparencyState(RenderStateShard.NO_TRANSPARENCY)
                .setLightmapState(RenderStateShard.LIGHTMAP)
                .createCompositeState(false)
        )
    }

    val map = OBJParser(Identifier("models/obj/miku.obj")).ignoreMtl().parse()
    val model = CCModel.combine(map.values).backfacedCopy().computeNormals()

    override fun render(
        blockEntity: MikuBlockEntity,
        partialTick: Float,
        poseStack: PoseStack,
        bufferSource: MultiBufferSource,
        packedLight: Int,
        packedOverlay: Int
    ) {
        val mat = Matrix4(poseStack)
        val ccrs = CCRenderState.instance()

        ccrs.reset()
        ccrs.brightness = 150
        ccrs.overlay = packedOverlay

        mat.translate(0.5, 0.0, 0.5)
        mat.scale(0.75)


        val angle = when (blockEntity.blockState.getValue(HorizontalDirectionalBlock.FACING)) {
            Direction.WEST  -> 0.0                     // default facing, no rotation
            Direction.SOUTH -> Math.PI / 2            // rotate 90° around Y
            Direction.EAST  -> Math.PI                // rotate 180°
            Direction.NORTH -> -Math.PI / 2           // rotate -90°
            else -> 0.0
        }
        mat.rotate(Rotation(angle, 0.0, 1.0, 0.0))

        ccrs.baseColour = 0xFFFFFFF0.toInt();
        ccrs.bind(MIKU, bufferSource);
        model.render(ccrs, mat);
    }
}