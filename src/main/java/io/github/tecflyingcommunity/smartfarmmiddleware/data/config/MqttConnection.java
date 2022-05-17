package io.github.tecflyingcommunity.smartfarmmiddleware.data.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.tecflyingcommunity.smartfarmmiddleware.domain.dto.NewSensorDTO;
import io.github.tecflyingcommunity.smartfarmmiddleware.domain.usecases.RegisterSensor;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MqttConnection implements MqttCallback {

    private final RegisterSensor registerSensor;

    public MqttConnection(RegisterSensor registerSensor) {
        this.registerSensor = registerSensor;
    }

    @Value("${host.mqtt.clientId:SmartFarm-Middleware}")
    private String clientId;

    @Value("${host.mqtt.qos:2}")
    private int qos;

    @Value("${host.mqtt.topic:SENSORES}")
    private String topic;

    @Value("${host.mqtt.mqttHost}")
    private String mqttHost;

    @Value("${host.mqtt.mqttUser}")
    private String mqttUser;

    @Value("${host.mqtt.mqttPassword}")
    private String mqttPassword;


    public void connect() throws MqttException {

        MqttClient client = new MqttClient(mqttHost, clientId, new MemoryPersistence());

        final var options = new MqttConnectOptions();

        options.setUserName(mqttUser);
        options.setPassword(mqttPassword.toCharArray());

        client.setCallback(this);
        client.connect(options);
        client.subscribe(topic, qos);

    }

    @Override
    public void connectionLost(Throwable throwable) {
        try {
            connect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        final var mapper = new ObjectMapper();
        final NewSensorDTO newSensorDTO = mapper.readValue(mqttMessage.toString(), NewSensorDTO.class);
        registerSensor.save(newSensorDTO);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }
}
