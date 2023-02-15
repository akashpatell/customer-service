# customer-service
Customer Service to Place Order to any Coffee Shop and Also get the status of that order

Prerequisite for this application to be run in your machine (one can modify/choose versions as per the need)
- RabbitMQ
- MySql Workbench
- Java 1.8 & apache-maven

Install RabbitMQ in windows :
-----------------------------
1. Download and install ERlang http://erlang.org/download/otp_win64_25.2.2.exe
2. Downlaod and install RabbitMQ https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.11.8/rabbitmq-server-3.11.8.exe
3. Go to RabbitMQ Server install Directory C:\Program Files\RabbitMQ Server\rabbitmq_server-3.11.8\sbin
4. Run command rabbitmq-plugins enable rabbitmq_management
5. Open browser and enter http://localhost:15672/ to redirect to RabbitMQ Dashboard
6. Also we can Open it with IP Address http://127.0.0.1:15672
7. Login page default username and password is guest 
8. After successfully login you should see RabbitMQ Home page

Steps to perform APIs-

1. Update Maven Project
2. Run mvn clean install
3. Run customer-service as SpringBootApplication
4. Download postman collection from /resources/static folder
5. List CoffeeShop API
6. Place Order API
7. take order_id from the response & check status from Get Order Status API