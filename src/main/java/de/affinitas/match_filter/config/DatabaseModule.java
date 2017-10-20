package de.affinitas.match_filter.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import de.affinitas.match_filter.db.Database;
import de.affinitas.match_filter.db.inmemory.InMemoryDatabase;
import de.affinitas.match_filter.model.MatchesWrapper;
import de.affinitas.match_filter.model.Matches;

import java.io.InputStream;
import java.io.InputStreamReader;

public class DatabaseModule extends AbstractModule {

    private static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    @Override
    protected void configure() {
        bind(Database.class).to(InMemoryDatabase.class);
    }

    @Provides
    Matches provideMatches() {
        InputStream stream = getClass().getResourceAsStream("matches.json");
        MatchesWrapper wrapper = gson.fromJson(new InputStreamReader(stream), MatchesWrapper.class);
        return wrapper.getMatches();
    }
}
