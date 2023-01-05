package de.smoofy.proxy.module.example;

import de.smoofy.proxy.module.ProxyModule;
import de.smoofy.proxy.module.example.commands.ExampleCommand;
import de.smoofy.proxy.module.example.listener.ExampleListener;
import lombok.Getter;

/**
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * @Twitter - https://twitter.com/Smoofy19
 * Erstellt - 05.01.2023 23:05
 */
public class ExampleModule extends ProxyModule {

    @Getter
    private static ExampleModule instance;

    @Override
    public void onEnable() {
        instance = this;

        registerCommand(new ExampleCommand(), "example", "ex");
        registerListener(new ExampleListener());
    }

    @Override
    public void onDisable() {
        instance = null;
        unregisterCommand("example");
        unregisterListener(new ExampleListener());
    }
}
