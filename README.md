# Arcane

# Inventory

```java
        ItemStack green = new ItemStack(Material.GREEN_WOOL);
        ItemMeta greenMeta = green.getItemMeta();
        greenMeta.displayName(MiniMessage.miniMessage().deserialize("<green>Next Page"));
        green.setItemMeta(greenMeta);

        ItemStack red = new ItemStack(Material.RED_WOOL);
        ItemMeta redMeta = green.getItemMeta();
        redMeta.displayName(MiniMessage.miniMessage().deserialize("<red>Previous Page"));
        red.setItemMeta(redMeta);

        InventoryButton nextButton = new InventoryButton(red, 45, ButtonAction.PREVIOUS);
        InventoryButton previousButton = new InventoryButton(green, 53, ButtonAction.NEXT);
        Set<InventoryButton> buttons = new HashSet<>(List.of(nextButton, previousButton));

        ItemStack[] itemStacks1 = new ItemStack[54];
        ItemStack[] itemStacks2 = new ItemStack[54];

        itemStacks1[1] = new ItemStack(Material.DIAMOND_SWORD);
        itemStacks2[1] = new ItemStack(Material.DIAMOND_PICKAXE);

        for (int i = 0; i < 54; i++) {
            if (itemStacks1[i] == null) {
                itemStacks1[i] = new ItemStack(Material.AIR);
            }
            if (itemStacks2[i] == null) {
                itemStacks2[i] = new ItemStack(Material.AIR);
            }
        }

        InventoryPage firstPage = new InventoryPage(itemStacks1);
        InventoryPage secondPage = new InventoryPage(itemStacks2);

        Map<Integer, InventoryPage> pageMap = new HashMap<>();
        pageMap.put(1, firstPage);
        pageMap.put(2, secondPage);

        InventoryBuilder builder = new InventoryBuilder(new AInventory(player, MiniMessage.miniMessage().deserialize("<red>Inv"), 54, 1,
                buttons, pageMap, true, true));
        builder.addListener();
        player.openInventory(builder.build());
```

# Config

```java
        this.configuration = new Config(this, new File(getDataFolder(), "configuration.yml"),
                new YamlConfiguration(), "configuration.yml");

        this.configuration.create();
```
