package de.affinitas.match_filter.geo;

public class Distance {

    private static final int EARTH_RADIUS = 6371;

    public static int getDistance(float lat0, float lon0, float lat1, float lon1) {
        double lat0R = Math.toRadians(lat0);
        double lon0R = Math.toRadians(lon0);
        double lat1R = Math.toRadians(lat1);
        double lon1R = Math.toRadians(lon1);

        double x = (lon0R - lon1R) * Math.cos((lat0R + lat1R) / 2);
        double y = lat0R - lat1R;

        return (int) (Math.sqrt(x * x + y * y) * EARTH_RADIUS);
    }
}
