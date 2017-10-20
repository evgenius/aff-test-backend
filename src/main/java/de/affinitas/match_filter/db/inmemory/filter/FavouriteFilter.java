package de.affinitas.match_filter.db.inmemory.filter;

import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.model.Match;

public class FavouriteFilter implements Filter {
    @Override
    public boolean test(Match match) {
        return match.isFavourite();
    }
}
