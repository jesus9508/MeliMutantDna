# MeliMutantDna

Techinal test 'Meli' for checking If Dna Is From Mutant or Human

## Java version
- Java 1.8

## Spring boot
- 2.7

## DataBase RDS (AWS)
- the database has been deployed in RDS instance, these are the conection parameters
```bash  
   user: admin
   password: melidna123
   host: database-dna.ccyoyffl7r1w.us-east-1.rds.amazonaws.com/dna
``` 

## How to start locally with docker?
- compile and create .jar package whit tests
```bash  
   mvn clean package 
``` 
 - execute docker build
```bash  
   docker build -t meli-dna-jesus-jimenez .
``` 
- execute docker build
```bash  
   run -p 8080:8080 meli-dna-jesus-jimenez
```

## Swagger uri
```bash  
   http://localhost:8080/dna-mutant/api/v1/swagger-ui.html
```

## Postman Collection
  [download collection](https://dnamutantbucket.s3.amazonaws.com/postmanCollection/dna-mutant.postman_collection.json)
