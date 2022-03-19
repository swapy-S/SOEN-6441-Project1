package models;
/**
        * @author Stallone Mecwan
        * @version 1: Stallone Mecwan implements the project framework, search, and topic feature.
        * The SearchResult class to hold the search results from GitHub
 */
import models.Projects;
import java.util.List;
public class SearchResult {

        private String input;
        private List<Projects> projects;

        /**
        * The empty constructor for Json
        *
        * @author Stallone Mecwan
        */
        public SearchResult() {

        }

        /**
         * Returns the input query
         *
         * @return the input query
         * @author Stallone Mecwan
         */
        public String getInput() {
            return input;
        }

        /**
         * Set the input query
         *
         * @param input input query
         * @author Stallone Mecwan
         */
        public void setInput(String input) {
            this.input = input;
        }

        /**
         * Return the list of projects
         *
         * @return the projects list
         * @author Stallone Mecwan
         */
        public List<Projects> getProjects() {
            return projects;
        }

        /**
         * Set the projects list
         *
         * @param projects the repositories list
         * @author Stallone Mecwan
         */
        public void setProjects(List<Projects> projects) {
            System.out.println("In set repositories");
            this.projects = projects;
        }
}


