package models;

import java.util.*;
import java.util.concurrent.CompletionStage;

import com.google.gson.*;
import play.libs.Json;

import play.libs.ws.WSBodyReadables.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
//import org.fasterxml.jackson.annotate.JsonAutoDetect.Visibility;
//import org.fasterxml.jackson.annotate.JsonMethod;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import play.cache.AsyncCacheApi;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class FreelancerClient {
    private final WSClient client;
    /**
     * The String baseURL
     */
    private final String baseURL;

    private final AsyncCacheApi cache;

    @Inject
    public FreelancerClient(WSClient client, AsyncCacheApi cache, Config config) {
        this.client = client;
        this.cache = cache;
        this.baseURL = config.getString("freelancer.url");
    }

    public CompletionStage<SearchResult> searchRepositories(String query) throws JsonGenerationException, JsonMappingException {
//    	https://www.freelancer.com/api/projects/0.1/projects/active/?query=
        String freelancerQuery = query;
        return cache.getOrElseUpdate("search://" + freelancerQuery, () -> {
            WSRequest req = client.url(baseURL + "/projects/0.1/projects/active");
//			System.out.println(Json.fromJson((req.addQueryParameter("query", freelancerQuery).get()).asJson(), SearchResult.class));
            return req
                    .addHeader("freelancelotESAPP", "UzhSBUrlZiSK4o8yQ8CA8ZyJ36VRvh")
                    .addQueryParameter("query", freelancerQuery)
                    .addQueryParameter("compact", "false")
                    .addQueryParameter("job_details", "true")
                    .addQueryParameter("limit", "10")
                    .get()
                    .thenApplyAsync(WSResponse::asJson)
                    .thenApplyAsync(r -> {
                        ArrayList<Projects> projectsList = new ArrayList<>();
//                        System.out.println("r is here" + r);
                        int f = 0;
                        while (r.get("result").get("projects").get(f) != null) {
//                            System.out.println("new job " +  r.get("result").get("projects").get(f).get("jobs").asText().getClass().getSimpleName());
                            Projects project = new Projects();
                            JsonNode skills = r.get("result").get("projects").get(f).get("jobs");
                            ;
                            HashMap<String, Integer> skillsData = new HashMap<>();
                            for (int i = 0; i < skills.size(); i++) {
                                int id = skills.get(i).get("id").asInt();
                                String skillName = skills.get(i).get("name").asText();
                                if (skillsData.containsKey(id)) {
                                    continue;
                                } else {
                                    skillsData.put(skillName, id);
                                }

                            }
                            project.setSkills(skillsData);
                            project.setOwner(r.get("result").get("projects").get(f).get("owner_id").asText());
                            project.setTitle(r.get("result").get("projects").get(f).get("title").asText());
                            project.setType(r.get("result").get("projects").get(f).get("type").asText());
                            project.setPrevDesc(r.get("result").get("projects").get(f).get("preview_description").asText());

                            Date date = new Date(r.get("result").get("projects").get(f).get("submitdate").asLong() * 1_000L);
                            DateFormat simple = new SimpleDateFormat("MMM dd yyyy");
                            project.setDate(simple.format(date));
                            project.setSeo_url(r.get("result").get("projects").get(f).get("seo_url").asText());
                            project.setType(r.get("result").get("projects").get(f).get("type").asText());
                            projectsList.add(project);
                            f++;
                        }
                        SearchResult searchResult = new SearchResult();
                        searchResult.setInput(query);
                        searchResult.setProjects(projectsList);
                        return searchResult;
                    });
        }, 4000);
    }

}







