package Principal.Eventos.GUI;

import Principal.utils.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class Inv {

    private Inventory inventory;

    public Inv() {
        inventory = Bukkit.createInventory(null, 9 * 3, "§8Sistema de Manutenção");
        setItens();
    }

    private void setItens() {
        ItemStack i1 = new Item(Material.ANVIL, 1, (short) 0)
                .setName("§aAtivar Manutenção")
                .setLore(Collections.singletonList("§7Ao clicar, você ativará a manutenção."))
                .setEnchant(Enchantment.DURABILITY, 1)
                .hideEnchant()
                .getItemStack();

        ItemStack i2 = new Item(Material.BOOK, 1, (short) 0)
                .setName("§8Status")
                .setLore(Collections.singletonList("§7Verifique o status da manutenção."))
                .getItemStack();

        ItemStack i3 = new Item(Material.BLAZE_POWDER, 1, (short) 0)
                .setName("§cDesativar Manutenção")
                .setLore(Collections.singletonList("§7Ao clicar, você desativará a manutenção."))
                .setEnchant(Enchantment.DURABILITY, 1)
                .hideEnchant()
                .getItemStack();

        inventory.setItem(11, i1);
        inventory.setItem(13, i2);
        inventory.setItem(15, i3);
    }

    public Inventory getInventory() {
        return inventory;
    }

}
