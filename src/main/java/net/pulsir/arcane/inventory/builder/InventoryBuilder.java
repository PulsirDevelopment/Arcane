package net.pulsir.arcane.inventory.builder;

import net.pulsir.arcane.inventory.AInventory;
import net.pulsir.arcane.inventory.AMap;
import net.pulsir.arcane.inventory.button.InventoryButton;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InventoryBuilder {

    private final AInventory inventory;

    public InventoryBuilder(AInventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Invoke method only if you are using paginated option or isCancelled.
     */
    public void register() {
        AMap.getInventories().add(inventory);
    }

    /**
     * Build inventory based on AInventory provided, which then you can give to player
     */
    public Inventory build(){
        Inventory bukkitInventory = Bukkit.createInventory(inventory.getHolder(), inventory.getSize(), inventory.getTitle());
        bukkitInventory.setContents(inventory.getPages().get(inventory.getCurrentPage()).getItems());

        if (inventory.isPaginated()) {
            for (InventoryButton button : inventory.getButtons()) {
                bukkitInventory.setItem(button.getSlot(), button.getItemStack());
            }
        }

        return bukkitInventory;
    }
}
