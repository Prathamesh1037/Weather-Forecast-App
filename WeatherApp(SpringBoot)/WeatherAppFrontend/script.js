const API_URL = 'http://localhost:8080/weather/forecast';

const elements = {
    cityInput: document.getElementById('cityInput'),
    daysInput: document.getElementById('daysInput'),
    searchBtn: document.getElementById('searchBtn'),
    errorMessage: document.getElementById('errorMessage'),
    currentWeather: document.getElementById('currentWeather'),
    cityName: document.getElementById('cityName'),
    regionCountry: document.getElementById('regionCountry'),
    currentTemp: document.getElementById('currentTemp'),
    weatherCondition: document.getElementById('weatherCondition'),
    weatherIcon: document.getElementById('weatherIcon'),
    forecast: document.getElementById('forecast'),
    forecastTitle: document.getElementById('forecastTitle'),
    forecastCards: document.getElementById('forecastCards')
};

const weatherIcons = {
    'Sunny': '☀️',
    'Clear': '🌙',
    'Partly cloudy': '⛅',
    'Cloudy': '☁️',
    'Overcast': '☁️',
    'Mist': '🌫️',
    'Fog': '🌫️',
    'Rain': '🌧️',
    'Light rain': '🌦️',
    'Heavy rain': '⛈️',
    'Snow': '❄️',
    'Thunderstorm': '⛈️',
    'Drizzle': '🌦️'
};

function getWeatherIcon(condition) {
    for (let key in weatherIcons) {
        if (condition.toLowerCase().includes(key.toLowerCase())) {
            return weatherIcons[key];
        }
    }
    return '🌡️';
}

function formatDate(dateString) {
    const date = new Date(dateString);
    const options = { month: 'short', day: 'numeric', year: 'numeric' };
    return date.toLocaleDateString('en-US', options);
}

function showError(message) {
    elements.errorMessage.textContent = message;
    elements.errorMessage.classList.add('show');
    elements.currentWeather.classList.remove('show');
    elements.forecast.classList.remove('show');
}

function hideError() {
    elements.errorMessage.classList.remove('show');
}

function displayWeather(data, days) {
    hideError();
    
    const { weatherApi, daytemp } = data;
    
    elements.cityName.textContent = weatherApi.city;
    elements.regionCountry.textContent = `${weatherApi.region}, ${weatherApi.country}`;
    elements.currentTemp.textContent = weatherApi.temperature.toFixed(1);
    elements.weatherCondition.textContent = weatherApi.condition;
    elements.weatherIcon.textContent = getWeatherIcon(weatherApi.condition);
    
    elements.currentWeather.classList.add('show');
    
    elements.forecastTitle.textContent = `${days}-Day Forecast`;
    
    elements.forecastCards.innerHTML = '';
    
    daytemp.forEach(day => {
        const card = document.createElement('div');
        card.className = 'forecast-card';
        
        card.innerHTML = `
            <div class="forecast-date">${formatDate(day.localdate)}</div>
            <div class="forecast-temps">
                <div class="temp-row">
                    <span class="temp-label">Max:</span>
                    <span class="temp-value-small">${day.max_temp.toFixed(1)}°C</span>
                </div>
                <div class="temp-row">
                    <span class="temp-label">Avg:</span>
                    <span class="temp-value-small">${day.avg_temp.toFixed(1)}°C</span>
                </div>
                <div class="temp-row">
                    <span class="temp-label">Min:</span>
                    <span class="temp-value-small">${day.min_temp.toFixed(1)}°C</span>
                </div>
            </div>
        `;
        
        elements.forecastCards.appendChild(card);
    });
    
    elements.forecast.classList.add('show');
}

async function fetchWeather(city, days) {
    try {
        const response = await fetch(`${API_URL}?city=${encodeURIComponent(city)}&days=${days}`);
        
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        
        const data = await response.json();
        displayWeather(data, days);
    } catch (error) {
        showError(`Failed to fetch weather data. Please check if the API is running and try again.`);
        console.error('Error fetching weather:', error);
    }
}

function handleSearch() {
    const city = elements.cityInput.value.trim();
    const days = parseInt(elements.daysInput.value);
    
    if (!city) {
        showError('Please enter a city name');
        return;
    }
    
    if (!days || days < 1 || days > 7) {
        showError('Please enter a valid number of days (1-7)');
        return;
    }
    
    fetchWeather(city, days);
}

elements.searchBtn.addEventListener('click', handleSearch);

elements.cityInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') {
        handleSearch();
    }
});

elements.daysInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') {
        handleSearch();
    }
});

elements.cityInput.value = 'Mumbai';
elements.daysInput.value = '3';
fetchWeather('Mumbai', 3);