package Principal.Eventos;

import static Principal.Main.*;
import static Principal.Comandos.manutencao.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void Join(PlayerJoinEvent e) {
        if (manutencao.contains("on")) {
            Player p = e.getPlayer();
            if (!p.isWhitelisted()) {
                p.kickPlayer(getInstance().getConfig().getString("Config.mensagem-kick").replace("&", "§").replace("%nl%", "\n"));
            }
        }
    }

}
