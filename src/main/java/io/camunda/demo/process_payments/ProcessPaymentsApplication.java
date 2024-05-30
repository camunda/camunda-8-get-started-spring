package io.camunda.demo.process_payments;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;

@SpringBootApplication
@Deployment(resources = "classpath:process-payments.bpmn")
public class ProcessPaymentsApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProcessPaymentsApplication.class);

	@Autowired
	private ZeebeClient zeebeClient;

	public static void main(String[] args) {
		SpringApplication.run(ProcessPaymentsApplication.class, args);
	}

	@Override
	public void run(final String... args) {
		var processDefinitionKey = "process-payments"; // or whatever the key is
		var event = zeebeClient.newCreateInstanceCommand()
				.bpmnProcessId(processDefinitionKey)
				.latestVersion()
				.variables(Map.of("total", 100))
				.send()
				.join();
		LOG.info(String.format("started a process: %d", event.getProcessInstanceKey()));
	}

}
