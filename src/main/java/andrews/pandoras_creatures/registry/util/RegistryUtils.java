package andrews.pandoras_creatures.registry.util;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;

public class RegistryUtils
{
//	public static BlockItem createWallOrFloorItem(Block floorBlock, Block wallBlock, ItemGroup itemGroup) {
//		return (BlockItem) new WallOrFloorItem(floorBlock, wallBlock, new Item.Properties().group(itemGroup)).setRegistryName(floorBlock.getRegistryName());
//	}
//	
//	public static BlockItem createUpsideDownBlockItem(Block block, ItemGroup itemGroup) {
//		return (BlockItem) new ItemBlockUpsideDown(block, new Item.Properties().group(itemGroup)).setRegistryName(block.getRegistryName());
//	}
//	
//	public static Item createSimpleItem(String name, ItemGroup itemGroup) {
//		return new Item(new Item.Properties().group(itemGroup)).setRegistryName(Reference.MODID, name);
//	}
	
	public static Item createSpawnEggForEntity(@SuppressWarnings("rawtypes") EntityType entityType, int eggColor1, int eggColor2, ItemGroup itemGroup)
	{
		return new SpawnEggItem(entityType, eggColor1, eggColor2, new Item.Properties().group(itemGroup)).setRegistryName(entityType.getRegistryName() + "_spawn_egg");
	}

//	public static BlockItem createSimpleItemBlock(Block block, ItemGroup itemGroup) {
//		return (BlockItem) new BlockItem(block, new Item.Properties().group(itemGroup)).setRegistryName(block.getRegistryName());
//	}
//
//	public static Item createItemBlockWithRarity(Block blockForInput, ItemGroup itemGroup, Rarity rarity) {
//		return (BlockItem) new BlockItem(blockForInput, new Item.Properties().group(itemGroup).rarity(rarity)).setRegistryName(blockForInput.getRegistryName());
//	}
}