package Principal.Eventos;

import static Principal.Comandos.manutencao.*;
import static Principal.Main.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTD implements Listener {

    @EventHandler
    public void setMOTD(ServerListPingEvent e) {
        if (manutencao.contains("on")) {
            e.setMotd(getInstance().getConfig().getString("Config.MOTD").replace("&", "§").replace("%nl% ", "\n"));

        } else {
            if (getInstance().getConfig().getString("MOTD-normal.config").equalsIgnoreCase("on")) {
                e.setMotd(getInstance().getConfig().getString("MOTD-normal.MOTD").replace("&", "§").replace("%nl% ", "\n"));
            }
        }
    }

}