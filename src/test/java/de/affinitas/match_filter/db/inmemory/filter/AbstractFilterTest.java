package de.affinitas.match_filter.db.inmemory.filter;

import de.affinitas.match_filter.MatchesLoader;
import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.model.Match;
import de.affinitas.match_filter.model.Matches;

import java.util.List;
import java.util.stream.Collectors;

abstract class AbstractFilterTest {

    private final Matches matches = MatchesLoader.getMatches();

    List<String> applyFilter(Filter filter) {
        return matches.parallelStream()
                .filter(filter)
                .map(Match::getDisplayName)
                .collect(Collectors.toList());
    }

}
