# Get started with Camunda 8 and Spring Boot

This project demonstrates the use of Spring Boot and [the Spring Zeebe SDK](https://docs.camunda.io/docs/apis-tools/spring-zeebe-sdk/getting-started/#add-the-spring-zeebe-sdk-to-your-project) to interact with a local Self-Managed Camunda installation.

> [!WARNING]  
> Due to a bug in 8.6, use the Spring Zeebe SDK version `8.5.0`.

## Written guide

A guide for developing this project is available in the [Camunda docs][the-guide]. See that guide for step-by-step instructions and more detailed explanations.

## Interactions with Zeebe

Included in this project are examples of:

1. Deploying a process model.
2. Initiating a process instance.
3. Handling a service task.

## Prerequisites

1. A running Self-Managed Camunda installation (see [the associated guide][the-guide] for instructions).
2. [Maven](https://maven.apache.org/).
3. Version 17+ of a Java Development Kit (JDK).

## Running the project

1. Clone the repository.
2. Run the project:
   ```shell
   mvn spring-boot:run
   ```

You should see output indicating that a process has been deployed, a process instance has been started, and a service task has been handled.

## Troubleshooting

If the project fails to run, check the following:

1. The Camunda installation is running.
2. The Zeebe Broker is accessible at `localhost:8080`, and the Zeebe Gateway is accessible at `localhost:26500`, or adjust the `application.properties` file to match your configuration.

[the-guide]: https://docs.camunda.io/docs/guides/getting-started-java-spring
