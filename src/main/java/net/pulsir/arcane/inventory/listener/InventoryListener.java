package net.pulsir.arcane.inventory.listener;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.pulsir.arcane.Arcane;
import net.pulsir.arcane.inventory.AInventory;
import net.pulsir.arcane.inventory.AMap;
import net.pulsir.arcane.inventory.UpdateType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        for (final AInventory inventory : AMap.getInventories()) {
            if (MiniMessage.miniMessage().serialize(event.getView().title())
                    .equalsIgnoreCase(MiniMessage.miniMessage().serialize(inventory.getTitle()))) {
                event.setCancelled(inventory.isCancelled());
            }

            if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getCurrentItem().getItemMeta().displayName() != null
                    && event.getCurrentItem().getItemMeta().getPersistentDataContainer().has(Arcane.getInstance().getActionButton())) {
                ItemStack item = event.getCurrentItem();
                String key = item.getItemMeta().getPersistentDataContainer().get(Arcane.getInstance().getActionButton(), PersistentDataType.STRING);
                if (key == null) return;

                switch (key) {
                    case "next" -> inventory.updateHolderInventor(UpdateType.NEXT, event.getInventory());
                    case "previous" -> inventory.updateHolderInventor(UpdateType.PREVIOUS, event.getInventory());
                    case "exit" -> event.getInventory().close();
                }
            }
        }
    }
}
