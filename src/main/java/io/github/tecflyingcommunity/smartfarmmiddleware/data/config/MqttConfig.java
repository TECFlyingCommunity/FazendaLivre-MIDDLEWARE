package io.github.tecflyingcommunity.smartfarmmiddleware.data.config;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    private final MqttConnection mqttConnection;


    public MqttConfig(MqttConnection mqttConnection) {
        this.mqttConnection = mqttConnection;
    }

    @Bean
    public void getMqttConnection() throws MqttException {
        mqttConnection.connect();
    }
}
