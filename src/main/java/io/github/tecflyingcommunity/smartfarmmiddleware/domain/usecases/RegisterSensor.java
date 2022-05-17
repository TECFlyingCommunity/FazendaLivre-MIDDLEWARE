package io.github.tecflyingcommunity.smartfarmmiddleware.domain.usecases;

import io.github.tecflyingcommunity.smartfarmmiddleware.domain.dto.NewSensorDTO;
import io.github.tecflyingcommunity.smartfarmmiddleware.domain.entities.SensorEntity;
import io.github.tecflyingcommunity.smartfarmmiddleware.domain.repositories.SensorRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterSensor {

    private final SensorRepository sensorRepository;

    public RegisterSensor(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public SensorEntity save(NewSensorDTO newSensorDTO) {
        return sensorRepository.save(newSensorDTO);
    }

}
