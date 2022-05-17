package io.github.tecflyingcommunity.smartfarmmiddleware.data.repositories;


import io.github.tecflyingcommunity.smartfarmmiddleware.data.datasources.SensorDataSource;
import io.github.tecflyingcommunity.smartfarmmiddleware.domain.dto.NewSensorDTO;
import io.github.tecflyingcommunity.smartfarmmiddleware.domain.entities.SensorEntity;
import io.github.tecflyingcommunity.smartfarmmiddleware.domain.repositories.SensorRepository;
import org.springframework.stereotype.Component;

@Component
public class SensorRepositoryImpl implements SensorRepository {

    private final SensorDataSource sensorDataSource;

    public SensorRepositoryImpl(SensorDataSource sensorDataSource) {
        this.sensorDataSource = sensorDataSource;
    }

    @Override
    public SensorEntity save(NewSensorDTO newSensorDTO) {
        return sensorDataSource.save(newSensorDTO.toEntity());
    }

}
