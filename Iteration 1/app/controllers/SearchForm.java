package controllers;

import play.data.validation.Constraints;

/**
 * @author Stallone Mecwan
 * @version 1: Stallone Mecwan implements search box.
 *
 * Holds an input text for the search box
 */
public class SearchForm {
    @Constraints.Required
    private String input;

    /**
     * The getter of input
     * @author Hop Nguyen
     */
    public String getInput() {
        return input;
    }

    /**
     * The setter of input
     * @author Hop Nguyen
     */
    public void setInput(String input) {
        this.input = input;
    }
}
