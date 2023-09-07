package NecessePets.mod;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.hostile.bosses.AncientVultureMob;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;

import net.bytebuddy.asm.Advice;


@ModMethodPatch(target = AncientVultureMob.class, name = "getLootTable", arguments = {})
public class AVMethodPatcher {

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@Advice.This AncientVultureMob boss) {
        return true;
    }

    @Advice.OnMethodExit
    static void onExit(@Advice.This AncientVultureMob boss, @Advice.Return(readOnly = false) LootTable lootTable) {

        lootTable = new LootTable(new LootItemInterface[]{new ChanceLootItem(0.1F, "vulturemask"), new ChanceLootItem(0.2F, "beatdownvinyl"),
                new ChanceLootItem(.0625F,"avpetitem")});
    }

}