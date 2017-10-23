Feature:
  As an API user
  I want to filter results by different criteria

  Scenario: Apply a photo filter
    Given the service is running
    When I apply a "photo" filter
    And I make a request
    Then I receive 22 results

  Scenario: Apply a contact filter
    Given the service is running
    When I apply a "contact" filter
    And I make a request
    Then I receive 12 results

  Scenario: Apply a favourite filter
    Given the service is running
    When I apply a "favourite" filter
    And I make a request
    Then I receive 6 results

  Scenario: Apply a compatibility filter
    Given the service is running
    When I apply a "compatibility" filter with range from 0.3 to 0.7
    And I make a request
    Then I receive 2 results

  Scenario: Apply an edge case compatibility filter
    Given the service is running
    When I apply a "compatibility" filter with range from 0 to 1
    And I make a request
    Then I receive 25 results

  Scenario: Apply a compatibility filter with wrong format
    Given the service is running
    When I apply a "compatibility" filter
    And I make a request
    Then I receive the error message "Invalid number of "compatibility" filter parameters"

  Scenario: Apply a compatibility filter with wrong format
    Given the service is running
    When I set the filter parameter to "compatibility:a:b"
    And I make a request
    Then I receive the error message "Invalid "compatibility" filter parameters"

  Scenario: Apply an age filter
    Given the service is running
    When I apply an "age" filter with range from 30 to 40
    And I make a request
    Then I receive 13 results

  Scenario: Apply a wider age filter
    Given the service is running
    When I apply an "age" filter with range from 18 to 95
    And I make a request
    Then I receive 25 results

  Scenario: Apply an edge case age filter
    Given the service is running
    When I apply an "age" filter with range from 18 to -1
    And I make a request
    Then I receive 25 results

  Scenario: Apply a age filter with wrong format
    Given the service is running
    When I apply a "age" filter
    And I make a request
    Then I receive the error message "Invalid number of "age" filter parameters"

  Scenario: Apply a age filter with wrong format
    Given the service is running
    When I set the filter parameter to "age:a:b"
    And I make a request
    Then I receive the error message "Invalid "age" filter parameters"

  Scenario: Apply a height filter
    Given the service is running
    When I apply an "height" filter with range from 160 to 180
    And I make a request
    Then I receive 12 results

  Scenario: Apply a wider height filter
    Given the service is running
    When I apply an "height" filter with range from 135 to 210
    And I make a request
    Then I receive 25 results

  Scenario: Apply an edge case height filter
    Given the service is running
    When I apply an "height" filter with range from 135 to -1
    And I make a request
    Then I receive 25 results

  Scenario: Apply a height filter with wrong format
    Given the service is running
    When I apply a "height" filter
    And I make a request
    Then I receive the error message "Invalid number of "height" filter parameters"

  Scenario: Apply a height filter with wrong format
    Given the service is running
    When I set the filter parameter to "height:a:b"
    And I make a request
    Then I receive the error message "Invalid "height" filter parameters"

  Scenario: Apply a distance filter with the Swindon location
    Given the service is running
    When I apply a "distance" filter with the distance 30 km from the location (51.568535,-1.772232)
    And I make a request
    Then I receive 2 results

  Scenario: Apply a distance filter with the London location
    Given the service is running
    When I apply a "distance" filter with the distance 30 km from the location (51.509865,-0.118092)
    And I make a request
    Then I receive 6 results

  Scenario: Apply a wider distance filter with the London location
    Given the service is running
    When I apply a "distance" filter with the distance 300 km from the location (51.509865,-0.118092)
    And I make a request
    Then I receive 19 results

  Scenario: Apply an edge case distance filter with the London location
    Given the service is running
    When I apply a "distance" filter with the distance -1 km from the location (51.509865,-0.118092)
    And I make a request
    Then I receive 25 results

  Scenario: Apply a distance filter with wrong format
    Given the service is running
    When I apply a "distance" filter
    And I make a request
    Then I receive the error message "Invalid number of "distance" filter parameters"

  Scenario: Apply a distance filter with wrong format
    Given the service is running
    When I set the filter parameter to "distance:a:b"
    And I make a request
    Then I receive the error message "Invalid "distance" filter parameters"

  Scenario: Apply a wrong filter
    Given the service is running
    When I apply a "wrong" filter
    And I make a request
    Then I receive the error message "Unknown filter type: wrong"
