package models;

import java.util.LinkedHashMap;
import java.util.Map;

public class GlobalStats {
	Map<String, Integer> sortedWordCounter = new LinkedHashMap<>();

	public Map<String, Integer> getSortedWordCounter() {
		return sortedWordCounter;
	}

	public void setSortedWordCounter(Map<String, Integer> sortedWordCounter) {
		this.sortedWordCounter = sortedWordCounter;
	}
    
	

}