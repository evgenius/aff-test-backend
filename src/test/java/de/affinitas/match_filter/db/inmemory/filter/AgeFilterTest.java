package de.affinitas.match_filter.db.inmemory.filter;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgeFilterTest extends AbstractFilterTest {
    @Test
    public void testEmptyResult() {
        AgeFilter filter = new AgeFilter(18, 24);
        assertEquals(0, applyFilter(filter).size());
    }

    @Test
    public void testNonEmptyResult() {
        AgeFilter filter = new AgeFilter(20, 30);
        assertEquals(1, applyFilter(filter).size());
    }

    @Test
    public void testWrongLimits() {
        AgeFilter filter = new AgeFilter(40, 20);
        assertEquals(0, applyFilter(filter).size());
    }

    @Test
    public void testFilterIsInclusive() {
        AgeFilter filter = new AgeFilter(25, 55);
        assertEquals(25, applyFilter(filter).size());
    }
}
