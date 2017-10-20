package de.affinitas.match_filter.db.inmemory.filter;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeightFilterTest extends AbstractFilterTest {
    @Test
    public void testAccurateFilter() {
        HeightFilter filter = new HeightFilter(177, 177);
        assertEquals(3, applyFilter(filter).size());
    }

    @Test
    public void testAccurateEmptyFilter() {
        HeightFilter filter = new HeightFilter(147, 147);
        assertEquals(0, applyFilter(filter).size());
    }

    @Test
    public void testNormalRangeFilter() {
        HeightFilter filter = new HeightFilter(155, 170);
        assertEquals(8, applyFilter(filter).size());
    }

    @Test
    public void testFilterIsInclusive() {
        HeightFilter filter = new HeightFilter(148, 150);
        assertEquals(2, applyFilter(filter).size());
    }

    @Test
    public void testGreedyFilter() {
        HeightFilter filter = new HeightFilter(140, 177);
        assertEquals(25, applyFilter(filter).size());
    }
}
