package Principal;

import static Principal.Comandos.manutencao.*;
import Principal.Comandos.manutencao;
import Principal.Eventos.GUI.ClickEvent;
import Principal.Eventos.MOTD;
import Principal.Eventos.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        loadCommands();
        loadConfig();
        loadEvents();
        Bukkit.getConsoleSender().sendMessage("§a[pManutencao] Plugin ativado com sucesso.");
        manutencao.clear();
        manutencao.add("off");
    }

    @Override
    public void onDisable() {
        loadConfig();
        Bukkit.getConsoleSender().sendMessage("§c[pManutencao] Plugin desativado.");
    }

    public void loadCommands() {
        getCommand("manutencao").setExecutor(new manutencao());
    }

    public void loadEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MOTD(), this);
        pm.registerEvents(new ClickEvent(), this);
        pm.registerEvents(new PlayerJoin(), this);
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return instance;
    }

}
