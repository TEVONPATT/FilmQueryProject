package com.skilldistillery.filmquery.entities;

public class Actor {
	private int actorID;
	private String actorFName;
	private String actorLName;
	
	public Actor() {}

	public int getActorID() {
		return actorID;
	}

	public void setActorID(int actorID) {
		this.actorID = actorID;
	}

	public String getActorFName() {
		return actorFName;
	}

	public void setActorFName(String actorFName) {
		this.actorFName = actorFName;
	}

	public String getActorLName() {
		return actorLName;
	}

	public void setActorLName(String actorLName) {
		this.actorLName = actorLName;
	}

	@Override
	public String toString() {
		return "Actor [actorID=" + actorID + ", actorFName=" + actorFName + ", actorLName=" + actorLName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorFName == null) ? 0 : actorFName.hashCode());
		result = prime * result + actorID;
		result = prime * result + ((actorLName == null) ? 0 : actorLName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (actorFName == null) {
			if (other.actorFName != null)
				return false;
		} else if (!actorFName.equals(other.actorFName))
			return false;
		if (actorID != other.actorID)
			return false;
		if (actorLName == null) {
			if (other.actorLName != null)
				return false;
		} else if (!actorLName.equals(other.actorLName))
			return false;
		return true;
	}

}
