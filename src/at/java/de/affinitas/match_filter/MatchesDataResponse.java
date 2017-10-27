package de.affinitas.match_filter;

import de.affinitas.match_filter.model.Matches;

class MatchesDataResponse {
    private Matches data;
    private String message;

    Matches getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
