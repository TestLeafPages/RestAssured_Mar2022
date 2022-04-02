Feature: IncidentManagement


Scenario: Get an existing incident

 Given setup the endpoint
 And setup the authorization
 When send get request
 Then Confirm the status code as 200
 And print the response
 

Scenario: create a new incident with body as string

 Given setup the endpoint
 And setup the authorization
 When send post request with short_description as 'Create Incident with body as string' and category as 'software'
 Then Confirm the status code as 201
 And print the response
 
 @DemoRun
Scenario Outline: create a new incident with body as string

 Given setup the endpoint
 And setup the authorization
 When send post request with short_description as '<short_desc>' and category as '<category>'
 Then Confirm the status code as 201
 And print the response
 
 
 Examples:
 # |column header|
 |short_desc|category|
 # 1st data row
 |Create Incident with body as string 1|software|
 # 2nd data row
 |Create Incident with body as string 2|hardware|
  
 
 
 
 
 
 
 
 
 
 
 
 
 