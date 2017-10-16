package de.affinitas.match_filter.http;

import spark.Spark;

public class HttpService {
    public static void setupRoutes() {
        Spark.get("/api", (req, res) -> "");
    }
}
