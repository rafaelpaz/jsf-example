# JSF Example - Wildfly Session Replication

Simple project testing Wildfly Infinispan config.

With Wildfly 21.0.1.Final, the JSF application fail when the following config is used:

``` 
  <cache-container name="web" default-cache="test" module="org.wildfly.clustering.web.infinispan">
                <transport lock-timeout="60000"/>
                <replicated-cache name="test">
                    <locking acquire-timeout="30000" isolation="READ_COMMITTED"/>
                    <transaction mode="NONE"/>
                </replicated-cache>

   
   ....                
``` 

To replicate the bug, it's necessary to use the standalone.xml in the wildfly folder, which contains the cache configuration above.

Package tha app with maven:
`mvn clean package`

Copy the file target/jsf-example.war to the deployments folder of Wildfly, or just build and run a Docker image:

`docker build -t jsf-example .`
`docker run -i --rm -p 8080:8080 jsf-example`

I created a complete Dockerfile because there is no image with the Wildfly 21.0.1.Final at the moment.

The application has been configured to use the "/" context.

After that, just follow the steps:
- Access the application: `localhost:8080/`
- Click on any button (refresh or generate uuid), after a few clicks an exception is thrown.

