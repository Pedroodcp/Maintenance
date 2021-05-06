package br.com.pedrodcp.maintenance.Eventos;

import static br.com.pedrodcp.maintenance.Comandos.manutencao.*;

import br.com.pedrodcp.maintenance.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void Join(PlayerJoinEvent e) {
        if (manutencao.manutencao.contains("on")) {
            Player p = e.getPlayer();
            if (!p.isWhitelisted()) {
                p.kickPlayer(Main.getInstance().getConfig().getString("Config.mensagem-kick").replace("&", "§").replace("%nl%", "\n"));
            }
        }
    }

}
