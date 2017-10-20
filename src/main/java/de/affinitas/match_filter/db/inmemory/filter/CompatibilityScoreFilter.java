package de.affinitas.match_filter.db.inmemory.filter;

import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.model.Match;

public class CompatibilityScoreFilter implements Filter {
    private final float minimumScore;
    private final float maxScore;

    public CompatibilityScoreFilter(float minScore, float maxScore) {
        this.minimumScore = minScore;
        this.maxScore = maxScore;
    }

    @Override
    public boolean test(Match match) {
        return match.getCompatibilityScore() >= minimumScore &&
                match.getCompatibilityScore() <= maxScore;
    }
}
