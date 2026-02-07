public static Item cornSeed;
public static Item corn;

public static void init() {
    cornSeed = new Item().setUnlocalizedName("corn_seed").setRegistryName("corn_seed");
    corn = new ItemFood(3, 0.3F, false).setUnlocalizedName("corn").setRegistryName("corn");
    GameRegistry.register(cornSeed);
    GameRegistry.register(corn);
}
