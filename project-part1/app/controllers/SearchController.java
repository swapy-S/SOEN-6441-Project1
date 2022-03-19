package controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import com.google.inject.Inject;

import models.FreelancerClient;
import models.SearchHistory;
import models.SearchResult;

import play.i18n.MessagesApi;
import play.api.data.Form;
import play.api.cache.AsyncCacheApi;
import play.data.FormFactory;
import play.mvc.*;
import java.util.Map;
import java.util.List;
import java.util.UUID;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class SearchController extends Controller {

        public static final String SESSION_ID = "session_id";

        private final FreelancerClient freelancer;
        private final play.data.Form<SearchForm> searchForm;
        private final MessagesApi messagesApi;
        private final SearchHistory searchHistory;

        private AsyncCacheApi cache;

        @Inject
        public SearchController(FreelancerClient freelancer, FormFactory formFactory, MessagesApi messagesApi, AsyncCacheApi asyncCacheApi) {
            this.freelancer = freelancer;
            this.searchForm = formFactory.form(SearchForm.class);
            this.messagesApi = messagesApi;
            this.searchHistory = new SearchHistory();
            this.cache = asyncCacheApi;

        }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public CompletionStage<Result> index(Http.Request request) {

        String sessionId = request.session().get(SESSION_ID).orElseGet(() -> UUID.randomUUID().toString());
        List<SearchResult> searchResults = searchHistory.getHistory(sessionId);
        return CompletableFuture.completedFuture(
                ok(views.html.index.render(searchResults, searchForm, request, messagesApi.preferred(request)))
                        .addingToSession(request, SESSION_ID, sessionId));
    }

    public CompletionStage<Result> search(Http.Request request) {
        play.data.Form<SearchForm> boundForm = searchForm.bindFromRequest(request);
        if (boundForm.hasErrors()) {
            return CompletableFuture.completedFuture(redirect(routes.SearchController.index()));
        } else {
            String searchInput = boundForm.get().getInput();
            String sessionId = request.session().get(SESSION_ID).orElseGet(() -> UUID.randomUUID().toString());
            try{
                return freelancer.searchRepositories(searchInput)
                        .thenAccept(searchResult -> searchHistory.addToHistory(sessionId, searchResult))
                        .thenApplyAsync(nullResult -> redirect(routes.SearchController.index())
                                .addingToSession(request, SESSION_ID, sessionId));
            }catch (Exception e){
                e.printStackTrace();
            }
            return CompletableFuture.completedFuture(redirect(routes.SearchController.index()));
        }
    }


}
