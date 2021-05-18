package com.workshop.hotel_reservation;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class HotelReservation {
	//declaring variables for respective hotels
	 private static Hotel lake, bridge, ridge;

	 public static void main(String[] args) throws IOException {
		System.out.println("Welcome To Hotel Reservation Program");
		
		//date pattern to be entered
		System.out.println("Enter date  ex. 16Mar2020(mon)");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String date = bf.readLine();

		
		//setting values for lakewood
	    lake = new Hotel("Lakewood");
	    lake.setRating(3);
	    lake.setRegularWeekDay(110);
	    lake.setRegularWeekEnd(90);
	    lake.setRewardedWeekDay(80);
 	    lake.setRewardedWeekEnd(80);
		 		
		//setting values for bridgewood
	    bridge = new Hotel("Bridgewood");
	    bridge.setRating(4);
	    bridge.setRegularWeekDay(150);
	    bridge.setRegularWeekEnd(50);
	    bridge.setRewardedWeekDay(110);
 	    bridge.setRewardedWeekEnd(50);
				
		//setting values for ridgewood   
	    ridge = new Hotel("Ridgewood");
	    ridge.setRating(5);
	    ridge.setRegularWeekDay(220);
	    ridge.setRegularWeekEnd(150);
	    ridge.setRewardedWeekDay(100);
 	    ridge.setRewardedWeekEnd(40);
		
		 //int index = date.indexOf(",");
	     //String type = date.substring(0, index);
	     int cost_lake = 0, cost_bridge = 0, cost_ridge = 0;
	     int day_index_start = 0, day_index_end = 0;
	     
	    while (day_index_start != -1) {
		     day_index_start = date.indexOf("(", day_index_start + 1);
		     day_index_end = date.indexOf(")", day_index_end + 1);
		
		     if (day_index_start != -1) {
			     String day = date.substring(day_index_start + 1, day_index_end);
		    	if (day.equalsIgnoreCase("sun") || day.equalsIgnoreCase("sat")) {
					     cost_lake += lake.getRegularWeekEnd();
					     cost_bridge += bridge.getRegularWeekEnd();
					     cost_ridge += ridge.getRegularWeekEnd();
				     
			     }
		     }
		     else {
		    	cost_lake += lake.getRegularWeekDay();
		    	cost_bridge += bridge.getRegularWeekDay();
		    	cost_ridge += ridge.getRegularWeekDay();
		     }
		 }  
	    //printing cost of each hotel
	     System.out.println("\nLakewood : "+cost_lake+"$");
	     System.out.println("Bridgewood : "+cost_bridge+"$");
	     System.out.println("Ridgewood : "+cost_ridge+"$");
	
	     //printing the hotel with cheapest price
	     String result = min(cost_lake, cost_bridge, cost_ridge);
	   //  int result1 = minrating(cost_lake, cost_bridge, cost_ridge);
	     int result2=totalPrice(cost_lake, cost_bridge, cost_ridge);
	     System.out.println("Best Rated Hotel is "+result+" , Total :"+totalPrice(cost_lake, cost_bridge, cost_ridge));
	     
    	}
    	
	 //method to find total price for hotel
     private static int totalPrice(int a, int b, int c) {
	   if(a < c && a < c) {
			return a;
		}else if(b<a && b < c) {
			return b;
		}
		else {
			return b;
		}
	}

    //implementing the min method to find best rated hotel
     public static  String min(int a, int b, int c) {
 		if(a < c && a < b) {
 			return (ridge.getHotelName());
 		}else if(b<a && b < c) {
 			return (ridge.getHotelName());
 		}
 		else {
 			return (ridge.getHotelName());
 		}
 	}
     
}