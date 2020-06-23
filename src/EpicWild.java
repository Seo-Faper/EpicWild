import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EpicWild extends JavaPlugin implements Listener {
	static int health = 6;
	 @Override
	 public void onEnable() {
	  getLogger().info(
	    getDescription().getName() + " 이(가) 실행되었습니다  Version : "
	    + getDescription().getVersion());
	    getServer().getPluginManager().registerEvents(this, this);
	 }

	 
	@Override
	 public void onDisable() {
	  getLogger().info(getDescription().getName() + "플러그인이 종료되었습니다");
	 }
	
	
	 @EventHandler
	 public void PlayerjoinEvent(PlayerInteractEvent event) {
		 Player p  = event.getPlayer();
		 Action a = event.getAction();
		 if(a.equals(Action.RIGHT_CLICK_BLOCK) | a.equals(Action.RIGHT_CLICK_AIR)) {
			 ItemStack is = p.getItemInHand().clone();
			 if(is.getType().equals(Material.DIAMOND)) {
				p.setMaxHealth(p.getMaxHealth()+2);
				p.setHealth(p.getMaxHealth());
				Inventory inv = p.getInventory();
				inv.removeItem(new ItemStack(Material.DIAMOND));
				p.sendMessage(ChatColor.YELLOW+"하트의 그릇을 사용하여 최대 체력이 증가 하였습니다.");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
				shootfireworks();
			 }
		 }
		
	 }
	 
    @EventHandler
    public void onItemDrop (PlayerDropItemEvent e) {
	       e.setCancelled(true);
	    }
	 /*@EventHandler
	 public void onBlockBreak(BlockBreakEvent e) {
		 Player p = e.getPlayer();
		 Block b = e.getBlock();
		 Random r = new Random();
		 int xp = r.nextInt(20)+1;
		 if(b.getType().equals(Material.OAK_WOOD)) {
			 p.giveExp(xp);
		 }
	 }*/
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	 { 
	    if ((cmd.getName().equalsIgnoreCase("start")) && 
	      ((sender instanceof Player))) {
	    	 Player player = (Player)sender;
	    	 player.setMaxHealth(6);
	    	 Inventory inv = player.getInventory();
	    	  ItemStack item3 = new ItemStack(Material.STONE_SWORD);
		      ItemMeta meta3 = item3.getItemMeta();
		      meta3.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"초심자 검");
		      meta3.setUnbreakable(true);
		      item3.setItemMeta(meta3);
		      item3.addEnchantment(Enchantment.LOOT_BONUS_MOBS, 2);
		      
		      ItemStack hat = new ItemStack(Material.LEATHER_HELMET);
		      ItemMeta hatM = hat.getItemMeta();
		
	    	 inv.addItem(item3);
	    	 
	    	}
	    	return false;
     }
	 private void shootfireworks() {

		  for (Player player : Bukkit.getOnlinePlayers()) {
		   Firework firework = (Firework) player.getWorld().spawn(
		     player.getLocation(), Firework.class);
		   FireworkMeta fireworkm = firework.getFireworkMeta();
		 
		   FireworkEffect effect = FireworkEffect.builder().flicker(true)
		     .withColor(Color.AQUA).withFade(Color.BLACK)
		     .with(Type.BALL).trail(false).build();
		   FireworkEffect effect2 = FireworkEffect.builder().flicker(false)
		     .withColor(Color.RED).withFade(Color.LIME).with(Type.BURST)
		     .trail(true).build();

		   // flicker = 반짝이는여부, color = 폭죽색깔, fade = 2번째색깔, type = 모양, trail =

		   // 잔상

		   Random random = new Random();// 둘중하나 랜덤으로 쏨

		   int rf = random.nextInt(2) + 1;

		   if (rf == 1) {
		    fireworkm.addEffect(effect);
		   } else if (rf == 2) {
		    fireworkm.addEffect(effect2);
		   }
		   fireworkm.setPower(1);// 폭죽이 올라가는 높이 1~3
		   firework.setFireworkMeta(fireworkm);

		  }
	}
}
