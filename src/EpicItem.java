import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EpicItem {
	public ItemStack getItem1() {
		ItemStack item = new ItemStack(Material.STONE_AXE);
	      ItemMeta meta = item.getItemMeta();
	      meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"�ʽ��� ����");
	      item.setItemMeta(meta);
	      item.addEnchantment(Enchantment.DIG_SPEED, 1);
		return item;
	}
	public ItemStack getItem2() {
	      ItemStack item = new ItemStack(Material.STONE_PICKAXE);
	      ItemMeta meta = item.getItemMeta();
	      meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"�ʽ��� ���");
	      item.setItemMeta(meta);
	      item.addEnchantment(Enchantment.DIG_SPEED, 1);
		return item;
	}
	public ItemStack getItem3() {

	      ItemStack dell = new ItemStack(Material.STONE_PICKAXE);
	      dell.addEnchantment(Enchantment.DIG_SPEED, 4);
	  
	      ItemStack item = new ItemStack(Material.FURNACE);
	      ItemMeta meta = dell.getItemMeta();
	      meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"ȭ�� ���� ȭ�� ");
	      List<String> list = new ArrayList<String>();
	      list.add(ChatColor.GREEN+""+ChatColor.BOLD+"���� �ӵ��� ���� ������ ȭ��");
	      meta.setLore(list );
	      item.setItemMeta(meta);
		return item;
	}
}
