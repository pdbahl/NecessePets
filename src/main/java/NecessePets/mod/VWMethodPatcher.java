package NecessePets.mod;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.hostile.bosses.VoidWizard;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;
import net.bytebuddy.asm.Advice;


@ModMethodPatch(target = VoidWizard.class, name = "getLootTable", arguments = {})
public class VWMethodPatcher {

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@Advice.This VoidWizard boss) {
        return true;
    }

    @Advice.OnMethodExit
    static void onExit(@Advice.This VoidWizard boss, @Advice.Return(readOnly = false) LootTable lootTable) {

        lootTable = new LootTable(new LootItemInterface[]{new LootItem("voidshard", 25),
                new OneOfLootItems(LootItem.between("recallscroll", 12, 20), new LootItemInterface[]{LootItem.between("travelscroll", 5, 10)}),
                new ChanceLootItem(0.25F, "airlockfailurevinyl"),
                new ChanceLootItem(.0625F,"vwpetitem")});
    }

}