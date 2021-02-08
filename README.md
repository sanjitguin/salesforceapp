###### App description
This is a simple springboot application, which calls salesforce api to get data and display.

###### framework used
1. spring boot
2. maven
3. Junit
4. JMockit

###### unit testing
   Run the below command to execute the test cases <br/>
   ** cmd> ** mvn verify 

###### Build
   Build jar file using maven cmd <br/>
   ex, ** cmd> ** mvn clean build
   
###### Run
   run jar using java cmd.  
   ** cmd> ** java -jar salesforce-app-0.0.1-SNAPSHOT.jar  
   
   In order to function the app please provide below parameters as arguments: <br/>
    - salesforce.host-name={{https://{instance}.salesforce.com}} <br/>
    - salesforce.password={{password}} <br/>
    - salesforce.username={{salesforce-username}} <br/>
    - salesforce.security-token={{security-token}} <br/>  
    - salesforce.client-id={{consumer-id}} <br/>
    - salesforce.client-secret={{consumer-secret}} <br/>
   <br/>
   ** cmd> ** java -Dsalesforce.host-name={host} -Dsalesforce.password={pwd} -Dsalesforce.username={username} -Dsalesforce.security-token={security-token} -Dsalesforce.client-id={consumer-id}  -Dsalesforce.client-secret={consumer-secret} -jar target\salesforce-app-0.0.1-SNAPSHOT.jar

###### End points
	GET: http://localhost:8080/sobject
	GET: http://localhost:8080/sobject/{sobject-name}
	GET: http://localhost:8080/sobject/{sobject-name}/describe
	GET: http://localhost:8080/query?q={query}
