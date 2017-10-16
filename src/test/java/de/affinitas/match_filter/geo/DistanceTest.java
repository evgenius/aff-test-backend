package de.affinitas.match_filter.geo;

import de.affinitas.match_filter.model.City;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceTest {

    private City berlin = new City("Berlin", 52.5164121f, 13.3774509f);
    private City moscow = new City("Moscow", 55.7539303f, 37.6186063f);
    private City munich = new City("Munich", 48.1354644f, 11.5738865f);
    private City newYork = new City("New York", 40.7587857f, -73.9848582f);
    private City potsdam = new City("Potsdam", 52.3998029f, 13.0360108f);

    @Test
    public void testGetDistanceZero() {
        assertEquals(0, Distance.getDistance(berlin, berlin));
    }

    @Test
    public void testGetDistanceBerlinPotsdam() {
        assertEquals(26, Distance.getDistance(berlin, potsdam));
    }

    @Test
    public void testGetDistanceBerlinMunich() {
        assertEquals(503, Distance.getDistance(berlin, munich));
    }

    @Test
    public void testGetDistanceBerlinMoscow() {
        assertEquals(1619, Distance.getDistance(berlin, moscow));
    }

    @Test
    public void testGetDistanceMoscowBerlin() {
        assertEquals(1619, Distance.getDistance(moscow, berlin));
    }

    @Test
    public void testGetDistanceBerlinNewYork() {
        assertEquals(6796, Distance.getDistance(berlin, newYork));
    }

    @Test
    public void testGetDistanceMoscowNewYork() {
        assertEquals(8428, Distance.getDistance(moscow, newYork));
    }
}
