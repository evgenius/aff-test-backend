package de.affinitas.match_filter.geo;

import de.affinitas.match_filter.model.City;

public class Distance {

    private static final int EARTH_RADIUS = 6371;

    public static int getDistance(City city0, City city1) {
        double lat0R = Math.toRadians(city0.getLat());
        double lon0R = Math.toRadians(city0.getLon());
        double lat1R = Math.toRadians(city1.getLat());
        double lon1R = Math.toRadians(city1.getLon());

        double x = (lon0R - lon1R) * Math.cos((lat0R + lat1R) / 2);
        double y = lat0R - lat1R;

        return (int) (Math.sqrt(x * x + y * y) * EARTH_RADIUS);
    }
}
