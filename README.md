# BasicAuthoriaztionAPI
A simple application written using the Spring framework. 
It uses basic user authentication with Spring Security. 
In the application we have three groups of users: Admin, Moderator and User. 
Depending on the assigned role, the user can use different Rest methods. The application uses the built-in H2 database.
In addition, the RabbitMQ Broker was used, which, after adding a customer, informs the workshop about a new request.
