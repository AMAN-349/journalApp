package net.engineeringdigest.journalApp.cache;

import net.engineeringdigest.journalApp.entity.ConfigJournalAppEntity;
import net.engineeringdigest.journalApp.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum keys{
        WEATHER_API;
    }

    public Map<String,String> appCache=new HashMap<>();;

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    @PostConstruct  //this method immediately calls as bean created for this class
    public void init()
    {
        appCache =new HashMap<>();
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
        for(ConfigJournalAppEntity configJournalAppEntity : all)
        {
            appCache.put(configJournalAppEntity.getKey(),configJournalAppEntity.getValue());
        }

    }

}
