package de.affinitas.match_filter.db;

import de.affinitas.match_filter.model.Matches;

public interface Query {
    Query addFilter(Filter filter);
    Matches execute();
}
