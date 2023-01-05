package de.smoofy.proxy;

import com.velocitypowered.api.proxy.ProxyServer;
import de.smoofy.core.api.global.database.IDatabase;
import lombok.Getter;

/**
 * @author - Smoofy
 * @GitHub - https://github.com/Smoofy19
 * @Twitter - https://twitter.com/Smoofy19
 * Erstellt - 05.01.2023 22:59
 */
@Getter
public class ProxyBase {

    @Getter
    private static ProxyBase instance;

    @Getter
    private static String prefix = "§8[§bSmoofy§8] ";

    private ProxyServer proxyServer;

    private IDatabase database;

    public static String getPrefix(String prefix) {
        return "§8[" + prefix + "§8] ";
    }
}
