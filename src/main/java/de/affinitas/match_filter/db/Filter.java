package de.affinitas.match_filter.db;

import de.affinitas.match_filter.model.Match;

import java.util.function.Predicate;

public interface Filter extends Predicate<Match> {
    boolean test(Match match);
}
