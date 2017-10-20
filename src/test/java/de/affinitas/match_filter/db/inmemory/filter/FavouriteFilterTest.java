package de.affinitas.match_filter.db.inmemory.filter;

import org.junit.Test;

import static org.junit.Assert.*;

public class FavouriteFilterTest extends AbstractFilterTest {
    @Test
    public void testFilter() {
        FavouriteFilter filter = new FavouriteFilter();
        assertEquals(6, applyFilter(filter).size());
    }
}
