package com.natgeo.examples.pages;

import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;


public class ExampleBasePage extends NatGeoBasePage {

	public ExampleBasePage(WebDriver driver) {
		super(driver);
	}

	public void openGoogle() {
		openUrl("http://www.google.com");
	}

	public void openWidePage() {
		openUrl("http://www.artcritical.com/2015/04/06/test-page-padgett-at-1600-pixels-wide/");
	}

	public void sleep(int time) {
		if (time > 0) {
			try {
				Thread.sleep(time*1000);
			}
			catch (InterruptedException e){
				System.err.println("InterruptedException: " + e.getMessage());
			}
			finally {}
		}
	}
}
