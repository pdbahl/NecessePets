package NecessePets;

import NecessePets.mod.*;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.*;
import necesse.inventory.item.Item;
import necesse.gfx.gameTexture.GameTexture;

@ModEntry
public class PetsMod {

    public void init() {
        System.out.println("Hello world from my example mod!");
        ItemRegistry.registerItem("eppetitem", new EPPetItem("babyep", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("babyep", EPMob.class, false);
        ItemRegistry.registerItem("sqpetitem", new SQPetItem("sqbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("sqbaby", SQMob.class, false);
        ItemRegistry.registerItem("vwpetitem", new SQPetItem("vwbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("vwbaby", VWMob.class, false);
        ItemRegistry.registerItem("sgpetitem", new SGPetItem("sgbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("sgbaby", SGMob.class, false);
        ItemRegistry.registerItem("avpetitem", new AVPetItem("avbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("avbaby", AVMob.class, false);
        ItemRegistry.registerItem("pcpetitem", new PCPetItem("pcbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("pcbaby", PCMob.class, false);
        ItemRegistry.registerItem("rpetitem", new RPetItem("rbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("rbaby", RMob.class, false);
        ItemRegistry.registerItem("cqpetitem", new CQPetItem("cqbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("cqbaby", PWMob.class, false);
        ItemRegistry.registerItem("pwpetitem", new CQPetItem("pwbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("pwbaby", PWMob.class, false);
        ItemRegistry.registerItem("gspetitem", new GSPetItem("gsbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("gsbaby", GSMob.class, false);
        ItemRegistry.registerItem("fwpetitem", new FWPetItem("fwbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("fwbaby", FWMob.class, false);
        ItemRegistry.registerItem("smpetitem", new SMPetItem("smbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("smbaby", SMMob.class, false);
        ItemRegistry.registerItem("nspetitem", new NSPetItem("nsbaby", Item.Rarity.LEGENDARY), 110, true);
        MobRegistry.registerMob("nsbaby", NSMob.class, false);

        ItemRegistry.registerItem("examplesword", new ohitko(), 20, true);

    }

    public void initResources() {
        EPMob.texture = MobRegistry.Textures.evilsProtector.resize(256,256);
        SQMob.texture = GameTexture.fromFile("mobs/sqbaby.png").resize(32,32);
        VWMob.texture = GameTexture.fromFile("mobs/vwbaby.png").resize(32,32);
        SGMob.texture = GameTexture.fromFile("mobs/sgbaby.png").resize(16,64);
        AVMob.texture = GameTexture.fromFile("mobs/avbaby.png").resize(32,32);
        PCMob.texture = GameTexture.fromFile("mobs/pcbaby.png").resize(32,48);
         RMob.texture = GameTexture.fromFile("mobs/rbaby.png").resize(32,48);
        CQMob.texture = GameTexture.fromFile("mobs/cqbaby.png").resize(32,32);
        PWMob.texture = GameTexture.fromFile("mobs/pwbaby.png").resize(48,48);
        GSMob.texture = GameTexture.fromFile("mobs/gsbaby.png").resize(32,64);
        FWMob.texture = GameTexture.fromFile("mobs/fwbaby.png").resize(32,42);
        SMMob.texture = GameTexture.fromFile("mobs/smbaby.png").resize(32,32);
        NSMob.texture = GameTexture.fromFile("mobs/nsbaby.png").resize(42,32);

    }

    public void postInit() {




    }

}
