package com.petclinic.test.jbehaveRunner;

import net.serenitybdd.jbehave.SerenityStories;

public class JbehaveRunnerClass extends SerenityStories{
 @Override
 public void findStoriesCalled(String storyNames) {
	super.findStoriesCalled("test.story");
 }
}
