###### App description
This is a simple springboot application, which calls salesforce api to get data and display.

###### framework used
1. spring boot
2. maven

###### Build
   Build jar file using maven cmd.
   ex, mvn clean build
   
###### Run
   run jar using java cmd.
   cmd> java -jar salesforce-app-0.0.1-SNAPSHOT.jar 
   
   In order to function the app please provide below parameters as arguments:
    - salesforce.host-name={{https://<instance>.salesforce.com}} 
    - salesforce.password={{password}} 
    - salesforce.username={{salesforce-username}} 
    - salesforce.security-token={{security-token}} 
    - salesforce.client-id={{consumer-id}}  
    - salesforce.client-secret={{consumer-secret}}
    
   java -Dsalesforce.host-name={host} -Dsalesforce.password={pwd} -Dsalesforce.username={username} -Dsalesforce.security-token={security-token} -Dsalesforce.client-id={consumer-id}  -Dsalesforce.client-secret={consumer-secret} -jar target\salesforce-app-0.0.1-SNAPSHOT.jar

###### End points
	GET: http://localhost:8080/sobject
	GET: http://localhost:8080/sobject/{sobject-name}
	GET: http://localhost:8080/sobject/{sobject-name}/describe
