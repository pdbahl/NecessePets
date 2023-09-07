package NecessePets.mod;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.hostile.bosses.EvilsProtectorMob;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;
import net.bytebuddy.asm.Advice;


@ModMethodPatch(target = EvilsProtectorMob.class, name = "getLootTable", arguments = {})
public class EPMethodPatcher {

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@Advice.This EvilsProtectorMob ep) {

        System.out.println("Entered EvilsProtectorMob.getLootTable(): " + ep.getStringID());

        return true;
    }

    @Advice.OnMethodExit
    static void onExit(@Advice.This EvilsProtectorMob ep, @Advice.Return(readOnly = false) LootTable lootTable) {

        lootTable = new LootTable(new LootItemInterface[]{new LootItem("demonicbar", 12),
                new ChanceLootItem(0.2F, "firsttrialvinyl"),
                new ChanceLootItem(.0625F,"eppetitem")});

        System.out.println("Exited EvilsProtectorMob.getLootTable() " + ep.getStringID() + " with new return value: " + lootTable);
    }

}