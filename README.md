 # Gatekeeper

  Gatekeeper is a modular API gateway and management platform built with Java 21 and Spring Boot. It is organized as
  independent services for request routing, API management, and analytics.

  ## Services

   Service                   Port    Purpose
  ━━━━━━━━━━━━━━━━━━━━━━━━  ━━━━━━  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
   Smart Gateway Service     8080    Routes and forwards requests, with security and caching foundations.
  ────────────────────────  ──────  ──────────────────────────────────────────────────────────────────────
   API Management Service    8081    Manages API security configurations and routes.
  ────────────────────────  ──────  ──────────────────────────────────────────────────────────────────────
   Analytics Service         8082    Provides the foundation for collecting and analyzing API activity.

  Each service exposes a public health endpoint:

  GET /health

  Example response:

  ```json
  {
    "serviceName": "Smart Gateway Service",
    "serviceDescription": "Custom API gateway for routing, security and request forwarding",
    "appStatus": "UP"
  }

  ## Tech Stack

  - Java 21
  - Spring Boot 4
  - Spring Security
  - OAuth 2.0 Resource Server
  - Apache Kafka
  - Redis — Smart Gateway Service
  - MySQL and Spring Data JPA — API Management Service
  - MongoDB — Analytics Service
  - Maven Wrapper
  - Lombok

  ## Project Structure

  gatekeeper/
  ├── smart-gateway-service/     # Gateway, routing, security, and request forwarding
  ├── api-management-service/    # API configuration and management
  └── analytics-service/         # API analytics foundation

  ## Prerequisites

  - JDK 21 or newer
  - Docker or locally installed infrastructure services as needed:
      - Redis
      - Apache Kafka
      - MySQL
      - MongoDB

  ## Running Locally

  Run each service in a separate terminal.

  cd smart-gateway-service
  ./mvnw spring-boot:run

  cd api-management-service
  ./mvnw spring-boot:run

  cd analytics-service
  ./mvnw spring-boot:run

  On Windows, use mvnw.cmd instead of ./mvnw.

  ## Verify Services

  curl http://localhost:8080/health
  curl http://localhost:8081/health
  curl http://localhost:8082/health

  ## Testing

  Run tests from within any service directory:

  ./mvnw test

  ## Security

  The /health endpoint is publicly accessible. All other endpoints require authentication, providing a secure baseline
  for future API and management features.

  ## Status

  The project currently establishes the service architecture, health checks, and security baseline. Routing policies,
  API-management workflows, event-driven analytics, and infrastructure configuration are intended to evolve as the
  platform grows.

