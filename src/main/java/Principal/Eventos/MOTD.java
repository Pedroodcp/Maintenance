package Principal.Eventos;

import static Principal.Main.*;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTD implements Listener {

    @EventHandler
    public void setMOTD(ServerListPingEvent e) {
        if (Bukkit.getServer().hasWhitelist())
            e.setMotd(getInstance().getConfig().getString("Config.MOTD").replace("&", "§").replace("%nl% ", "\n"));
    }

}