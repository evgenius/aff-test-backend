package de.affinitas.match_filter.db.inmemory.filter;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceFilterTest extends AbstractFilterTest {
    @Test
    public void testAccurateFilter() {
        DistanceFilter filter = new DistanceFilter(55.006763f, -7.318268f, 0);
        assertEquals(1, applyFilter(filter).size());
    }

    @Test
    public void testAccurateEmptyFilter() {
        DistanceFilter filter = new DistanceFilter(55.0f, -8.0f, 0);
        assertEquals(0, applyFilter(filter).size());
    }

    @Test
    public void testNormalRangeFilter() {
        DistanceFilter filter = new DistanceFilter(51.509865f, -0.118092f, 100);
        assertEquals(9, applyFilter(filter).size());
    }

    @Test
    public void testFilterIsInclusive() {
        DistanceFilter filter = new DistanceFilter(51.509865f, -0.118092f, 0);
        assertEquals(6, applyFilter(filter).size());
    }

    @Test
    public void testGreedyFilter() {
        DistanceFilter filter = new DistanceFilter(51.509865f, -0.118092f, 3000);
        assertEquals(25, applyFilter(filter).size());
    }
}