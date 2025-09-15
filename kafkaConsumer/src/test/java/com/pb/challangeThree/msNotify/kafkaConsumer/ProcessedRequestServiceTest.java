package com.pb.challangeThree.msNotify.kafkaConsumer;

import com.pb.challangeThree.msNotify.kafkaConsumer.message.ProcessedRequest;
import com.pb.challangeThree.msNotify.kafkaConsumer.service.ProcessedRequestService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.Acknowledgment;

@SpringBootTest
public class ProcessedRequestServiceTest {

	@Autowired
	private ProcessedRequestService processedRequestService;

	@Test
	public void testRequestListener() {
		ProcessedRequest request = new ProcessedRequest("testUser", "CREATE");
		ConsumerRecord<String, ProcessedRequest> record = new ConsumerRecord<>("test_topic", 0, 0, "key", request);

		processedRequestService.requestListener(record, new Acknowledgment() {
			@Override
			public void acknowledge() {
			}
		});
	}
}