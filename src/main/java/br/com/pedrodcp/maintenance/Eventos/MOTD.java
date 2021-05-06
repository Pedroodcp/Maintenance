package br.com.pedrodcp.maintenance.Eventos;

import static br.com.pedrodcp.maintenance.Comandos.manutencao.*;

import br.com.pedrodcp.maintenance.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTD implements Listener {

    @EventHandler
    public void setMOTD(ServerListPingEvent e) {
        if (manutencao.contains("on")) {
            e.setMotd(Main.getInstance().getConfig().getString("Config.MOTD").replace("&", "§").replace("%nl% ", "\n"));

        } else {
            if (Main.getInstance().getConfig().getString("MOTD-normal.config").equalsIgnoreCase("on")) {
                e.setMotd(Main.getInstance().getConfig().getString("MOTD-normal.MOTD").replace("&", "§").replace("%nl% ", "\n"));
            }
        }
    }

}