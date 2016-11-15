package com.fusemachines.minids;

public class Route {
private String longitute,latitude;

public Route(String longitute, String latitude) {
	super();
	this.longitute = longitute;
	this.latitude = latitude;
}

public String getLongitute() {
	return longitute;
}

public void setLongitute(String longitute) {
	this.longitute = longitute;
}

public String getLatitude() {
	return latitude;
}

public void setLatitude(String latitude) {
	this.latitude = latitude;
}

}
