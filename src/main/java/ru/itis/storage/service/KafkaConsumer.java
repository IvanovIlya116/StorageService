package ru.itis.storage.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.itis.storage.model.PersonEntity;
import ru.itis.storage.service.PersonService;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ObjectMapper objectMapper;
    private final PersonService personService;
    private final NotificationProducer notificationProducer;

    @KafkaListener(topics = "processed_data", groupId = "storage-group")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            PersonEntity person = objectMapper.readValue(record.value(), PersonEntity.class);
            personService.savePerson(person);
            System.out.println("✅ Сохранено в БД: " + person);
            notificationProducer.sendNotification("✅ StorageService: обработка прошла успешно");
        } catch (Exception e) {
            notificationProducer.sendNotification("❌ StorageService: ошибка обработки — " + e.getMessage());
            System.err.println("❌ Ошибка при обработке сообщения: " + e.getMessage());
        }
    }
}