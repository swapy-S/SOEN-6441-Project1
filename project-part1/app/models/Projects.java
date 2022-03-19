package models;

/**
 * Hold a project consisting of title, owner, preview description, date, type, seo_url and skills.
 * @author Stallone Mecwan
 * @version 1: Stallone Mecwan implements the project framework, search, and topic feature.
 * The Project class to hold the content of a project
 */
import java.util.*;

public class Projects{

    public String owner;

    public String title;

    public String prev_description;

    public String date;

    public String type;
    public String seo_url;

    public HashMap<String,Integer> skills;

    /**
     * The empty constructor for json
     * @author Stallone Mecwan
     */
    public Projects(){

    }
    /**
     * The getter of Owner
     *
     * @author Stallone Mecwan
     */
    public String getOwner() {
        return owner;
    }
    /**
     * The getter of Seo_url
     *
     * @author Stallone Mecwan
     */
    public String getSeo_url(){
        return seo_url;
    }
    /**
     * The setter of Seo_url
     *
     * @author Stallone Mecwan
     */
    public void setSeo_url(String seo_url){this.seo_url = seo_url; }

    /**
     * The setter of Skills
     *
     * @author Stallone Mecwan
     */
    public void setSkills(HashMap<String,Integer> skills){

        this.skills = skills;
    }

    /**
     * The setter of  Owner
     *
     * @author Stallone Mecwan
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * The getter of Date
     *
     * @author Stallone Mecwan
     */
    public String getDate() {
        return date;
    }

    /**
     * The setter of Date
     *
     * @author Stallone Mecwan
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * The getter of Title
     *
     * @author Stallone Mecwan
     */
    public String getTitle() {
        return title;
    }

    /**
     * The setter of Title
     *
     * @author Stallone Mecwan
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * The getter of Type
     *
     * @author Stallone Mecwan
     */
    public String getType() {
        return type;
    }

    /**
     * The setter of Type
     *
     * @author Stallone Mecwan
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The getter of Skills
     *
     * @author Stallone Mecwan
     */
    public HashMap<String,Integer> getSkills() {
        return skills;
    }

    /**
     * The setter of Preview Description
     *
     * @author Stallone Mecwan
     */
    public void setPrevDesc(String prevDesc) {
        this.prev_description = prevDesc;
    }

    /**
     * The getter of Preview Description
     *
     * @author Stallone Mecwan
     */
    public String getPrevDesc() {
        return prev_description;
    }


}