package com.act3;
import java.util.*;
import java.util.Optional;

public class Horse{


	private ArrayList<Integer> distBreakdown = new ArrayList<Integer>();
	private String horseName;
	private Optional<String> warCry = Optional.empty();
	private boolean healthy;
	private int speed;
	private int distanceTravelled = 0;
	private int distRemain;


	public Horse(){

	}

	public ArrayList<Integer> getDistBreakDown(){
		return distBreakdown;
	}

	public String getName(){
		return horseName;
	}

	public Optional<String> getWarCry(){
		return warCry;
	}

	public boolean isHealthy(){

		return healthy;
	}

	public int getSpeed(){
		return speed;
	}

	public int getDistRemain(){
		return distRemain;
	}

	public int getDistanceTravelled(){
		return distanceTravelled;
	}

	public void addDistBreakDown(int currSpeed){
		distBreakdown.add(currSpeed);
	}

	public void setName(String name){
		horseName = name;
	}

	public void setSpeed(int newSpeed){
		this.speed = newSpeed;
	}

	public void setDistanceTravelled(int newDist){
		distanceTravelled = newDist;
	}

	public void setDistRemain(int newRemain){
		distRemain = newRemain;
	}
	public void setHealth(boolean newHealth)
	{
		healthy = newHealth;
	}

	public void setWarCry(Optional<String> newCry){
		warCry = newCry;
	}



}
