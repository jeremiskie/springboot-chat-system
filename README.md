# Springboot Chat System

--- 

## Quick Start Guide


#### List of Dependencies
- Spring Web
- Spring Data Jpa
- Lombok
- Validation
- Postgres
- Spring Dev Tools


--- 
## How to run project

##### Step 1: Clone the project or download via zip
if you prefer download via zip file, you need to extract
but if you prefer cloning project do this 
```
cd Desktop
git clone https://github.com/jeremiskie/springboot-chat-system.git
```

##### Step 2: Setup your application.properties inside of src folder
```
src/main/resources/application.properties
```

##### Step 3: Put these code
```
spring.application.name=spring-messaging-backend
spring.datasource.url=jdbc:postgresql://localhost:5432/basic_messaging
spring.datasource.username=postgres
spring.datasource.password=YOUR PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

##### Step 4: Go to postgres desktop or pgAdmin 4 and create database and name it
```
basic_messaging
```

##### Step 5: Run this project in main class by click button of the top center in IntelliJ IDE


##### Step 6: Download Postman then go add REST API
After you SEND the request, you need to see the response ``` 201 ok ``` meaning it works, if the response
is ``404 not found`` meaning the url is cannot be found or misspelled, if the response is ``500 internal server``
there is error inside of the code.

``POST`` method
```
http://localhost:8080/api/users/create-account
```
then go to "raw" & "JSON" and type this code json format

request
```
{
    "name": "John"
}
```

response 

Body Cookies  Headers ``201 OK``
```
{
    "name": "John",
    "messages": null
}
```


#### Step 9: Check your ``name`` if it's exist 
``GET`` method

request

```
http://localhost:8080/api/users/account/1
```
response

```
{
    "name": "John",
    "messages": null
}
```

#### Step 8: Create your own message or first chat
``POST`` method
```
http://localhost:8080/api/messages/create-message
```

request

```
{
    "userId": 1,
    "content": "My first message from John"
}
```

response

```
{
    "id": 1,
    "content": "My first message from John"
}
```

So you can add another message but per request
not multiple message in one request.

Example 

request

```
{
    "userId": 1,
    "content": "This is my second time to add my message from same account name"
}
```

response 

```
{
    "id": 2,
    "content": "This is my second time to add my message from same account name"
}
```

as you may notice the userId is still same because our first account name
is his id ``id: 1`` so that in message request body is we need to target 
our account name id's to link that message or multiple message

##### Step 9: Check you account name along with your name and list of messages/chat

``GET`` method

request

```
http://localhost:8080/api/users/my-chat/1
```

response

```
{
    "name": "John",
    "messages": [
        "My first message from John",
        "This is my second time to add my message from same account name"
    ]
}
```

in return you notice that you have 2 chats in 1 acocunt name because you put 2 message 
request body in ``messages api``