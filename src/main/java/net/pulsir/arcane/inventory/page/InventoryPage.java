package net.pulsir.arcane.inventory.page;

import org.bukkit.inventory.ItemStack;

public class InventoryPage {

    private ItemStack[] items;

    public InventoryPage(ItemStack[] items) {
        this.items = items;
    }

    public ItemStack[] getItems() {
        return items;
    }

    public void setItems(ItemStack[] items) {
        this.items = items;
    }
}
