package Principal.Comandos;

import static Principal.Main.*;

import Principal.Eventos.GUI.Inv;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class manutencao implements CommandExecutor {

    public static ArrayList<String> manutencao = new ArrayList<>();

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
                        if (manutencao.contains("on")) {
                            p.sendMessage(getInstance().getConfig().getString("Msg-erro.manutencao-ativada").replace("&", "§"));

                        } else {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                if (all.hasPermission("pmanutencao.admin")) {
                                    all.setWhitelisted(true);
                                    Bukkit.broadcastMessage("");
                                    Bukkit.broadcastMessage(getInstance().getConfig().getString("Config.manutencao-ativada").replace("&", "§"));
                                    Bukkit.broadcastMessage("");
                                    manutencao.clear();
                                    manutencao.add("on");
                                    p.sendMessage("§eA manutenção foi ativada com sucesso.");
                                    p.sendMessage("");

                                } else {
                                    all.kickPlayer(getInstance().getConfig().getString("Config.mensagem-kick").replace("&", "§").replace("%nl%", "\n"));
                                }
                            }
                        }
                    }
                    if (args[0].equalsIgnoreCase("off")) {
                        if (manutencao.contains("off")) {
                            p.sendMessage(getInstance().getConfig().getString("Msg-erro.manutencao-desativada").replace("&", "§"));

                        } else {
                            Bukkit.broadcastMessage("");
                            Bukkit.broadcastMessage(getInstance().getConfig().getString("Config.manutencao-desativada").replace("&", "§"));
                            Bukkit.broadcastMessage("");
                            manutencao.clear();
                            manutencao.add("off");
                            p.sendMessage("§eA manutenção foi desativada com sucesso.");
                            p.sendMessage("");
                        }
                    }
                    if (args[0].equalsIgnoreCase("info")) {
                        if (manutencao.contains("on")) {
                            p.sendMessage(getInstance().getConfig().getString("Msg-info.manutencao-ativada").replace("&", "§"));

                        } else {
                            p.sendMessage(getInstance().getConfig().getString("Msg-info.manutencao-desativada").replace("&", "§"));
                        }
                    }
                }
            }
        }

        return false;
    }
}
