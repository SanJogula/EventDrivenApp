# Event Driven App

This is a basic event-driven application developed using Java, Spring Boot, and Maven. It leverages the AxonIQ framework to implement an event-driven architecture.

## Components

The application is structured around a series of components:

1. `ProductQueryController`: A REST controller that handles HTTP GET requests at the `/products` endpoint. It uses a `QueryGateway` to execute a `GetProductsQuery` and retrieve a list of `ProductRestModel` objects.

2. `GetProductsQuery`: A simple query object used to fetch all products. It doesn't contain any data or behavior.

3. `Product`: A data entity representing a product. It includes fields for product ID, name, price, and quantity. It uses the Lombok library for automatic getter/setter generation and the Jakarta Persistence API for ORM.

## Architecture

The application follows the principles of an event-driven architecture, where events (changes in state) trigger communication between decoupled services. This architecture is common in modern applications built with microservices. In this context, an event could be a change in the state of a `Product` (like a change in quantity), which would then trigger other parts of the application to react (like updating a product listing).
Basic event driven app using AxonIQ
