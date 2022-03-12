package controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import models.FreelancerClient;
import play.api.data.Form;
import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    private final FreelancerClient freelancer;
    private final Form<SearchForm> searchForm;
    public Result index() {
        return ok(views.html.index.render());
    }
    
    public CompletionStage<Result> search(Http.Request request) {
        Form<SearchForm> boundForm = searchForm.bindFromRequest(request);
        if (boundForm.hasErrors()) {
            return CompletableFuture.completedFuture(redirect(routes.HomeController.index()));
        } else {
            String searchInput = boundForm.get().getInput();
            String sessionId = request.session().get(SESSION_ID).orElseGet(() -> UUID.randomUUID().toString());
            return freelancer.searchRepositories(searchInput, false)
                    .thenAccept(searchResult -> searchHistory.addToHistory(sessionId, searchResult))
                    .thenApplyAsync(nullResult -> redirect(routes.SearchController.index())
                            .addingToSession(request, SESSION_ID, sessionId));
        }
    }

    
    public Result tutorial() {
        return ok(views.html.tutorial.render());
    }

}
