# Weatherapp
## **🌦️ WeatherApp - Get Real-Time Weather Updates! 🌍**


WeatherApp is a lightweight Spring Boot application that fetches real-time weather data for any city using the OpenWeather API. Just enter a city name, and get details like temperature, humidity, wind speed, and more!


## **🌟 How It Works**

User Input:    Enter the name of the city you want weather details for. 🏙️

Geocoding API Call:    The app first fetches the latitude and longitude of the city using the Geocoding API. 📍

Weather API Call:     Using the coordinates, the app retrieves the weather details from OpenWeather API. ⛅

Response:     The weather data is structured into a clean JSON response, providing all necessary details like temperature,                pressure, wind speed, and more! 

## **Running:**


Before running the service, you need do the following configurations in application.properties

### Set Up API Keys

Get an API key from OpenWeather
Get an API key from a geocoding provider

api.key= your_openweather_api_key

geocoding.url= https://api.openweathermap.org/geo/1.0/direct

weather.url=https://api.openweathermap.org/data/2.5/weather

### Build & Run the Project:

mvn clean install

mvn spring-boot:run







