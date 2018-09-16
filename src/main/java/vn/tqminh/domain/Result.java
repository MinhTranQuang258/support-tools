package vn.tqminh.domain;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	@JsonProperty("took")
	private int took;
	
	@JsonProperty("time_out")
	private boolean timeOut;
	
	@JsonProperty("hits")
	private Map<String, Object> hits;

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

	public Map<String, Object> getHits() {
		return hits;
	}

	public void setHits(Map<String, Object> hits) {
		this.hits = hits;
	}

}
