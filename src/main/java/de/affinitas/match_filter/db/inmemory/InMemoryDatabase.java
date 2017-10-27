package de.affinitas.match_filter.db.inmemory;

import com.google.inject.Inject;
import de.affinitas.match_filter.db.Database;
import de.affinitas.match_filter.db.Query;
import de.affinitas.match_filter.model.Match;
import de.affinitas.match_filter.model.Matches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryDatabase implements Database {

    private List<Match> matches;
    private CommentsIndex commentsIndex = new CommentsIndex();

    @Inject
    InMemoryDatabase(Matches matches) {
        this.matches = matches;
    }

    List<Match> getMatches() {
        return Collections.unmodifiableList(matches);
    }

    @Override
    public List<String> getComments(int userId) {
        return commentsIndex.computeIfAbsent(userId, k -> new ArrayList<>());
    }

    @Override
    public void addComment(int userId, String comment) {
        commentsIndex.computeIfAbsent(userId, k -> new ArrayList<>()).add(comment);
    }

    @Override
    public Query createQuery() {
        return new InMemoryDatabaseQuery(this);
    }
}
