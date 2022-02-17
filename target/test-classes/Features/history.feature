Feature: Hotel app history page
Scenario: Hotel app history details verification

Given User is in home page
When User must select order booking history tab
And Verify whether booking available for selected date
Then Booking history verified