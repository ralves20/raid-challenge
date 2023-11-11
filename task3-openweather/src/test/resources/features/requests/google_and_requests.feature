Feature: Open Weather Requests

  @google
  Scenario: Searching for a term on Google and validating the requests
    Given Sergey is researching things on the internet
    And he searches for "Weather London"
    When he verifies the temperature in the location that he searched
    Then he should see that the temperature is the same as the existant in the OpenWeatherMap for "London"


  @reproduce_error @400
  Scenario: Performing a bad request
    Given Sergey is researching things on the internet
    When he performs a wrong request for the openweather to get the temperature
    Then he should see that the request returns a bad request 400 error


  @reproduce_error @401
  Scenario: Performing a unauthorized request
    Given Sergey is researching things on the internet
    When he performs a unauthorized request for the openweather to get the temperature
    Then he should see that the request returns a unauthorized 401 error

  @reproduce_error @404
  Scenario: Performing a not found request
    Given Sergey is researching things on the internet
    When he performs a not found request for the openweather to get the temperature
    Then he should see that the request returns a not found 404 error


    #To perform a 429 error would be necessary to perform many requests to the same endpoint
    #At the same time, so this would probably turn into a 'too many requests' error, and that is
    #when the 429 error happens


    #To Perform a 5xx error the only thing necessary would be to have any kind of error
    #on the server side, as for this kind of error happen, it is just related once there is an error on the client



