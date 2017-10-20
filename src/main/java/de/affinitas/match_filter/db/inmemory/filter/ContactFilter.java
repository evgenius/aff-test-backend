package de.affinitas.match_filter.db.inmemory.filter;

import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.model.Match;

public class ContactFilter implements Filter {
    @Override
    public boolean test(Match match) {
        return match.getContactsExchanged() > 0;
    }
}
