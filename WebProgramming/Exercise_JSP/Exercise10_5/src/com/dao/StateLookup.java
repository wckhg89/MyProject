package com.dao;

import java.util.HashMap;
import java.util.Map;

import com.vo.StatePair;

public class StateLookup {
	private Map<String, StatePair> states;
	
	public StateLookup(){
		states = new HashMap<String, StatePair>();
		addState(new StatePair("Alabama", "AL"));
		addState(new StatePair("Alaska", "AK"));
		addState(new StatePair("Arizona", "AZ"));
		addState(new StatePair("Arkansas", "AR"));
		addState(new StatePair("California", "CA"));
		addState(new StatePair("Connecticut", "CT"));
		addState(new StatePair("Delaware", "DE"));
		addState(new StatePair("Florida", "FL"));
		addState(new StatePair("Georgia", "GA"));
		addState(new StatePair("Hawaii", "HI"));
		addState(new StatePair("Idaho", "ID"));
		addState(new StatePair("Illinois", "IL"));
		addState(new StatePair("Indiana", "IN"));
		addState(new StatePair("Iowa", "IA"));
		addState(new StatePair("Kansas", "KS"));
		addState(new StatePair("Kentucky", "KY"));
		addState(new StatePair("Louisiana", "LA"));
		addState(new StatePair("Maryland", "MD"));
		addState(new StatePair("Massachusetts", "MA"));
		addState(new StatePair("Michigan", "MI"));
		addState(new StatePair("Minnesota", "MN"));
		addState(new StatePair("Mississippi", "MS"));
		addState(new StatePair("Missouri", "MO"));
		addState(new StatePair("Montana", "MT"));
		addState(new StatePair("Nebraska", "NE"));
		addState(new StatePair("Nevada", "NV"));
		addState(new StatePair("New Hampshire", "NH"));
		addState(new StatePair("New Jersey", "NJ"));
		addState(new StatePair("New Mexico", "NM"));
		addState(new StatePair("New York", "NY"));
		addState(new StatePair("North Carolina", "NC"));
		addState(new StatePair("North Dakota", "ND"));
		addState(new StatePair("Ohio", "OH"));
		addState(new StatePair("Oklahoma", "OK"));
		addState(new StatePair("Oregon", "OR"));
		addState(new StatePair("Pennsylvania", "PA"));
		addState(new StatePair("Rhode Island", "RI"));
		addState(new StatePair("South Carolina", "SC"));
		addState(new StatePair("South Dakota", "SD"));
		addState(new StatePair("Tennessee", "TN"));
		addState(new StatePair("Texas", "TX"));
		addState(new StatePair("Utah", "UT"));
		addState(new StatePair("Vermont", "VT"));
		addState(new StatePair("Virginia", "VA"));
		addState(new StatePair("Washington", "WA"));
		addState(new StatePair("West Virginia", "WV"));
		addState(new StatePair("Wisconsin", "WI"));
		addState(new StatePair("Wyoming", "WY"));	
	}
	
	public StatePair findState(String name){
		if(name != null){
			return(states.get(name));
		}
		return null;
	}
	
	public void addState(StatePair state){
		states.put(state.getStateName(), state);
	}
}
