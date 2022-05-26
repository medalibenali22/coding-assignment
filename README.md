# coding-assignment
This project developed for coding-assignment

### Requirements
- JDK 1.8+
- Maven

### Architecture
The system designed with API services.
Repository Pattern has been used. Hbernate, JPA Data, Junit, Spring Boot, h2-database used for project.  

### Endpoints
- /account/add : this endPoint can be used to create a new account for existing customer
- /customers : this endPoint can be used to get all the custmer with thier account and transactions


### Running the Source Code

1.Clone the repository
```
$ git clone https://github.com/medalibenali22/coding-assignment.git
```

2. Import project as spring boot application 


3. Clean maven
```
$ mvn clean
```

4. Run the API
```
run as spring boot application
```

5. Open a browser and type localhost:8080

    The existing users are:
```
Id : 1, Name : med, Surname : ali

Id : 2, Name : javi, Surname : martnez

Id : 3, Name : consuelo, Surname : infantes
```
