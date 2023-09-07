package NecessePets.mod;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.hostile.bosses.EvilsProtectorMob;
import necesse.entity.mobs.hostile.bosses.QueenSpiderMob;
import necesse.inventory.item.matItem.MultiTextureMatItem;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.ChanceLootItem;
import necesse.inventory.lootTable.lootItem.LootItem;
import net.bytebuddy.asm.Advice;


@ModMethodPatch(target = QueenSpiderMob.class, name = "getLootTable", arguments = {})
public class SQMethodPatcher {

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@Advice.This QueenSpiderMob sq) {

        System.out.println("Entered EvilsProtectorMob.getLootTable(): " + sq.getStringID());

        return true;
    }

    @Advice.OnMethodExit
    static void onExit(@Advice.This QueenSpiderMob ep, @Advice.Return(readOnly = false) LootTable lootTable) {

        lootTable = new LootTable(new LootItemInterface[]{LootItem.between("cavespidergland", 10, 20, MultiTextureMatItem.getGNDData(1)),
                new ChanceLootItem(0.2F, "queenspidersdancevinyl"),
                new ChanceLootItem(.0625F,"sqpetitem")});

        System.out.println("Exited EvilsProtectorMob.getLootTable() " + ep.getStringID() + " with new return value: " + lootTable);
    }

}