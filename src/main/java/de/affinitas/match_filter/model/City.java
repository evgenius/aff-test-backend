package de.affinitas.match_filter.model;

public class City {
    private String name;
    private float lat;
    private float lon;

    public City(String name, float lat, float lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }
}
