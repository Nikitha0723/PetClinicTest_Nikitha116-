package com.petclinic.test.jbehave.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


import net.thucydides.core.annotations.Steps;

public class PetClinicStorySteps {

	@Steps
	PetClinicSteps pc;

	@Given("user enters the valid url")
	public void userGivesTheValidUrl() {
		pc.userGivesTheValidUrl();
	}

	@Given("user enters to owner page")
	public void ownerPage() {
		pc.ownerPage();
	}

	@When("webpage launches")
	public void webpageLaunches() {
		pc.webpageLaunches();
	}

	@When("create new owner with invalid data")
	public void createOwnerWithInvalidData() {
		pc.createOwnerWithInvalidData();
	}

	@When("owner page launches")
	public void ownerPageDisplay() {
		pc.ownerPageDisplay();
	}

	@Then("verify image on homepage")
	public void verifyImageOnHomepage() {
		pc.verifyImageOnHomepage(null, null);
	}

	
	@Then("create new owner")
	public void createNewOwner() {
		pc.createNewOwner();
	}

	@Then("create pet for that owner")
	public void createPetForOwner() {
		pc.createPetForOwner();
	}

	@Then("error message will popup")
	public void verifyErrorMessage() {
		pc.verifyErrorMessage();
	}

	@Then("verify Veterinarians")
	public void verifyVeterinarians() {
		pc.verifyVeterinarians();
	}

	@Then("verify all available owners")
	public void verifyAllOwners() {
		pc.verifyAllOwners();
	}

	@Then("validate the data")
	public void validateOwner() {
		pc.validateOwner();
	}

	@Then("close the browser")
	public void closeTheBrowser() {
		pc.closeTheBrowser();
	}

}
