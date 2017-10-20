package de.affinitas.match_filter.db.inmemory;

import com.google.inject.Inject;
import de.affinitas.match_filter.db.Database;
import de.affinitas.match_filter.db.Query;
import de.affinitas.match_filter.model.Match;
import de.affinitas.match_filter.model.Matches;

import java.util.Collections;
import java.util.List;

public class InMemoryDatabase implements Database {

    private List<Match> matches;

    @Inject
    InMemoryDatabase(Matches matches) {
        this.matches = matches;
    }

    List<Match> getMatches() {
        return Collections.unmodifiableList(matches);
    }

    @Override
    public Query createQuery() {
        return new InMemoryDatabaseQuery(this);
    }
}
