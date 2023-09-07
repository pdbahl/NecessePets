package NecessePets.mod;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.hostile.bosses.FallenWizardGhostMob;
import necesse.entity.mobs.hostile.bosses.FallenWizardMob;
import necesse.entity.mobs.hostile.bosses.FlyingSpiritsHead;
import necesse.entity.mobs.hostile.bosses.VoidWizard;
import necesse.entity.mobs.hostile.pirates.PirateCaptainMob;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;
import net.bytebuddy.asm.Advice;


@ModMethodPatch(target = FallenWizardMob.class, name = "getLootTable", arguments = {})
public class FWMethodPatcher {

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@Advice.This FallenWizardMob boss) {
        return true;
    }

    @Advice.OnMethodExit
    static void onExit(@Advice.This FallenWizardMob boss, @Advice.Return(readOnly = false) LootTable lootTable) {

        lootTable = new LootTable(new LootItemInterface[]{new LootItem("gatewaytablet"), new ChanceLootItem(0.2F, "wizardsrematchvinyl"),
                new ChanceLootItem(.0625F,"fwpetitem")});
    }

}