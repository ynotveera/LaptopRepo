Feature: Create the Lead in leafTaps application

Background:
Given Login the LeafTaps
And Navigate to CreateLeadPage

Scenario Outline: Create Lead With Multiple FirstName and LastName
And Provide FirstName as <firstName>
And Provide LastName as <lastName>
When Save
Then Verify the Lead Created

Examples:
|firstName|lastName|
|VIGNESH|SUNDHAR|
|VIGNESHRAM|SUNDHAR|

Scenario Outline: TC1 Create Lead With Multiple FirstName and LastName
And Provide FirstName as <firstName>
And Provide LastName as <lastName>
When Save
Then Verify the Lead Created

Examples:
|firstName|lastName|
|VIGNESH|SUNDHAR|
|VIGNESHRAM|SUNDHAR|

