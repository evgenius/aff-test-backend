package de.affinitas.match_filter.http;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.affinitas.match_filter.db.Database;
import de.affinitas.match_filter.db.Filter;
import de.affinitas.match_filter.db.Query;
import de.affinitas.match_filter.db.inmemory.filter.Filters;
import de.affinitas.match_filter.exception.ParserException;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.Spark;

public class HttpService {

    private static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    private final Database db;

    public HttpService(Database db) {
        this.db = db;
    }

    public void setupRoutes() {
        Spark.get("/api/match", this::getMatch);

        Spark.exception(Exception.class, (ex, req, res) ->
                res.body(gson.toJson(new JsonErrorResponse(ex.getMessage()))));
    }

    private String getMatch(Request req, Response res) throws ParserException {
        Query query = db.createQuery();
        QueryParamsMap filterMap = req.queryMap("filter");
        if (filterMap != null && filterMap.hasValue()) {
            String[] values = filterMap.values();
            if (values != null) {
                for (String val : values) {
                    Filter filter = parseFilter(val);
                    query.addFilter(filter);
                }
            }
        }
        res.header("Access-Control-Allow-Origin", "*");
        res.header("Content-Type", "application/json");
        return gson.toJson(new JsonDataResponse(query.execute()));
    }

    private static Filter parseFilter(String val) throws ParserException {
        String[] values = val.split(":");
        return Filters.create(values);
    }
}
