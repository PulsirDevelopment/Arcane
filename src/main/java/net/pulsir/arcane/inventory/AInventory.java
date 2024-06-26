package net.pulsir.arcane.inventory;

import net.kyori.adventure.text.Component;
import net.pulsir.arcane.inventory.button.InventoryButton;
import net.pulsir.arcane.inventory.page.InventoryPage;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.Map;
import java.util.Set;

public class AInventory {

    private InventoryHolder holder;
    private Component title;
    private int size;
    private int currentPage;
    private Set<InventoryButton> buttons;
    private Map<Integer, InventoryPage> pages;
    private boolean isCancelled;
    private boolean isPaginated;

    /**
     * @param holder - Inventory holder
     * @param title - Title of inventory
     * @param size - Size of inventory
     * @param currentPage - Current page of holder inventory
     * @param buttons - Set of buttons and their actions (NEXT, PREVIOUS, CLOSE)
     * @param pages - Map of pages (Integer -> number, InventoryPage -> items)
     * @param isCancelled - Disallowing user from taking items from inventory
     * @param isPaginated - Adds next/previous buttons to inventory
     */

    public AInventory(InventoryHolder holder, Component title, int size, int currentPage, Set<InventoryButton> buttons, Map<Integer, InventoryPage> pages,
                      boolean isCancelled, boolean isPaginated) {
        this.holder = holder;
        this.title = title;
        this.size = size;
        this.currentPage = currentPage;
        this.buttons = buttons;
        this.pages = pages;
        this.isCancelled = isCancelled;
        this.isPaginated = isPaginated;
    }

    public int getSize() {
        return size;
    }

    public Component getTitle() {
        return title;
    }

    public InventoryHolder getHolder() {
        return holder;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public Set<InventoryButton> getButtons() {
        return buttons;
    }

    public Map<Integer, InventoryPage> getPages() {
        return pages;
    }

    public boolean isPaginated() {
        return isPaginated;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setButtons(Set<InventoryButton> buttons) {
        this.buttons = buttons;
    }

    public void setTitle(Component title) {
        this.title = title;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPages(Map<Integer, InventoryPage> pages) {
        this.pages = pages;
    }

    public void setHolder(InventoryHolder holder) {
        this.holder = holder;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public void setPaginated(boolean paginated) {
        isPaginated = paginated;
    }

    public void updateHolderInventor(UpdateType type, Inventory inventory) {
        switch (type) {
            case NEXT -> {
                int nextPage = currentPage + 1;

                if (pages.get(nextPage) != null) {
                    InventoryPage page = pages.get(nextPage);
                    inventory.setContents(page.getItems());
                    setCurrentPage(nextPage);
                }

                if (isPaginated) {
                    for (InventoryButton button : buttons) {
                        inventory.setItem(button.getSlot(), button.getItemStack());
                    }
                }
            }
            case PREVIOUS -> {
                int nextPage = currentPage - 1;

                if (pages.get(nextPage) != null) {
                    InventoryPage page = pages.get(nextPage);
                    inventory.setContents(page.getItems());
                    setCurrentPage(nextPage);
                }

                if (isPaginated) {
                    for (InventoryButton button : buttons) {
                        inventory.setItem(button.getSlot(), button.getItemStack());
                    }
                }
            }
        }
    }
}
