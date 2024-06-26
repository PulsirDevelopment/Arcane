package net.pulsir.arcane.inventory.button;

import net.pulsir.arcane.Arcane;
import net.pulsir.arcane.inventory.button.action.ButtonAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class InventoryButton {

    private ItemStack itemStack;
    private int slot;
    private ButtonAction buttonAction;

    /**
     * @param itemStack - Item will be displayed as Button
     * @param slot - Slot where the item will be placed.
     * @param buttonAction - Action which the item must perform.
     */

    public InventoryButton(ItemStack itemStack, int slot, ButtonAction buttonAction) {
        this.itemStack = itemStack;
        this.slot = slot;
        this.buttonAction = buttonAction;

        ItemMeta meta = itemStack.getItemMeta();

        switch (buttonAction) {
            case NEXT -> meta.getPersistentDataContainer().set(Arcane.getInstance().getActionButton(), PersistentDataType.STRING, "next");
            case PREVIOUS -> meta.getPersistentDataContainer().set(Arcane.getInstance().getActionButton(), PersistentDataType.STRING, "previous");
            case CLOSE -> meta.getPersistentDataContainer().set(Arcane.getInstance().getActionButton(), PersistentDataType.STRING, "close");
        }

        itemStack.setItemMeta(meta);
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public ButtonAction getButtonAction() {
        return buttonAction;
    }

    public int getSlot() {
        return slot;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public void setButtonAction(ButtonAction buttonAction) {
        this.buttonAction = buttonAction;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
