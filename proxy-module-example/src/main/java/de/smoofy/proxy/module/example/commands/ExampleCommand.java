package de.smoofy.proxy.module.example.commands;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import de.dytanic.cloudnet.ext.bridge.player.ICloudPlayer;
import de.smoofy.core.api.Smoofy;
import de.smoofy.core.api.global.cloud.cloudnet.ICloudNetUser;
import de.smoofy.core.api.global.message.IMessage;
import de.smoofy.proxy.ProxyBase;
import net.kyori.adventure.text.Component;

/**
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * @Twitter - https://twitter.com/Smoofy19
 * Erstellt - 05.01.2023 23:07
 */
public class ExampleCommand implements SimpleCommand {

    @Override
    public void execute(Invocation invocation) {
        CommandSource commandSource = invocation.source();
        IMessage message = Smoofy.getCore().getMessage("proxy/modules/example-module");
        if(commandSource instanceof Player player) message.setLanguage(player.getUniqueId());
        if(!commandSource.hasPermission("system.example")) {
            commandSource.sendMessage(Component.text(message.getNoPerms()));
            return;
        }
        String[] args = invocation.arguments();
        if(args.length != 1) {
            commandSource.sendMessage(Component.text(message.getUsage(ProxyBase.getPrefix()) + message.get("example.usage")));
            return;
        }
        ICloudNetUser targetCloudUser = Smoofy.getCore().getCloudManager().getCloudNetManager().getCloudUser(args[0]);
        if(targetCloudUser == null) {
            commandSource.sendMessage(Component.text(message.getPlayerNotFound()));
            return;
        }
        ICloudPlayer cloudPlayer = targetCloudUser.getCloudPlayer();
        if(cloudPlayer == null) {
            commandSource.sendMessage(Component.text(ProxyBase.getPrefix() + message.get("player.not-online", targetCloudUser.getDisplayName())));
            return;
        }
        commandSource.sendMessage(Component.text(ProxyBase.getPrefix() + message.get("example.success")));
    }
}
