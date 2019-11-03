# eventservice-repo

REST API:
1) List all events: (with built in web browser in IDE or in PostMan)
http://localhost:8080/eventservice/webapi/events
2) Add one event
With Postman, setup the application/xml in header,
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

   Runtime exception will be thrown and catch with 404 error if
   there is no such Id
   OB
