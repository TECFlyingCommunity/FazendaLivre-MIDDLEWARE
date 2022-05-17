package io.github.tecflyingcommunity.smartfarmmiddleware.data.datasources;


import io.github.tecflyingcommunity.smartfarmmiddleware.domain.entities.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataSource extends JpaRepository<SensorEntity, Long> {
}
