package de.affinitas.match_filter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.affinitas.match_filter.model.Matches;
import de.affinitas.match_filter.model.MatchesWrapper;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MatchesLoader {

    private static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    public static Matches getMatches() {
        InputStream s = Application.class.getResourceAsStream("matches.json");
        MatchesWrapper matchesWrapper = gson.fromJson(new InputStreamReader(s), MatchesWrapper.class);
        return matchesWrapper.getMatches();
    }
}
