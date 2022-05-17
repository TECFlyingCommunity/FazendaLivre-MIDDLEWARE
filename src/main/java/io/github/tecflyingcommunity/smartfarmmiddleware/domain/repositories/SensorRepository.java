package io.github.tecflyingcommunity.smartfarmmiddleware.domain.repositories;

import io.github.tecflyingcommunity.smartfarmmiddleware.domain.dto.NewSensorDTO;
import io.github.tecflyingcommunity.smartfarmmiddleware.domain.entities.SensorEntity;

public interface SensorRepository {
    SensorEntity save(NewSensorDTO newSensorDTO);
}
