package de.affinitas.match_filter.db.inmemory.filter;

import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.exception.ParserException;

import java.util.Arrays;

public enum Filters {
    PHOTO {
        @Override
        Filter createInstance(String[] params) {
            return new PhotoFilter();
        }
    },
    CONTACT {
        @Override
        Filter createInstance(String[] params) {
            return new ContactFilter();
        }
    },
    FAVOURITE {
        @Override
        Filter createInstance(String[] params) {
            return new FavouriteFilter();
        }
    },
    COMPATIBILITY {
        @Override
        Filter createInstance(String[] params) {
            int minScore = Integer.valueOf(params[0]);
            int maxScore = Integer.valueOf(params[1]);
            return new CompatibilityScoreFilter(minScore, maxScore);
        }
    },
    AGE {
        @Override
        Filter createInstance(String[] params) {
            int minAge = Integer.valueOf(params[0]);
            int maxAge = Integer.valueOf(params[1]);
            return new AgeFilter(minAge, maxAge);
        }
    },
    HEIGHT {
        @Override
        Filter createInstance(String[] params) {
            int minHeight = Integer.valueOf(params[0]);
            int maxHeight = Integer.valueOf(params[1]);
            return new HeightFilter(minHeight, maxHeight);
        }
    },
    DISTANCE {
        @Override
        Filter createInstance(String[] params) {
            int lat = Integer.valueOf(params[0]);
            int lon = Integer.valueOf(params[1]);
            int distance = Integer.valueOf(params[2]);
            return new DistanceFilter(lat, lon, distance);
        }
    };

    abstract Filter createInstance(String[] params);

    public static Filter create(String[] params) throws ParserException {
        String filterType = params[0].toUpperCase();
        String[] restParams = Arrays.copyOfRange(params, 1, params.length);
        try {
            return Filters.valueOf(filterType).createInstance(restParams);
        } catch (IllegalArgumentException ex) {
            throw new ParserException("Unknown filter type: " + filterType);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new ParserException("Invalid filter parameters number");
        }
    }
}
