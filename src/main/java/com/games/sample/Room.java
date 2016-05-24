package com.games.sample;

import java.util.ArrayList;

public class Room {

	private String turnTeam;
	private String roomID;
	private ArrayList<String> hunterList;
	private ArrayList<String> runnerList;

	public Room() {
	}

	public String getTurnTeam() {
		return turnTeam;
	}

	public void setTurnTeam(String turnTeam) {
		this.turnTeam = turnTeam;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public ArrayList<String> getHunterList() {
		return hunterList;
	}

	public void setHunterList(ArrayList<String> hunterList) {
		this.hunterList = hunterList;
	}

	public ArrayList<String> getRunnerList() {
		return runnerList;
	}

	public void setRunnerList(ArrayList<String> runnerList) {
		this.runnerList = runnerList;
	}

	@Override
	public String toString() {
		return "Room [turnTeam=" + turnTeam + ", roomID=" + roomID + ", hunterList=" + hunterList + ", runnerList="
				+ runnerList + "]";
	}

}
