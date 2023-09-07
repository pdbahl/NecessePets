package NecessePets.mod;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.hostile.bosses.CryoQueenMob;
import necesse.entity.mobs.hostile.bosses.VoidWizard;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;
import net.bytebuddy.asm.Advice;


@ModMethodPatch(target = CryoQueenMob.class, name = "getLootTable", arguments = {})
public class CQMethodPatcher {

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@Advice.This CryoQueenMob boss) {
        return true;
    }

    @Advice.OnMethodExit
    static void onExit(@Advice.This CryoQueenMob boss, @Advice.Return(readOnly = false) LootTable lootTable) {

        lootTable = new LootTable(new LootItemInterface[]{new ChanceLootItem(0.2F, "milleniumvinyl"),
                new ChanceLootItem(.0625F,"cqpetitem")});
    }

}