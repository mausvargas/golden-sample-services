# Store service

The store service is a product composite service that aggregates information from the core services and 
presents information about a product as follows: 
* Product information, as described in the *product* service 
* A list of product reviews for the specified product, as described in the *review* service 

#Getting Started
* [Extend and build](https://community.backbase.com/documentation/ServiceSDK/latest/extend_and_build)

## Dependencies

Requires a running Eureka registry, by default on port 8080.
Requires a running Product service, by default on port 9916.
Requires a running Review service, by default on port 9917.

## Configuration

Service configuration is under `src/main/resources/application.yml`.

## Running

To run the service in development mode, use:
- `mvn spring-boot:run`

To run the service from the built binaries, use:
- `java -jar target/product-1.0.0-SNAPSHOT.jar`

## Authorization

Requests to this service are authorized with a Backbase Internal JWT, therefore you must access this service via the 
Backbase Gateway after authenticating with the authentication service.

For local development, an internal JWT can be created from http://jwt.io, entering `JWTSecretKeyDontUseInProduction!` 
as the secret in the signature to generate a valid signed JWT.

## Community Documentation

Add links to documentation including setup, config, etc.

## Jira Project

Add link to Jira project.

## Confluence Links
Links to relevant confluence pages (design etc).

## Support

The official core-service support room is [#s-core-service](https://todo).
