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
        Spark.get("/status", (req, res) -> "{\"status\": \"ok\"}");
        Spark.get("/api/match", this::getMatch);
        Spark.get("/api/comments/:id", this::getComments);
        Spark.post("/api/comments/:id", this::postComment);

        Spark.after("*", (req, res) -> {
            addResponseHeaders(res);
        });

        Spark.options("*", (req, res) -> {
            res.header("Access-Control-Allow-Headers", "Content-Type");
            res.header("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            return "";
        });

        Spark.exception(Exception.class, (ex, req, res) -> {
            addResponseHeaders(res);
            res.body(gson.toJson(new JsonErrorResponse(ex.getMessage())));
        });
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
        return gson.toJson(new JsonDataResponse(query.execute()));
    }

    private String getComments(Request req, Response res) {
        int userId = Integer.parseInt(req.params("id"));
        return gson.toJson(new JsonDataResponse(db.getComments(userId)));
    }

    private String postComment(Request req, Response res) {
        PostCommentJsonRequest jsonRequest = gson.fromJson(req.body(), PostCommentJsonRequest.class);
        int userId = Integer.parseInt(req.params("id"));
        String comment = jsonRequest.getMessage();
        db.addComment(userId, comment);
        return "";
    }

    private void addResponseHeaders(Response res) {
        res.header("Access-Control-Allow-Origin", "*");
        res.header("Content-Type", "application/json");
    }

    private static Filter parseFilter(String val) throws ParserException {
        String[] values = val.split(":");
        return Filters.create(values);
    }
}
