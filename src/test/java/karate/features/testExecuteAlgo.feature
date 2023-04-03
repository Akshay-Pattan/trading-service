Feature: Service execute algorithm
  test service end point Execute Algo

  BackGround:
    * url 'http://localhost:8080'
    * header Accept = 'application/json'

  Scenario Outline: Successful scenarios of testing executeAlgo endpoint
    GIVEN path 'executeAlgo'
    AND header Accept = 'application/json'
    AND request {"signal" : <signal>}
    WHEN METHOD post
    THEN status 204
    * print 'Server response is following ', response

    @CT @CIT
    examples
    | signal |
    | 1      |
    | 3      |
    | 9      |
    | 21     |