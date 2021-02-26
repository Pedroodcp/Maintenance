package Principal;

import Principal.Comandos.manutencao;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        loadCommands();
        loadConfig();
        Bukkit.getConsoleSender().sendMessage("§a[pManutencao] Plugin ativado com sucesso.");
    }

    @Override
    public void onDisable() {
        loadConfig();
        Bukkit.getConsoleSender().sendMessage("§c[pManutencao] Plugin desativado.");
    }

    public void loadCommands() {
        getCommand("manutencao").setExecutor(new manutencao());
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return instance;
    }

}
