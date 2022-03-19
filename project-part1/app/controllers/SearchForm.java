package controllers;

import play.data.validation.Constraints;


public class SearchForm {
    @Constraints.Required
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
