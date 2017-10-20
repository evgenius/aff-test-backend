package de.affinitas.match_filter.db.inmemory;

import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.db.Query;
import de.affinitas.match_filter.model.Match;
import de.affinitas.match_filter.model.Matches;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InMemoryDatabaseQuery implements Query {

    private final InMemoryDatabase db;
    private List<Filter> filters = new ArrayList<>();

    InMemoryDatabaseQuery(InMemoryDatabase db) {
        this.db = db;
    }

    @Override
    public Query addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public Matches execute() {
        Stream<Match> stream = db.getMatches().parallelStream();
        for (Filter filter : filters) {
            stream = stream.filter(filter);
        }
        return stream.collect(Matches::new, Matches::add, Matches::addAll);
    }


}
