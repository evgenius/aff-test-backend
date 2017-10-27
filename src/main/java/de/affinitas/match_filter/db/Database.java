package de.affinitas.match_filter.db;

import java.util.List;

public interface Database {
    Query createQuery();

    List<String> getComments(int userId);

    void addComment(int userId, String comment);
}
