package my.bazaars;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("WoodsPixel Bazaar Enabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("bazaar") || cmd.getName().equalsIgnoreCase("bz")) {
            openBazaar(player);
            return true;
        }

        return false;
    }

    public void openBazaar(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "§eBazaar");

        gui.setItem(11, createItem(Material.WHEAT, "§aFarming"));
        gui.setItem(13, createItem(Material.IRON_INGOT, "§bMining"));
        gui.setItem(15, createItem(Material.BLAZE_ROD, "§cCombat"));

        player.openInventory(gui);
    }

    private ItemStack createItem(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
}