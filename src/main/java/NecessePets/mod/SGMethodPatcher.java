package NecessePets.mod;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.hostile.bosses.ReaperMob;
import necesse.entity.mobs.hostile.bosses.SwampGuardianHead;
import necesse.entity.mobs.hostile.bosses.VoidWizard;
import necesse.entity.mobs.hostile.pirates.PirateCaptainMob;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.inventory.lootTable.lootItem.OneOfLootItems;
import net.bytebuddy.asm.Advice;


@ModMethodPatch(target = SwampGuardianHead.class, name = "getLootTable", arguments = {})
public class SGMethodPatcher {

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@Advice.This SwampGuardianHead boss) {
        return true;
    }

    @Advice.OnMethodExit
    static void onExit(@Advice.This SwampGuardianHead boss, @Advice.Return(readOnly = false) LootTable lootTable) {

        lootTable = new LootTable(new LootItemInterface[]{new ChanceLootItem(0.2F, "konsoleglitchvinyl"),
                new ChanceLootItem(.0625F,"sgpetitem")});
    }

}