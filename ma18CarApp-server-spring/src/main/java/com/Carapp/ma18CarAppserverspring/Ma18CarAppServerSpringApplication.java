package com.Carapp.ma18CarAppserverspring;

import com.Carapp.ma18CarAppserverspring.Repositories.BookingRepo;
import com.Carapp.ma18CarAppserverspring.Repositories.CarRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Ma18CarAppServerSpringApplication {
	private List<Car> casr;
	private List<Booking> bookingArray;

	public static void main(String[] args) {
		SpringApplication.run(Ma18CarAppServerSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CarRepo carRepository, BookingRepo bookingRepo) {
		this.bookingArray = new ArrayList<>();

		return args -> {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream car = classloader.getResourceAsStream("JSON.JSON");
			InputStream booking = classloader.getResourceAsStream("bookings.JSON");
			BufferedReader CarbR = new BufferedReader(  new InputStreamReader(car));
			BufferedReader bookingbR = new BufferedReader(  new InputStreamReader(booking));

			String Carline = "";
			String Bookingline = "";

			StringBuilder responseStrBuilder = new StringBuilder();
			StringBuilder responseStrBuilder2 = new StringBuilder();
			while((Carline =  CarbR.readLine()) != null){
				responseStrBuilder.append(Carline);
			}
			while((Bookingline =  bookingbR.readLine()) != null){

				responseStrBuilder2.append(Bookingline);
			}

			car.close();
			booking.close();
			JSONArray resultCar= new JSONArray(responseStrBuilder.toString());
			JSONArray resultBooking= new JSONArray(responseStrBuilder2.toString());
			int myJsonArraySize = resultCar.length();
			int myJsonArraySizeBooking = resultBooking.length();

			for (int i = 0; i < myJsonArraySize; i++) {
				JSONObject object = (JSONObject) resultCar.get(i);

				com.Carapp.ma18CarAppserverspring.Car item = new com.Carapp.ma18CarAppserverspring.Car(object.getString("name"), object.getString("imageUrl"), object.getString("year"), object.getBoolean("hyrd"), object.getString("model"), object.getString("price"), object.getString("discription"));
				carRepository.save(item);


			}
			for (int i2 = 0; i2 < myJsonArraySizeBooking; i2++) {
				JSONObject objectbooking = (JSONObject) resultBooking.get(i2);
				Booking bookingItem = new Booking(objectbooking.getString("name"), objectbooking.getString("email"),objectbooking.getString("fron"),objectbooking.getString("till"),objectbooking.getString("price"),objectbooking.getString("bilId"));
				System.out.println(bookingItem.getName()+"NAMNET FRÅN BOOKING");
				bookingRepo.save(bookingItem);
			}


		};
	}
}
