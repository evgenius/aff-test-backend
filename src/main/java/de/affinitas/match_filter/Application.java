package de.affinitas.match_filter;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import de.affinitas.match_filter.config.DatabaseModule;
import de.affinitas.match_filter.db.Database;
import de.affinitas.match_filter.http.HttpService;
import spark.Spark;

import java.io.IOException;

public class Application {

    @Inject
    private Database db;

    public static void main(String[] args) throws IOException {
        Injector injector = Guice.createInjector(new DatabaseModule());
        Application app = injector.getInstance(Application.class);
        app.start();
    }

    private void start() {
        Spark.port(8080);
        HttpService httpService = new HttpService(db);
        httpService.setupRoutes();
    }
}
