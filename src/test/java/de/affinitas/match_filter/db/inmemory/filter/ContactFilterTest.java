package de.affinitas.match_filter.db.inmemory.filter;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContactFilterTest extends AbstractFilterTest {
    @Test
    public void testFilter() {
        ContactFilter filter = new ContactFilter();
        assertEquals(12, applyFilter(filter).size());
    }
}
