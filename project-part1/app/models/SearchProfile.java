package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import models.ProfileInformation;
import java.util.List;


public class SearchProfile {

    private String input;
    //    @JsonProperty("projects")
    private List<ProfileInformation> profileInformation;

    public SearchProfile() {
        System.out.println("inside non para contsr.");
    }

//
//    public SearchResult( List<Projects> projects) {
//    	System.out.println("wedrf");
////        this.input = input;
//        this.projects = projects;
//    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }


    public List<ProfileInformation> getProfileInformation() {
        return profileInformation;
    }


    //    @JsonSetter("projects")
    public void setProfileInformation(List<ProfileInformation> profileInformation) {
        System.out.println("In set profiles");
        this.profileInformation = profileInformation;
    }
}
