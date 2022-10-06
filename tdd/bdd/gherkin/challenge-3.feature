# Challenge number 3
Feature: Challenge

# Challenge
Scenario: Challenge 3
Given I am requesting a boat insurance quote
When I click on 'Dinghy'
Then I should see the following fields
| Field             |
| Make              |
| Model             |
| Manufactured Date |
| Hull Length       |

When I click on 'Yacht'
Then I should see the following fields
| Field             |
| Make              |
| Model             |
| Manufactured Date |
| Hull Length       |
| Berths            |

When I click on 'Cruiser'
Then I should see the following fields
| Field             |
| Make              |
| Model             |
| Manufactured Date |
| Hull Length       |
| Engine Size       |
| Fuel Type         |
| Berths            |



# Solution
Background:
Given a boat insurance application has the following properties
| Poperty Name      |
| Make              |
| Model             |
| Manufactured Date |
| Hull Length       |


Scenario: Viewing properties for Dinghy
When I view the insurance properties for 'Dinghy'
Then I should see the common properties for a boat

Scenario: Viewing properties for Yacht
When I view the insurance properties for 'Yacht'
Then I should see the common properties for a boat
And I should see specific properties as follows
| Poperty Name      |
| Hull Length       |
| Berths            |

Scenario: Viewing properties for Cruiser
When I view the insurance properties for 'Cruiser'
Then I should see the common properties for a boat
And I should see specific properties as follows
| Hull Length       |
| Engine Size       |
| Fuel Type         |
| Berths            |
