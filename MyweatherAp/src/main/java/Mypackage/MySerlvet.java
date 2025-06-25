package Mypackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonObject;



/**
 * Servlet implementation class MySerlvet
 */
@WebServlet("/MySerlvet")
public class MySerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "serial", "deprecation" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String apiKey = "b6953c1977dee9388136fcf89f1631dc";
	        String city = request.getParameter("city");
	        StringBuilder responseContent = new StringBuilder();
	        
	        try {
	            // 1. URL encode the city name
	            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8.toString());
	            
	            // 2. Build the API URL (no spaces before parameters)
	            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + 
	                          encodedCity + "&appid=" + apiKey;
	            
	            // 3. Create and configure the connection
	            URL url = new URL(apiUrl);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            
	            // 4. Get the response code
	            int responseCode = connection.getResponseCode();
	            
	            // 5. Read the response content
	            try (InputStream inputStream = connection.getInputStream();
	                 Scanner scanner = new Scanner(inputStream)) {
	                
	                while (scanner.hasNext()) {
	                    responseContent.append(scanner.nextLine());
	                }
	            }
	            
	            // 6. Print the response content (for debugging)
	            System.out.println("API Response: " + responseContent.toString());
	            
	        } catch (Exception e) {
	            // Handle any errors
	            System.err.println("Error fetching weather data: " + e.getMessage());
	            responseContent.append("Error: ").append(e.getMessage());
	        }
	        Gson gson = new Gson();
	        JsonObject jsonObject = gson.fromJson (responseContent.toString(),JsonObject.class);
	        System.out.println(jsonObject);
	        
	        //Date & Time
            long dateTimestamp = jsonObject.get("dt").getAsLong() * 1000;
            String date = new Date(dateTimestamp).toString();
            
            //Temperature
            double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
            int temperatureCelsius = (int) (temperatureKelvin - 273.15);
           
            //Humidity
            int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
            
            //Wind Speed
            double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
            
            //Weather Condition
            String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
            
            request.setAttribute("date", date);
            request.setAttribute("city", city);
            request.setAttribute("temperature", temperatureCelsius);
            request.setAttribute("weatherCondition", weatherCondition); 
            request.setAttribute("humidity", humidity);    
            request.setAttribute("windSpeed", windSpeed);
            request.setAttribute("weatherData", responseContent.toString());
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
	    }
	}
		
		
		
		
		
		
		
	

