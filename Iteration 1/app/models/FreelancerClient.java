package models;

import java.util.concurrent.CompletionStage;

import javax.naming.directory.SearchResult;

import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.typesafe.config.Config;

public class FreelancerClient {
//	private final WSClient client;
    /** The String baseURL */
    private final String baseURL;
    /** The authorization Github token */
//    private final String token;

//    private final AsyncCacheApi cache;
    /** The constructor
     * @author Hop Nguyen
     */
//    @Inject
    public FreelancerClient() {
//        this.client = client;
//        this.cache = cache;
        this.baseURL = config.getString("freelancer.url");
    }

       
    /**
     * Username is used to return an arraylist of repositories owned by the user
     * 
     * @author Joon Seung Hwang
     * @param user github username
     * @return ArrayList containing list of user's repositories
     */
    public CompletionStage<List<String>> getAllRepoList(String user) {
    	WSRequest request = client.url(baseURL + "/projects/0.1/projectsactive/query=" + user );
        return request
                .addHeader("Accept", "application/vnd.github.v3+json")
                .get()
                .thenApply(r -> {
                        List<String> repoList = new ArrayList<>();
                        String name = "name";
                        int f = 0;
                        while (r.asJson().get(f) != null) {
                            repoList.add(r.asJson().get(f).get(name).asText());
                            f++;
                        }
                        return repoList;
                });
    }

}
