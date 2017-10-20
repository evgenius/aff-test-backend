package de.affinitas.match_filter.db.inmemory.filter;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhotoFilterTest extends AbstractFilterTest {
    @Test
    public void testFilter() {
        PhotoFilter filter = new PhotoFilter();
        assertEquals(22, applyFilter(filter).size());
    }
}
