package net.pulsir.arcane.inventory;

import java.util.HashSet;
import java.util.Set;

public class AMap {

    private final static Set<AInventory> inventories = new HashSet<>();

    public static Set<AInventory> getInventories() {
        return inventories;
    }
}
