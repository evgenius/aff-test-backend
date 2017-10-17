package de.affinitas.match_filter.geo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DistanceTest {

    class Location {
        private final float lat;
        private final float lon;

        Location(float lat, float lon) {
            this.lat = lat;
            this.lon = lon;
        }
    }

    private Location berlin = new Location(52.5164121f, 13.3774509f);
    private Location moscow = new Location(55.7539303f, 37.6186063f);
    private Location munich = new Location(48.1354644f, 11.5738865f);
    private Location newYork = new Location(40.7587857f, -73.9848582f);
    private Location potsdam = new Location(52.3998029f, 13.0360108f);

    @Test
    public void testGetDistanceZero() {
        assertEquals(0, getDistance(berlin, berlin));
    }

    @Test
    public void testGetDistanceBerlinPotsdam() {
        assertEquals(26, getDistance(berlin, potsdam));
    }

    @Test
    public void testGetDistanceBerlinMunich() {
        assertEquals(503, getDistance(berlin, munich));
    }

    @Test
    public void testGetDistanceBerlinMoscow() {
        assertEquals(1619, getDistance(berlin, moscow));
    }

    @Test
    public void testGetDistanceMoscowBerlin() {
        assertEquals(1619, getDistance(moscow, berlin));
    }

    @Test
    public void testGetDistanceBerlinNewYork() {
        assertEquals(6796, getDistance(berlin, newYork));
    }

    @Test
    public void testGetDistanceMoscowNewYork() {
        assertEquals(8428, getDistance(moscow, newYork));
    }

    private int getDistance(Location loc0, Location loc1) {
        return Distance.getDistance(loc0.lat, loc0.lon, loc1.lat, loc1.lon);
    }
}
