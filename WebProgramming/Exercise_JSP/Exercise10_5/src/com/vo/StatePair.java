package com.vo;

public class StatePair {
	private String stateName;
	private String stateAbbreviation;
	
	public StatePair() {
		// TODO Auto-generated constructor stub
	}
	
	public StatePair(String stateName, String stateAbbreviation) {
		super();
		this.stateName = stateName;
		this.stateAbbreviation = stateAbbreviation;
	}

	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateAbbreviation() {
		return stateAbbreviation;
	}
	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}
	
	
}
