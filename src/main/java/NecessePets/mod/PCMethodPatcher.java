package NecessePets.mod;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.hostile.bosses.VoidWizard;
import necesse.entity.mobs.hostile.pirates.PirateCaptainMob;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;
import net.bytebuddy.asm.Advice;


@ModMethodPatch(target = PirateCaptainMob.class, name = "getLootTable", arguments = {})
public class PCMethodPatcher {

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@Advice.This PirateCaptainMob boss) {
        return true;
    }

    @Advice.OnMethodExit
    static void onExit(@Advice.This PirateCaptainMob boss, @Advice.Return(readOnly = false) LootTable lootTable) {

        lootTable = new LootTable(new LootItemInterface[]{LootItem.between("coin", 300, 500), new ChanceLootItem(0.2F, "siegevinyl"),
                new ChanceLootItem(.0625F,"pcpetitem")});
    }

}