package de.affinitas.match_filter.db.inmemory.filter;

import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.model.Match;

public class HeightFilter implements Filter {
    private int minHeight;
    private int maxHeight;

    public HeightFilter(int minHeight, int maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean test(Match match) {
        return match.getHeightInCm() >= minHeight && match.getHeightInCm() <= maxHeight;
    }
}
