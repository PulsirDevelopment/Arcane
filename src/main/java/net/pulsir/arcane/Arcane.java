package net.pulsir.arcane;

import net.pulsir.arcane.inventory.listener.InventoryListener;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class Arcane {

    private static Arcane instance;
    private final NamespacedKey actionButton;

    public Arcane(JavaPlugin plugin) {
        instance = this;

        plugin.getServer().getPluginManager().registerEvents(new InventoryListener(), plugin);
        actionButton = new NamespacedKey(plugin, "action");
    }

    public static Arcane getInstance() {
        return instance;
    }

    public NamespacedKey getActionButton() {
        return actionButton;
    }
}
