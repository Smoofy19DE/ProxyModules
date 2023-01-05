package de.smoofy.proxy.module;

import com.velocitypowered.api.command.Command;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.command.CommandMeta;
import com.velocitypowered.api.event.EventManager;
import de.smoofy.proxy.ProxyBase;

/**
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * @Twitter - https://twitter.com/Smoofy19
 * Erstellt - 05.01.2023 23:00
 */
public abstract class ProxyModule {

    public abstract void onEnable();

    public abstract void onDisable();

    private final CommandManager commandManager = ProxyBase.getInstance().getProxyServer().getCommandManager();
    private final EventManager eventManager = ProxyBase.getInstance().getProxyServer().getEventManager();

    public void registerCommand(Command command, String commandName, String... aliases) {
        CommandMeta.Builder builder = commandManager.metaBuilder(commandName);
        if(aliases.length > 0) builder.aliases(aliases);
        commandManager.register(builder.build(), command);
    }

    public void unregisterCommand(String commandName) {
        commandManager.unregister(commandManager.getCommandMeta(commandName));
    }

    public void registerListener(Object listener) {
        eventManager.register(ProxyBase.getInstance(), listener);
    }

    public void unregisterListener(Object listener) {
        eventManager.unregisterListener(ProxyBase.getInstance(), listener);
    }
}
