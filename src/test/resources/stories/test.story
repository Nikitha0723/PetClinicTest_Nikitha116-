Story: PetClinic
Meta:
@author Nikitha
Narrative:
In order to test petclinic application
As a user 
I want to verify all use   cases

Scenario: Verify image on homepage
Given user enters the valid url
When webpage launches
Then verify image on homepage
And close the browser

Scenario: Verify all the Veterinarians in the application
Given user enters the valid url
When webpage launches
Then verify Veterinarians
And close the browser

Scenario: Verify all the Owners in the application
Given user enters to owner page
When owner page launches
Then verify all available owners
And close the browser

Scenario: Add new Owner and pet to that Owner
Meta:
@happypath
Given user enters the valid url
When webpage launches
Then create new owner
And create pet for that owner
And close the browser

Scenario: Verify adding owner with invalid data
Meta:
@errorpath
Given user enters the valid url
When webpage launches
And create new owner with invalid data
Then error message will popup
And close the browser

Scenario: Validate information  added for owner and pet is correct
Given user enters the valid url
When webpage launches
Then validate the data
And close the browser