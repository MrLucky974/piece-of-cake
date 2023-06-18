package luckius.pieceofcake.mixin;

import luckius.pieceofcake.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(Block.class)
public abstract class CakeBlockMixin extends AbstractBlock implements ItemConvertible {
    public CakeBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    private static void mixin$getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> returnValue = cir.getReturnValue();

        if (state.getBlock() instanceof CakeBlock) {
            int remainingBites = (CakeBlock.MAX_BITES - state.get(CakeBlock.BITES)) + 1;

            List<ItemStack> cakeDrops = new ArrayList<>();
            for (int i = 0; i < remainingBites; i++) {
                ItemStack itemStack = new ItemStack(ModItems.CAKE_PIECE, 1);
                cakeDrops.add(itemStack);
            }
            cir.setReturnValue(cakeDrops);
            return;
        }

        cir.setReturnValue(returnValue);
    }
}
