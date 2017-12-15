package com.example.demo.connexion;

import java.util.ArrayList;

public interface IServiceEvent {

	public void create(Event event);
	
	public ArrayList<Event> readAll();
	
	//public Event readOneBy();
	
	//public void update(int event_id);
	
	public void delete(int event_id);
	
}
