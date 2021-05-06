package br.com.pedrodcp.maintenance;

import static br.com.pedrodcp.maintenance.Comandos.manutencao.*;
import br.com.pedrodcp.maintenance.Comandos.manutencao;
import br.com.pedrodcp.maintenance.Eventos.GUI.ClickEvent;
import br.com.pedrodcp.maintenance.Eventos.MOTD;
import br.com.pedrodcp.maintenance.Eventos.PlayerJoin;
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
