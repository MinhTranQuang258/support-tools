package vn.tqminh.domain;

import java.util.List;
import java.util.Map;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	@JsonProperty("took")
	private int took;
	
	@JsonProperty("time_out")
	private boolean timeOut;
	
	@JsonProperty("hits")
	private Map<String, List<Hit>> hits;

	public int getTook() {
		return took;
	}

	public void setTook(int took) {
		this.took = took;
	}

	public boolean isTimeOut() {
		return timeOut;
	}

	public void setTimeOut(boolean timeOut) {
		this.timeOut = timeOut;
	}

	public Map<String, List<Hit>> getHits() {
		return hits;
	}

	public void setHits(Map<String, List<Hit>> hits) {
		this.hits = hits;
	}
}
