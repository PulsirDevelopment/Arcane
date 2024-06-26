package net.pulsir.arcane.inventory.page;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class InventoryPage {

    private ItemStack[] items;

    public InventoryPage(ItemStack[] items) {
        this.items = items;

        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = new ItemStack(Material.AIR);
            }
        }
    }

    public ItemStack[] getItems() {
        return items;
    }

    public void setItems(ItemStack[] items) {
        this.items = items;
    }
}
