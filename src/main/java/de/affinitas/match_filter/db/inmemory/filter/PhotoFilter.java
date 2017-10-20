package de.affinitas.match_filter.db.inmemory.filter;

import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.model.Match;

public class PhotoFilter implements Filter {
    @Override
    public boolean test(Match match) {
        return match.getMainPhoto() != null;
    }
}
