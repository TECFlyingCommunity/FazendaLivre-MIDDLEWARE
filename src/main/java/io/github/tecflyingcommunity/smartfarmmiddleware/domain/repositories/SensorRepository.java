package io.github.tecflyingcommunity.smartfarmmiddleware.domain.repositories;

import io.github.tecflyingcommunity.smartfarmmiddleware.domain.dto.NewSensorDTO;
import io.github.tecflyingcommunity.smartfarmmiddleware.domain.dto.SensorDTO;
import io.github.tecflyingcommunity.smartfarmmiddleware.domain.entities.SensorEntity;

import java.util.List;
import java.util.Optional;

public interface SensorRepository {
    SensorEntity save(NewSensorDTO newSensorDTO);
}
