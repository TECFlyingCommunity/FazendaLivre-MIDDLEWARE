package io.github.tecflyingcommunity.smartfarmmiddleware.domain.dto;


import io.github.tecflyingcommunity.smartfarmmiddleware.domain.entities.SensorEntity;

public record NewSensorDTO(
        Double temperature,

        Double luminosity,

        Double airHumidity,

        Double soilHumidity
) {
    public NewSensorDTO(Double temperature, Double luminosity, Double airHumidity, Double soilHumidity) {
        this.temperature = temperature;
        this.luminosity = luminosity;
        this.airHumidity = airHumidity;
        this.soilHumidity = soilHumidity;
    }

    public NewSensorDTO(SensorEntity entity) {

        this(
                entity.getTemperature(),
                entity.getLuminosity(),
                entity.getAirHumidity(),
                entity.getSoilHumidity()
        );
    }

    public SensorEntity toEntity() {
        final SensorEntity entity = new SensorEntity();
        entity.setTemperature(this.temperature);
        entity.setLuminosity(this.luminosity);
        entity.setAirHumidity(this.airHumidity);
        entity.setSoilHumidity(this.soilHumidity);
        return entity;
    }
}
