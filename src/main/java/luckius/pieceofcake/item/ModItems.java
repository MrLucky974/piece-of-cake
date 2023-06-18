package luckius.pieceofcake.item;

import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import luckius.pieceofcake.item.custom.CakePieceItem;
import net.minecraft.item.Item;

public class ModItems implements ItemRegistryContainer {
    public static final Item CAKE_PIECE = new CakePieceItem();
}
