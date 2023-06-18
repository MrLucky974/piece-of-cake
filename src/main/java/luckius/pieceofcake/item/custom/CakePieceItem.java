package luckius.pieceofcake.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class CakePieceItem extends Item {
    public CakePieceItem() {
        super(new FabricItemSettings()
                .maxCount(8)
                .food(new FoodComponent.Builder()
                        .hunger(2)
                        .saturationModifier(0.1F)
                        .build()
                ));
    }
}
