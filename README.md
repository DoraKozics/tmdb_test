# Setup

### 1. Clone the Repository

Clone the repository locally by running the following command:

```git clone https://github.com/DoraKozics/tmdb_test.git```


### 2. Set Up the PostgreSQL Database
Ensure Docker Desktop is installed and running on your system.
If port 5432 is already in use on your system or you already have an existing PostgreSQL container running, you have two options:
- Choose a different port for the PostgreSQL database container by modifying the port binding when running the Docker command.
- If you have an existing PostgreSQL container, ensure that the user and password configured in your application.yml file match the credentials of your existing PostgreSQL container. Update the application.yml file with the correct username and password if necessary.
- Run the following command to start a new interactive bash session in the existing PostgreSQL container:
- ```docker exec -it <container_name_or_id> bash```
- Replace <container_name_or_id> with the name or ID of your existing PostgreSQL container
- Inside the container, run the following command: 
- ```psql -U postgres```
- You will be prompted to enter the PostgreSQL password.
- Now, you can create a new database named 'tmdb':
- ```CREATE DATABASE tmdb;```
- You can exit by typing \q and then exit.  

If you don't have an existing PostgreSQL container, follow these steps:

- Run the following command to pull the PostgreSQL Docker image:
- ```docker pull postgres```
- Once the image is pulled, run the following command to create and start the PostgreSQL database container:
- ```docker run --name tmdb_db -e POSTGRES_DB=tmdb -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=root -p 5432:5432 -d postgres```

### 3. Run the Backend Java Application
Using Maven:
- Navigate to the backend directory in your project.
- Ensure Maven is installed on your system.
- Run the following command to build the Java application:
- ```mvn clean install```
- Run the command to start the backend server:
- ```mvn spring-boot:run```
- This command will start the backend server on http://localhost:8080.

Using IntelliJ IDEA:
- Open IntelliJ IDEA IDE and import your backend project by selecting File > Open and navigating to the backend directory in your project.
- Ensure that the required dependencies are downloaded by IntelliJ (this may happen automatically).
- Locate the main class of your Spring Boot application (usually annotated with @SpringBootApplication) and right-click on it.
- Select Run <Your Main Class Name> from the context menu.
- This will start the backend server. You should see the server output in the IntelliJ console.
- The backend server will also be accessible on http://localhost:8080.

### 4. Run the Frontend Angular Application
- Navigate to the 'frontend' directory in the project.
- Ensure Node.js and npm are installed on your system.
- Run the following commands to install dependencies and start the application:
- ```npm install```
- ```npm start```
- This command will start the frontend server on http://localhost:4200. You can access the application by opening a browser and navigating to it.
