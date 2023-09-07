package NecessePets.mod;

import necesse.engine.localization.Localization;
import necesse.engine.network.Packet;
import necesse.engine.network.PacketReader;
import necesse.engine.network.server.FollowPosition;
import necesse.engine.network.server.ServerClient;
import necesse.entity.mobs.Attacker;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.container.Container;
import necesse.inventory.container.ContainerActionResult;
import necesse.inventory.container.slots.ContainerSlot;
import necesse.inventory.item.Item;
import necesse.inventory.item.placeableItem.followerSummonItem.FollowerSummonPlaceableItem;

import java.util.function.Supplier;

public class AVPetItem extends FollowerSummonPlaceableItem {
    public AVPetItem(String mobType, Item.Rarity rarity) {
        super(1, false, mobType, FollowPosition.WALK_CLOSE, "summonedpet", "summonedpet", 1);
        this.rarity = rarity;
        this.setItemCategory(new String[]{"misc", "pets"});
        this.keyWords.add("pet");
    }

    public Supplier<ContainerActionResult> getInventoryRightClickAction(Container container, InventoryItem item, int slotIndex, ContainerSlot slot) {
        return () -> {
            if (container.getClient().isServerClient()) {
                ServerClient client = container.getClient().getServerClient();
                Packet summonContent = this.getSummonContent();
                if (summonContent == null) {
                    summonContent = new Packet();
                }

                if (this.canSummon(client.getLevel(), client.playerMob, item, new PacketReader(summonContent)) == null) {
                    this.summonMob(client.getLevel(), client.playerMob, item, new PacketReader(summonContent));
                }
            }

            return new ContainerActionResult(42965565);
        };
    }

    protected ListGameTooltips getAnimalTooltips(InventoryItem item, Attacker attacker) {
        ListGameTooltips tooltips = super.getAnimalTooltips(item, attacker);
        tooltips.add(Localization.translate("itemtooltip", "summonquicktip"));
        return tooltips;
    }
}
