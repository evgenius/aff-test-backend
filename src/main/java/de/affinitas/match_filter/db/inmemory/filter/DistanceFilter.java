package de.affinitas.match_filter.db.inmemory.filter;

import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.geo.Distance;
import de.affinitas.match_filter.model.City;
import de.affinitas.match_filter.model.Match;

import java.util.Arrays;

public class DistanceFilter implements Filter {

    private final float lat;
    private final float lon;
    private final int distance;

    DistanceFilter(float lat, float lon, int distance) {
        this.lat = lat;
        this.lon = lon;
        this.distance = distance;
    }

    @Override
    public boolean test(Match match) {
        City matchCity = match.getCity();
        return distance == -1 ||
                distance >= Distance.getDistance(lat, lon, matchCity.getLat(), matchCity.getLon());
    }

    @Override
    public String toString() {
        return Arrays.asList("DistanceFilter", lat, lon, distance).toString();
    }
}
