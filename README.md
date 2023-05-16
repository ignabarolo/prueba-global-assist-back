# GlobalAssistBack
This project was generated with Java version "17.0.2" 2022-01-18 LTS and Spring Boot 3.

Requirements of the proyect:
- List of entries in a centain date range so that returns json with data

Acceptance criteria:
- The API must answer at the following endpoint:
http://server:port/api/entries?DoorId={DoorId}&FromDate={FromDate}&ToDate={ToDate}
- method: GET
- Params
  -FromDate:DateTime:Required
  -ToDate:DateTime:Required
  -DoorId:String:Required

Optional: Create the delete method 

Acceptance criteria:
- The API must answer at the following endpoint: http://server:port/api/entries/{id}
- method: DELETE
- Params
  -id:String:Required
  
Documentation:  
- Swagger is used to document the API.
- The URL to view the API documentation is: http://server:port/swagger-ui.html  
