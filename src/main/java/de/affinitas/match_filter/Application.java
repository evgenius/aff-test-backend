package de.affinitas.match_filter;

import de.affinitas.match_filter.http.HttpService;
import spark.Spark;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Spark.port(8080);
        HttpService.setupRoutes();
    }
}
