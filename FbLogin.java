package com.zest.assigmnment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FbLogin {

	@FindBy(id="email")
	static WebElement username;
	
	@FindBy(id="pass")
	static WebElement pass;
	
	@FindBy(id="u_0_b")
	private WebElement loginButton;
	
	
	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return pass;
	}
	
	public WebElement getPass() {
		return pass;
	}

	
	public void FbLoginAction(String userId, String password) {
		username.sendKeys(userId);
		pass.sendKeys(password);
		loginButton.click();
		
	}
	
	
}
