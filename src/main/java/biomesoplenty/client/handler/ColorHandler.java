/*******************************************************************************
 * Copyright 2022, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package biomesoplenty.client.handler;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = BiomesOPlenty.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColorHandler
{
    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event)
    {
        event.getItemColors().register((stack, tintIndex) -> {
                    BlockState state = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
                    return event.getBlockColors().getColor(state, null, null, tintIndex); },
                BOPBlocks.MOSSY_BLACK_SAND.get(), BOPBlocks.SPROUT.get(), BOPBlocks.BUSH.get(), BOPBlocks.HIGH_GRASS.get(), BOPBlocks.HIGH_GRASS_PLANT.get(),
                BOPBlocks.CLOVER.get(), BOPBlocks.HUGE_CLOVER_PETAL.get(), BOPBlocks.HUGE_LILY_PAD.get(), BOPBlocks.FLOWERING_OAK_LEAVES.get(),
                BOPBlocks.MAHOGANY_LEAVES.get(), BOPBlocks.PALM_LEAVES.get(), BOPBlocks.WILLOW_LEAVES.get(), BOPBlocks.WILLOW_VINE.get(),
                BOPBlocks.BRAMBLE_LEAVES.get());
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event)
    {
        //Grass Coloring
        event.getBlockColors().register((state, world, pos, tintIndex) ->
                        world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.get(0.5D, 1.0D),
                BOPBlocks.MOSSY_BLACK_SAND.get(), BOPBlocks.SPROUT.get(), BOPBlocks.HIGH_GRASS.get(), BOPBlocks.HIGH_GRASS_PLANT.get(), BOPBlocks.CLOVER.get(),
                BOPBlocks.HUGE_CLOVER_PETAL.get(), BOPBlocks.BARLEY.get(), BOPBlocks.WATERGRASS.get(), BOPBlocks.POTTED_SPROUT.get());

        //Foliage Coloring
        event.getBlockColors().register((state, world, pos, tintIndex) ->
                        world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                BOPBlocks.BUSH.get(), BOPBlocks.FLOWERING_OAK_LEAVES.get(), BOPBlocks.MAHOGANY_LEAVES.get(), BOPBlocks.PALM_LEAVES.get(),
                BOPBlocks.WILLOW_LEAVES.get(), BOPBlocks.WILLOW_VINE.get(), BOPBlocks.BRAMBLE_LEAVES.get());

        //Rainbow Birch Leaf Coloring
        event.getBlockColors().register((state, world, pos, tintIndex) ->
                        world != null && pos != null ? getRainbowBirchColor(world, pos) : FoliageColor.getDefaultColor(),
                BOPBlocks.RAINBOW_BIRCH_LEAVES.get());

        //Flowerbed Coloring
        event.getBlockColors().register((state, world, pos, tintIndex) -> {
            if (tintIndex != 0) { return world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(); }
            else { return -1; }},
                BOPBlocks.WHITE_PETALS.get());

        //Lily Pad Coloring
        event.getBlockColors().register((state, world, pos, tintIndex) -> {
            return world != null && pos != null ? 2129968 : 7455580; },
                BOPBlocks.HUGE_LILY_PAD.get());
    }

    public static int getRainbowBirchColor(BlockAndTintGetter world, BlockPos pos)
    {
        Color foliage = Color.getHSBColor((((float)pos.getX() + Mth.sin(((float)pos.getZ() + (float)pos.getX()) / 35) * 35) % 150) / 150, 0.6F, 1.0F);

        return foliage.getRGB();
    }
}
