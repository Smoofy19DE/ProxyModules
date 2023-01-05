package de.smoofy.proxy.module.example.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import net.kyori.adventure.text.Component;

/**
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * @Twitter - https://twitter.com/Smoofy19
 * Erstellt - 05.01.2023 23:07
 */
public class ExampleListener {

    // Example event
    @Subscribe
    public void onPostLogin(PostLoginEvent event) {
        event.getPlayer().sendMessage(Component.text("blabla"));
        // Do something
    }
}
