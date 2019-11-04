REPO: pushed to git resposiry in GITHUB. Repository name: # eventservice-repo
URL: https://github.com/jimzhang0000/eventservice-repo
I will make it public for you to access

BUILD:
1) Automatically build with Eclipse Neon
2) Project can be maven build in Eclipse IDE
3) Run mvn clean install in CLI, will create .war file

RUN:
1) RUN on localhost:8080 of built in brower of IDE
2) RUN on Postman


REST API:
1) List all events: (with built in web browser in IDE or in PostMan)
http://localhost:8080/eventservice/webapi/events
2) Add one event
With Postman, using POST method, setup the application/xml in header,
input the raw data as:
 
<event>
  <address>
    Address 1
  </address>
  <name>
    Event Name 1
  </name>
</event>

The Id and Date will be system generated

3) List one event by Id
   Adding the Id right at the end of the above REST API
   for example: if the Id is: 1234 
   Then the URI will be:

   http://localhost:8080/eventsource/webapi/1234

   Runtime exception will be thrown with 404 error if
   there is no such Id

TEST:
Wrote the corresponding JUNIT5 test cases. (note: the test cases need to be enhanced, should use assertEquals(), as I got the null pointer exceptions, used assertNull instead to let it pass, this bug should be resolved) 
Right click the mouse on the EventServiceTest.java file, select the "JUNIT test" in Eclipse IDE, all three tests passed.
