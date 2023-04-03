Feature: Service Health
  test service health end point

  BackGround:
    * url baseUrl
    * header Accept = 'application/json'

  @CT @CIT
  Scenario Outline: This scenario is testing Health end point
    GIVEN path 'health'
    WHEN method get
    THEN status 200
    * print 'Server response is following ', response
    AND match response.status == 'UP'