package de.affinitas.match_filter.db.inmemory;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CommentsIndex extends ConcurrentHashMap<Integer, List<String>> {
}
