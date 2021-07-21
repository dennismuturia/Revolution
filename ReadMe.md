# Revolution Test
When the application boots up a user **1** is automatically created.

There are 3 APIs in the application:
1. balance
2. Play
3. All games

## Balance
This **GET** api returns the current balance the user has at his wallet. The url to access this is :
```http://localhost:8083/balance/1```. Notice the 1 is the user.

## Play
This api is a **POST** API. You have to inclode a JSON body when running the api.
Here is an example: ```curl -X POST \
http://localhost:8083/play/1 \
-H 'cache-control: no-cache' \
-H 'content-type: application/json' \
-d '{"amount":5}'```
This api returns the game played.

## All Games
This **GET**  api returns all the games that have been played by the player. It can be accessed with this URl
```http://localhost:8083/all/games/1```.,

This application is using Java 11 and Spring 2.5.2.

# Running the Application
If you have **docker-compose** simply run ```docker-compose up``` to run the applications. You can also Run the application Manually from the Main method.
