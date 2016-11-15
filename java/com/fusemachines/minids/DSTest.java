package com.fusemachines.minids;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.tree.BackedList;
import org.h2.util.TempFileDeleter;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.fusemachines.minidsd.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DSTest {
	private static final String FILE_URI = "/var/www/html/api/user/3.json";
	private static final String DEVICE_ACTIAVATE_FILE_URI = "/var/www/html/api/user/1activate.json";
	private static final String BASE_URI = "http://localhost";
	private static final String USER_ENROLLMENT_POST_URI = BASE_URI + "/api/user/";
	private static final String USER_ENROLLMENT_GET_URI = BASE_URI + "/api/user/2.json";
	private static final String USER_ACTIVATION=BASE_URI+"/api/user?activate";
	private static final String SEND_TRIP_DATA=BASE_URI+"/api/trip/device/1";
	private RestTemplate template = new RestTemplate();

	@Test
	public void enrollUser() {

		User user = new User();
		user.setFirstName("pras");
		user.setLastName("rai");
		user.setEmail("prai@email.com");
		user.setPhoneNo("13212");

		// template.postForObject(USER_ENROLLMENT_POST_URI, user, User.class);
		try {
			makeFile(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void makeFile(User user) throws IOException {

		Writer writer = new FileWriter(FILE_URI);
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(user);
		User aUser = gson.fromJson(json, User.class);
		writer.write(json);
		writer.close();

	}

	// @Test
	// public void getUser() {
	//// User u = template.getForObject(USER_ENROLLMENT_GET_URI, User.class);
	//// System.out.println(":::::::" + u);
	// }
	
	public  void UserActivation(User user,Device device){
		UserDeviceDTO userdevicedto=new UserDeviceDTO();
		userdevicedto.setFirstName("prashanna");
		userdevicedto.setLastName("rai");
		userdevicedto.setPhoneNo("141");
		userdevicedto.setEmail("prashanna@email.com");
		userdevicedto.setId(1);
		userdevicedto.setDeviceIdentifier("1313");
		template.postForObject(USER_ACTIVATION, userdevicedto, UserDeviceDTO.class);
		makeFileForActivate(userdevicedto);
		
	}


	private void makeFileForActivate(UserDeviceDTO userdevicedto) {
		Writer writer;
		try {
			writer = new FileWriter(DEVICE_ACTIAVATE_FILE_URI);
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(userdevicedto);
			
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	private void sendTripData(){
		TripDataDTO tripdatadto=new TripDataDTO();
		tripdatadto.setDate(new Date(1993, 10, 24));
		List<Route> totalroute=new ArrayList<Route>();
		Route route1=new Route("","");
		Route route2=new  Route("", "");
		totalroute.add(route1);
		totalroute.add(route2);
		tripdatadto.setRoute(totalroute);
		template.postForObject(SEND_TRIP_DATA, tripdatadto,TripDataDTO.class);
		makeFileSendTripdata( tripdatadto);
		
	}


	private void makeFileSendTripdata(TripDataDTO tripdatadto) {
		Writer writer;
		try {
			writer = new FileWriter(DEVICE_ACTIAVATE_FILE_URI);
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(tripdatadto);
			
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
