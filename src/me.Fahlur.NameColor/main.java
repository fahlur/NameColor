package me.Fahlur.NameColor;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class main
  extends JavaPlugin implements Listener
{
	  PluginManager pm = Bukkit.getServer().getPluginManager();
	  public Permission canUseAll;
	  public Permission canUseAllColors;
	  public Permission canUseColorRed;
	  public Permission canUseColorDarkRed;
	  public Permission canUseColorGold;
	  public Permission canUseColorYellow;
	  public Permission canUseColorGreen;
	  public Permission canUseColorDarkGreen;
	  public Permission canUseColorAqua;
	  public Permission canUseColorDarkAqua;
	  public Permission canUseColorBlue;
	  public Permission canUseColorDarkBlue;
	  public Permission canUseColorLightPurple;
	  public Permission canUseColorDarkPurple;
	  public Permission canUseColorWhite;
	  public Permission canUseColorGray;
	  public Permission canUseColorDarkGray;
	  public Permission canUseColorBlack;
	  public Permission canUseColorMagic;
	  public Permission userCommand;
	  public Permission adminCommand;
	  public ItemStack Red;
	  public ItemStack DarkRed;
	  public ItemStack Gold;
	  public ItemStack Yellow;
	  public ItemStack Green;
	  public ItemStack DarkGreen;
	  public ItemStack Aqua;
	  public ItemStack DarkAqua;
	  public ItemStack Blue;
	  public ItemStack DarkBlue;
	  public ItemStack LightPurple;
	  public ItemStack DarkPurple;
	  public ItemStack White;
	  public ItemStack Gray;
	  public ItemStack DarkGray;
	  public ItemStack Black;
	  public ItemStack Magic;
	  public static double version;

	  public void onEnable()
	  {
	    defaultConfig();
	    this.canUseAll = new Permission(getConfig().getString("Permission.All"));
	    
	    this.canUseAllColors = new Permission(getConfig().getString("Permission.AllColors"));
	    
	    this.canUseColorRed = new Permission(getConfig().getString("Permission.Red"));
	    this.canUseColorDarkRed = new Permission(getConfig().getString("Permission.DarkRed"));
	    this.canUseColorGold = new Permission(getConfig().getString("Permission.Gold"));
	    this.canUseColorYellow = new Permission(getConfig().getString("Permission.Yellow"));
	    this.canUseColorGreen = new Permission(getConfig().getString("Permission.Green"));
	    this.canUseColorDarkGreen = new Permission(getConfig().getString("Permission.DarkGreen"));
	    this.canUseColorAqua = new Permission(getConfig().getString("Permission.Aqua"));
	    this.canUseColorDarkAqua = new Permission(getConfig().getString("Permission.DarkAqua"));
	    this.canUseColorBlue = new Permission(getConfig().getString("Permission.Blue"));
	    this.canUseColorDarkBlue = new Permission(getConfig().getString("Permission.DarkBlue"));
	    this.canUseColorLightPurple = new Permission(getConfig().getString("Permission.LightPurple"));
	    this.canUseColorDarkPurple = new Permission(getConfig().getString("Permission.DarkPurple"));
	    this.canUseColorWhite = new Permission(getConfig().getString("Permission.White"));
	    this.canUseColorGray = new Permission(getConfig().getString("Permission.Gray"));
	    this.canUseColorDarkGray = new Permission(getConfig().getString("Permission.DarkGray"));

	    
	    this.userCommand = new Permission(getConfig().getString("Permission.Command.User"));
	    this.adminCommand = new Permission(getConfig().getString("Permission.Command.Admin"));
	    
	    loadItems();
	    
	    this.pm.registerEvents(this, this);
	    
	  }
	  
	  public void onDisable() {}
	  
	  public void loadItems()
	  {
	    this.Red = new ItemStack(Material.WOOL, 1, (short)14);
	    this.DarkRed = new ItemStack(Material.NETHER_BRICK, 1);
	    this.Gold = new ItemStack(Material.WOOL, 1, (short)1);
	    this.Yellow = new ItemStack(Material.WOOL, 1, (short)4);
	    this.Green = new ItemStack(Material.WOOL, 1, (short)5);
	    this.DarkGreen = new ItemStack(Material.WOOL, 1, (short)13);
	    this.Aqua = new ItemStack(Material.DIAMOND_BLOCK, 1);
	    this.DarkAqua = new ItemStack(Material.WOOL, 1, (short)9);
	    this.Blue = new ItemStack(Material.WOOL, 1, (short)3);
	    this.DarkBlue = new ItemStack(Material.WOOL, 1, (short)11);
	    this.LightPurple = new ItemStack(Material.WOOL, 1, (short)2);
	    this.DarkPurple = new ItemStack(Material.WOOL, 1, (short)10);
	    this.White = new ItemStack(Material.WOOL, 1, (short)0);
	    this.Gray = new ItemStack(Material.WOOL, 1, (short)8);
	    this.DarkGray = new ItemStack(Material.WOOL, 1, (short)7);
	    
	    nameItem(this.Red, ChatColor.RED + "Red");
	    nameItem(this.DarkRed, ChatColor.DARK_RED + "Dark Red");
	    nameItem(this.Gold, ChatColor.GOLD + "Orange");
	    nameItem(this.Yellow, ChatColor.YELLOW + "Yellow");
	    nameItem(this.Green, ChatColor.GREEN + "Green");
	    nameItem(this.DarkGreen, ChatColor.DARK_GREEN + "Dark Green");
	    nameItem(this.Aqua, ChatColor.AQUA + "Aqua");
	    nameItem(this.DarkAqua, ChatColor.DARK_AQUA + "Dark Aqua");
	    nameItem(this.Blue, ChatColor.BLUE + "Blue");
	    nameItem(this.DarkBlue, ChatColor.DARK_BLUE + "Dark Blue");
	    nameItem(this.LightPurple, ChatColor.LIGHT_PURPLE + "Pink");
	    nameItem(this.DarkPurple, ChatColor.DARK_PURPLE + "Purple");
	    nameItem(this.White, ChatColor.WHITE + "White");
	    nameItem(this.Gray, ChatColor.GRAY + "Gray");
	    nameItem(this.DarkGray, ChatColor.DARK_GRAY + "Dark Gray");
	  }
	  
	  public ItemStack nameItem(ItemStack i, String s)
	  {
	    ItemMeta im = i.getItemMeta();
	    im.setDisplayName(s);
	    i.setItemMeta(im);
	    return i;
	  }
	  
	  public ItemStack setPerm(ItemStack i, Boolean b, Player pl)
	  {
	    ItemMeta im = i.getItemMeta();
	    if (b.booleanValue()) {
	      im.setLore(Arrays.asList(new String[] { ChatColor.GRAY + "Permission: " + ChatColor.GREEN + "✔" }));
	    } else {
	      im.setLore(Arrays.asList(new String[] { ChatColor.GRAY + "Permission: " + ChatColor.RED + "✘" }));
	    }  
	    i.setItemMeta(im);
	    return i;
	  }
	  
	  public void openInvnetory(Player p)
	  {
	    Inventory inv = Bukkit.createInventory(null, 18, ChatColor.DARK_AQUA + "P"+ChatColor.BLUE + "I"+ChatColor.DARK_BLUE + "C"+ChatColor.DARK_PURPLE + "K"+ChatColor.BLACK + " -a- "+ChatColor.DARK_GREEN + "C"+ChatColor.RED + "O"+ChatColor.DARK_RED + "L"+ChatColor.LIGHT_PURPLE + "O" +ChatColor.GOLD + "R");
	    
	    if ((p.hasPermission(this.canUseColorWhite)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
		      inv.setItem(0, setPerm(this.White, Boolean.valueOf(true), p));
		    } else {
		      inv.setItem(0, setPerm(this.White, Boolean.valueOf(false), p));
		}
	    if ((p.hasPermission(this.canUseColorRed)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	    	  inv.setItem(2, setPerm(this.Red, Boolean.valueOf(true), p));
		    } else {
		      inv.setItem(2, setPerm(this.Red, Boolean.valueOf(false), p));
		    }
	    if ((p.hasPermission(this.canUseColorDarkRed)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(3, setPerm(this.DarkRed, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(3, setPerm(this.DarkRed, Boolean.valueOf(false), p));
	    }
	    if ((p.hasPermission(this.canUseColorGold)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(4, setPerm(this.Gold, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(4, setPerm(this.Gold, Boolean.valueOf(false), p));
	    }
	    if ((p.hasPermission(this.canUseColorYellow)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(5, setPerm(this.Yellow, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(5, setPerm(this.Yellow, Boolean.valueOf(false), p));
	    }
	    if ((p.hasPermission(this.canUseColorGreen)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(6, setPerm(this.Green, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(6, setPerm(this.Green, Boolean.valueOf(false), p));
	    }
	    if ((p.hasPermission(this.canUseColorDarkGreen)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(7, setPerm(this.DarkGreen, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(7, setPerm(this.DarkGreen, Boolean.valueOf(false), p));
	    }
	    if ((p.hasPermission(this.canUseColorAqua)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
		      inv.setItem(8, setPerm(this.Aqua, Boolean.valueOf(true), p));
		    } else {
		      inv.setItem(8, setPerm(this.Aqua, Boolean.valueOf(false), p));
		    }
	    if ((p.hasPermission(this.canUseColorDarkAqua)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(11, setPerm(this.DarkAqua, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(11, setPerm(this.DarkAqua, Boolean.valueOf(false), p));
	    }
	    if ((p.hasPermission(this.canUseColorBlue)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(12, setPerm(this.Blue, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(12, setPerm(this.Blue, Boolean.valueOf(false), p));
	    }
	    if ((p.hasPermission(this.canUseColorDarkBlue)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(13, setPerm(this.DarkBlue, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(13, setPerm(this.DarkBlue, Boolean.valueOf(false), p));
	    }
	    if ((p.hasPermission(this.canUseColorLightPurple)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(14, setPerm(this.LightPurple, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(14, setPerm(this.LightPurple, Boolean.valueOf(false), p));
	    }
	    if ((p.hasPermission(this.canUseColorDarkPurple)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(15, setPerm(this.DarkPurple, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(15, setPerm(this.DarkPurple, Boolean.valueOf(false), p));
	    }
	    
	    if ((p.hasPermission(this.canUseColorGray)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(16, setPerm(this.Gray, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(16, setPerm(this.Gray, Boolean.valueOf(false), p));
	    }
	    if ((p.hasPermission(this.canUseColorDarkGray)) || (p.hasPermission(this.canUseAll)) || (p.hasPermission(this.canUseAllColors))) {
	      inv.setItem(17, setPerm(this.DarkGray, Boolean.valueOf(true), p));
	    } else {
	      inv.setItem(17, setPerm(this.DarkGray, Boolean.valueOf(false), p));
	    }

	    p.openInventory(inv);
	  }
	  
	  @EventHandler(ignoreCancelled=true, priority=EventPriority.LOWEST)
	  public void onPlayerJoin(PlayerJoinEvent event)
	  {
	    Player p = event.getPlayer();
	    if (getConfig().contains("Players." + p.getUniqueId().toString())) {
	      p.setDisplayName("§" + getConfig().getString(new StringBuilder("Players.").append(p.getUniqueId().toString()).toString()) + p.getName() + ChatColor.RESET);
	    }else{
	      p.setDisplayName(ChatColor.RESET + p.getName() + ChatColor.RESET);
	    }
	  }
	  
	  public void setColor(Player p, char color)
	  {
	    getConfig().set("Players." + p.getUniqueId().toString(), Character.valueOf(color));
	    saveConfig();
	    p.setDisplayName("§" + color + p.getName() + ChatColor.RESET);
	    p.sendMessage("§" + color + "Your name color has been set!");
	  }
	  
	  @SuppressWarnings("incomplete-switch")
	@EventHandler
	  public void onInvClick(InventoryClickEvent event)
	  {
	    if (ChatColor.stripColor(event.getInventory().getName()).equals("PICK -a- COLOR"))
	    {
	      if ((event.getCurrentItem() == null) || (event.getCurrentItem().getType() == Material.AIR) || (!event.getCurrentItem().hasItemMeta()))
	      {
	        event.getWhoClicked().closeInventory();
	        return;
	      }
	      event.setCancelled(true);
	      
	      Player player = (Player)event.getWhoClicked();
	      ItemStack i = event.getCurrentItem();
	      if (i.getItemMeta().getLore().toString().contains("✔")) {
	        switch (i.getType())
	        {
	        case WOOL: 
	          switch (i.getData().getData())
	          {
	          case 14: 
	            setColor(player, 'c');
	            break;
	          case 1: 
	            setColor(player, '6');
	            break;
	          case 4: 
	            setColor(player, 'e');
	            break;
	          case 5: 
	            setColor(player, 'a');
	            break;
	          case 13: 
	            setColor(player, '2');
	            break;
	          case 9: 
	            setColor(player, '3');
	            break;
	          case 3: 
	            setColor(player, '9');
	            break;
	          case 11: 
	            setColor(player, '1');
	            break;
	          case 2: 
	            setColor(player, 'd');
	            break;
	          case 10: 
	            setColor(player, '5');
	            break;
	          case 0: 
	            setColor(player, 'f');
	            break;
	          case 8: 
	            setColor(player, '7');
	            break;
	          case 7: 
	            setColor(player, '8');
	            break;
	          }
	          break;
	        case NETHER_BRICK: 
	          setColor(player, '4');
	          break;
	        case DIAMOND_BLOCK: 
	          setColor(player, 'b');
	          break;
	        }
	      } else {
	        player.sendMessage(ChatColor.RED + "You don't have permission to use that color!");
	      }
	    }
	  }
	  
	  public void defaultConfig()
	  {
	    getConfig().addDefault("Permission.All", "NameColor.*");
	    
	    getConfig().addDefault("Permission.AllColors", "NameColor.Color.*");
	    
	    getConfig().addDefault("Permission.Red", "NameColor.Color.Red");
	    getConfig().addDefault("Permission.DarkRed", "NameColor.Color.DarkRed");
	    getConfig().addDefault("Permission.Gold", "NameColor.Color.Gold");
	    getConfig().addDefault("Permission.Yellow", "NameColor.Color.Yellow");
	    getConfig().addDefault("Permission.Green", "NameColor.Color.Green");
	    getConfig().addDefault("Permission.DarkGreen", "NameColor.Color.DarkGreen");
	    getConfig().addDefault("Permission.Aqua", "NameColor.Color.Aqua");
	    getConfig().addDefault("Permission.DarkAqua", "NameColor.Color.DarkAqua");
	    getConfig().addDefault("Permission.Blue", "NameColor.Color.Blue");
	    getConfig().addDefault("Permission.DarkBlue", "NameColor.Color.DarkBlue");
	    getConfig().addDefault("Permission.LightPurple", "NameColor.Color.LightPurple");
	    getConfig().addDefault("Permission.DarkPurple", "NameColor.Color.DarkPurple");
	    getConfig().addDefault("Permission.White", "NameColor.Color.White");
	    getConfig().addDefault("Permission.Gray", "NameColor.Color.Gray");
	    getConfig().addDefault("Permission.DarkGray", "NameColor.Color.DarkGray");
	    
	    getConfig().addDefault("Permission.Command.User", "NameColor.Command");
	    getConfig().addDefault("Permission.Command.Admin", "NameColor.Command.Admin");
	    
	    getConfig().options().copyDefaults(true);
	    saveConfig();
	  }
	  
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	  {
	    if ((label.equalsIgnoreCase("namecolor")) || (label.equalsIgnoreCase("nc"))) {
	      if ((sender.hasPermission(this.adminCommand)) || (sender.hasPermission(this.userCommand)) || (sender.hasPermission(this.canUseAll)))
	      {
	        if (args.length != 0)
	        {
	          if ((sender.hasPermission(this.adminCommand)) || (sender.hasPermission(this.canUseAll)))
	          {
	            if ((sender instanceof Player)) {
	              openInvnetory((Player)sender);
	            } else {
	              sender.sendMessage(ChatColor.RED + "Error: Only players may use this command!");
	            }
	          }
	          else if ((sender instanceof Player)) {
	            openInvnetory((Player)sender);
	          } else {
	            sender.sendMessage(ChatColor.RED + "Error: Only players may use this command!");
	          }
	        }
	        else if ((sender instanceof Player)) {
	          openInvnetory((Player)sender);
	        } else {
	          sender.sendMessage(ChatColor.RED + "Error: Only players may use this command!");
	        }
	      }
	      else {
	        sender.sendMessage(ChatColor.RED + "Error: No permission!");
	      }
	    }
	    return true;
	  }
	  
	  
	  
}
