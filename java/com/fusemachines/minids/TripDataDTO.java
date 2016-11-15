package com.fusemachines.minids;

import java.util.Date;
import java.util.List;

public class TripDataDTO {
private List<Route> route;
private int deviceid;
private Date date;
public List<Route> getRoute() {
	return route;
}
public void setRoute(List<Route> route) {
	this.route = route;
}
public int getDeviceid() {
	return deviceid;
}
public void setDeviceid(int deviceid) {
	this.deviceid = deviceid;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

}
