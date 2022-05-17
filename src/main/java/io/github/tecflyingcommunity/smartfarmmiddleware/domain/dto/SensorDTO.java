package io.github.tecflyingcommunity.smartfarmmiddleware.domain.dto;


import io.github.tecflyingcommunity.smartfarmmiddleware.domain.entities.SensorEntity;

import java.time.LocalDateTime;

public record SensorDTO(
        Long id,

        Double temperature,

        Double luminosity,

        Double airHumidity,

        Double soilHumidity,

        LocalDateTime createdAt
) {

    public SensorDTO(SensorEntity entity) {
        this(
                entity.getId(),
                entity.getTemperature(),
                entity.getLuminosity(),
                entity.getAirHumidity(),
                entity.getSoilHumidity(),
                entity.getCreatedAt()
        );
    }

    public SensorEntity toEntity() {
        final SensorEntity entity = new SensorEntity();
        entity.setId(this.id);
        entity.setTemperature(this.temperature);
        entity.setLuminosity(this.luminosity);
        entity.setAirHumidity(this.airHumidity);
        entity.setSoilHumidity(this.soilHumidity);
        entity.setCreatedAt(this.createdAt);
        return entity;
    }
}
