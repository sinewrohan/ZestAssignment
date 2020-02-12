package com.zest.assigmnment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath="//div[@id='pagelet_composer']/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div")
	private WebElement post;

	@FindBy(xpath="//div[@id='pagelet_composer']/div/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[3]/div[2]/button")
	private WebElement statusbutton;
	
	
	public WebElement getPost() {
		return post;
	}
	
	public WebElement getStstusbutton() {
		return statusbutton;
	}

	public void postStatus(String statusText) {
		post.sendKeys(statusText);
		statusbutton.click();
	}
	
}
