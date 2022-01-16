package de.fynn.mystic.mysticguild.system.hook;

import de.fynn.mystic.mysticguild.MysticGuild;
import de.fynn.mystic.mysticguild.system.file.ConfigHandler;
import de.fynn.mystic.mysticlanguageapi.language.LanguageManager;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.UUID;

public class MysticLanguageAPIHook {

    private static MysticLanguageAPIHook instance;
    private final LanguageManager languageManager;

    public MysticLanguageAPIHook(Plugin parent){
        instance = this;
        String defaultLang = ConfigHandler.getDefaultLangauge();
        languageManager = new LanguageManager(parent, defaultLang, new File(MysticGuild.getInstance().getDataFolder()+"/language/defaultMessages.yml"));
    }

    public String getMessage(UUID uuid, String path){
        return languageManager.getMessage(uuid, path);
    }

    public static MysticLanguageAPIHook getInstance() {
        return instance;
    }

}
