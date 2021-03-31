package Principal.Eventos.GUI;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener {

    @EventHandler
    public void aoClicar(InventoryClickEvent e) {
        if (!e.getInventory().getName().equalsIgnoreCase("§8Sistema de Manutenção")) return;
        e.setCancelled(true);

        ItemStack i = e.getCurrentItem();
        Player p = (Player) e.getWhoClicked();

        if (i.getType() == Material.WOOL) {
            switch (i.getDurability()) {
                case 5:
                    p.performCommand("manutencao on");
                    p.closeInventory();
                    return;
                case 14:
                    p.performCommand("manutencao off");
                    p.closeInventory();
                    return;
            }
        }
        if (i.getType() == Material.BOOK) {
            p.performCommand("manutencao info");
            p.closeInventory();
        }
    }

}
