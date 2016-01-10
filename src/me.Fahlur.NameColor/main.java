package me.Fahlur.NameColor;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class main
  extends JavaPlugin
{
  public static Permission permission = null;
  public static Chat chat;
  
  private Boolean setupPermissions()
  {
    RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(Permission.class);
    if (permissionProvider != null) {
      permission = (Permission)permissionProvider.getProvider();
    }
    if (permission != null) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  private boolean setupChat()
  {
    RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(Chat.class);
    if (chatProvider != null) {
      chat = (Chat)chatProvider.getProvider();
    }
    return chat != null;
  }
  
  public void onEnable()
  {
    setupPermissions();
    setupChat();
  }
  
  private ChatColor[] restricted = { ChatColor.RED, ChatColor.AQUA, ChatColor.RESET, ChatColor.ITALIC, ChatColor.STRIKETHROUGH, ChatColor.UNDERLINE, ChatColor.BOLD, ChatColor.MAGIC, ChatColor.BLACK };
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      Bukkit.getLogger().warning("[NameColor]: This command cannot be used from console.");
      return true;
    }
    Player player = (Player)sender;
    if (permission.playerHas(player, "NameColor"))
    {
      player.sendMessage(ChatColor.RED + "Sorry, you don't have permission to use this command.");
      
      return true;
    }
    if (args.length != 1)
    {
      player.sendMessage(ChatColor.RED + "Useage: " + ChatColor.GRAY + "/namecolor [color]");
      return true;
    }
    ChatColor color = null;
    try
    {
      color = ChatColor.valueOf(args[0].toUpperCase());
    }
    catch (IllegalArgumentException e)
    {
      player.sendMessage(ChatColor.RED + "That color does not exist.");
      sendApplicableColors(player);
      return true;
    }
    if (color == null)
    {
      player.sendMessage(ChatColor.RED + "That color does not exist.");
      sendApplicableColors(player);
      return true;
    }
    ChatColor[] arrayOfChatColor;
    int j = (arrayOfChatColor = this.restricted).length;
    for (int i = 0; i < j; i++)
    {
      ChatColor r = arrayOfChatColor[i];
      if (color.equals(r))
      {
        player.sendMessage(ChatColor.RED + "Sorry, this color is restricted.");
        sendApplicableColors(player);
        return true;
      }
    }
    
    String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
    int count = 0;
    for(World w : Bukkit.getServer().getWorlds()){
	    worldNames[count] = w.getName();
	    count++;
    }
    for(String s : worldNames){
    	System.out.println("World Names = " + s);
    	chat.setPlayerPrefix(s, player, "&" + color.getChar());
    }
    player.sendMessage(ChatColor.RED + "Name color has been changed to: " + color + color.name());
    return true;
  }
  
  private void sendApplicableColors(Player player)
  {
    String[] message = new String[2];
    
    message[0] = "Applicable Name Colors: ";
    message[1] = "";
    for (int i = 0; i < ChatColor.values().length; i++)
    {
      boolean restrictedValue = false;
      for (int j = 0; j < this.restricted.length; j++) {
        if (ChatColor.values()[i].equals(this.restricted[j])) {
          restrictedValue = true;
        }
      }
      if (!restrictedValue)
      {
        if (message[1].length() != 0)
        {
          int tmp79_78 = 1;
          String[] tmp79_77 = message;
          tmp79_77[tmp79_78] = (tmp79_77[tmp79_78] + ChatColor.RESET + ",");
        }
        int tmp103_102 = 1;
        String[] tmp103_101 = message;
        tmp103_101[tmp103_102] = (tmp103_101[tmp103_102] + ChatColor.values()[i] + ChatColor.values()[i].name());
      }
    }
    player.sendMessage(message);
  }
}
