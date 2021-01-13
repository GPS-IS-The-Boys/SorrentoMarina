    const CURRENT_LOCATION = document.getElementsByClassName('weather-content__overview')[0];
    const CURRENT_TEMP = document.getElementsByClassName('weather-content__temp')[0];
    const FORECAST = document.getElementsByClassName('component__forecast-box')[0];

    const URL = "https://api.openweathermap.org/data/2.5/onecall?lat=40.624763&lon=14.386349&units=metric&lang=it&exclude=hourly,minutely,current,alerts&appid=19dd6ef0c4c6cdbde1e8d1eda1a7ee51"


    function getWeatherData() {
    let headers = new Headers();

    return fetch(URL, {
    method: 'GET',
    headers: headers
}).then(data => {
    return data.json();
});
}

        getWeatherData().then(weatherData => {
            let city = "Sorrento";
            let dailyForecast = weatherData.daily;

            renderData(city, dailyForecast);
        });





    renderData = (location, forecast) => {
    const currentWeather = forecast[0].weather[0];
    const widgetHeader =
    `<h1>${location}</h1><small>${currentWeather.description}</small>`;

    var b= 'http://openweathermap.org/img/wn/' + currentWeather.icon + '@2x.png';
    var a= "<img src='" + b + "'>";
    CURRENT_TEMP.innerHTML =`${a} ${parseFloat(forecast[0].temp.day).toFixed(1)}\u00B0<i class="wi wi-degrees"></i>`;

    CURRENT_LOCATION.innerHTML = widgetHeader;

    // render each daily forecast
    forecast.forEach(day => {
    let date = new Date(day.dt * 1000);
    let days = ['Dom', 'Lun', 'Mar', 'Mer', 'Gio', 'Ven', 'Sab'];
    let name = days[date.getDay()];
    let dayBlock = document.createElement("div");
    dayBlock.className = 'forecast__item';
    var c= 'http://openweathermap.org/img/wn/' + day.weather[0].icon + '@2x.png';
    var d= "<img src='" + c + "'  width='50' height='50'>";
    dayBlock.innerHTML =
    `<div class="forecast-item__heading">${name}</div>
  <div class="forecast-item__info">
  ${d}
  <span class="degrees">${parseFloat(day.temp.day).toFixed(1)}\u00B0
  <i class="wi wi-degrees"></i></span></div>`;
    FORECAST.appendChild(dayBlock);
});
}
