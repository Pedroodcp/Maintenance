package Principal.Comandos;

import static Principal.Main.*;

import Principal.Eventos.GUI.Inv;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class manutencao implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("manutencao")) {
            if (!p.hasPermission("pmanutencao.admin")) {
                p.sendMessage("§cVocê não possui permissão para utilizar este comando.");

            } else {
                if (args.length == 0) {
                    p.openInventory(new Inv().getInventory());
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("on")) {
                        if (Bukkit.getServer().hasWhitelist()) {
                            p.sendMessage(getInstance().getConfig().getString("Msg-erro.manutencao-ativada").replace("&", "§"));

                        } else {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                if (all.hasPermission("pmanutencao.admin")) {
                                    Bukkit.broadcastMessage("");
                                    Bukkit.broadcastMessage(getInstance().getConfig().getString("Config.manutencao-ativada").replace("&", "§"));
                                    Bukkit.broadcastMessage("");
                                    p.setWhitelisted(true);
                                    Bukkit.getServer().setWhitelist(true);
                                    p.sendMessage("§eA manutenção foi ativada com sucesso.");
                                    p.sendMessage("");

                                } else {
                                    all.kickPlayer(getInstance().getConfig().getString("Config.mensagem-kick").replace("&", "§").replace("%nl%", "\n"));
                                }
                            }
                        }
                    }
                    if (args[0].equalsIgnoreCase("off")) {
                        if (Bukkit.getServer().hasWhitelist()) {
                            Bukkit.broadcastMessage("");
                            Bukkit.broadcastMessage(getInstance().getConfig().getString("Config.manutencao-desativada").replace("&", "§"));
                            Bukkit.broadcastMessage("");
                            Bukkit.getServer().setWhitelist(false);
                            p.sendMessage("§eA manutenção foi desativada com sucesso.");
                            p.sendMessage("");

                        } else {
                            p.sendMessage(getInstance().getConfig().getString("Msg-erro.manutencao-desativada").replace("&", "§"));
                        }
                    }
                    if (args[0].equals("info")) {
                        if (Bukkit.getServer().hasWhitelist()) {
                            p.sendMessage("§aAtualmente, a manutenção está ativada.");

                        } else {
                            p.sendMessage("§cAtualmente, a manutenção está desativada.");
                        }
                    }
                }
            }
        }

        return false;
    }
}
