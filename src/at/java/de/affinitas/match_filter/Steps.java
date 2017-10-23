package de.affinitas.match_filter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import de.affinitas.match_filter.model.Matches;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;


public class Steps implements En {

    private static final String ENDPOINT = "http://localhost:8080";

    private static final Gson gson = new GsonBuilder().create();

    private HttpClient client = new HttpClient();
    private Request request;
    private DataResponse dataResponse;
    private Matches results;

    @Before
    public void beforeScenario() throws Exception {
        client.start();
        request = client.newRequest(ENDPOINT + "/api/match");
    }

    @Given("^the service is running$")
    public void theServiceIsRunning() throws InterruptedException, ExecutionException, TimeoutException {
        ContentResponse response = client.GET(ENDPOINT + "/status");
        assertEquals("{\"status\": \"ok\"}", response.getContentAsString());
    }

    @When("^I apply a[n]? \"([^\"]*)\" filter$")
    public void iApplyAPhotoFilter(String filter) throws Throwable {
        request.param("filter", filter);
    }

    @When("^I apply a[n]? \"([^\"]*)\" filter with range from (\\d+) to ([\\-]?\\d+)$")
    public void iApplyAFilterWithIntRangeFromTo(String filter, int from, int to) throws Throwable {
        request.param("filter", String.format("%s:%s:%s", filter, from, to));
    }

    @When("^I apply a[n]? \"([^\"]*)\" filter with range from (\\d+\\.\\d+) to ([\\-]?\\d+\\.\\d+)$")
    public void iApplyAFilterWithFloatRangeFromTo(String filter, float from, float to) throws Throwable {
        request.param("filter", String.format("%s:%s:%s", filter, from, to));
    }

    @When("^I apply a \"distance\" filter with the distance ([\\-]?\\d+) km " +
            "from the location \\(([\\-]?\\d+\\.\\d+),([\\-]?\\d+\\.\\d+)\\)$")
    public void iApplyADistanceFilter(int distance, float lat, float lon) throws Throwable {
        request.param("filter", String.format("distance:%s:%s:%s", lat, lon, distance));
    }

    @When("^I make a request$")
    public void iMakeARequest() throws Throwable {
        ContentResponse response = request.send();
        dataResponse = gson.fromJson(response.getContentAsString(), DataResponse.class);
        results = dataResponse.getData();
    }

    @When("^I set the filter parameter to \"([^\"]*)\"$")
    public void iSetTheFilterParameterTo(String value) throws Throwable {
        request.param("filter", value);
    }

    @Then("^I receive (\\d+) result[s]?$")
    public void iReceiveResults(int number) throws Throwable {
        assertEquals(number, results.size());
    }

    @Then("^I receive the error message \"(.*)\"$")
    public void iReceiveTheErrorMessage(String message) throws Throwable {
        assertEquals(message, dataResponse.getMessage());
    }
}
