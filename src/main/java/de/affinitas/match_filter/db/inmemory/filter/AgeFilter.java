package de.affinitas.match_filter.db.inmemory.filter;

import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.model.Match;

import java.util.Arrays;

public class AgeFilter implements Filter {
    private int minAge;
    private int maxAge;

    public AgeFilter(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean test(Match match) {
        return match.getAge() >= minAge && match.getAge() <= maxAge;
    }

    @Override
    public String toString() {
        return Arrays.asList("AgeFilter", minAge, maxAge).toString();
    }
}
