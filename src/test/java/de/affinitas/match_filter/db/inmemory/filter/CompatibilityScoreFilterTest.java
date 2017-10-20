package de.affinitas.match_filter.db.inmemory.filter;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompatibilityScoreFilterTest extends AbstractFilterTest {
    @Test
    public void testAccurateFilter() {
        CompatibilityScoreFilter filter = new CompatibilityScoreFilter(0.50f, 0.50f);
        assertEquals(1, applyFilter(filter).size());
    }

    @Test
    public void testAccurateEmptyFilter() {
        CompatibilityScoreFilter filter = new CompatibilityScoreFilter(1, 1);
        assertEquals(0, applyFilter(filter).size());
    }

    @Test
    public void testNormalRangeFilter() {
        CompatibilityScoreFilter filter = new CompatibilityScoreFilter(0.33f, 0.66f);
        assertEquals(2, applyFilter(filter).size());
    }

    @Test
    public void testFilterIsInclusive() {
        CompatibilityScoreFilter filter = new CompatibilityScoreFilter(0.47f, 0.99f);
        assertEquals(25, applyFilter(filter).size());
    }

    @Test
    public void testGreedyFilter() {
        CompatibilityScoreFilter filter = new CompatibilityScoreFilter(0, 1);
        assertEquals(25, applyFilter(filter).size());
    }
}
