package service;

import model.Pokemon;
import model.TypeEnum;
import model.WeatherTypeEnum;

import java.util.List;
import java.util.Random;


public class WeatherService {

    // hava durumunu her turda random olarak değiştiren metot.
    public WeatherTypeEnum getWeatherRandomly() {
        List<WeatherTypeEnum> VALUES = List.of(WeatherTypeEnum.values());
        int SIZE = VALUES.size();
        Random RANDOM = new Random();

        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
