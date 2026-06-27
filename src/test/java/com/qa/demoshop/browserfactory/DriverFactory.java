package com.qa.demoshop.browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

public class DriverFactory {

	static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return threadLocal.get();
	}

	public static WebDriver initDriver(String browserName, boolean headless) {
		switch (browserName) {
		case "chrome":
			ChromeOptions chromeOpts = BrowserSettings.getchromeOptions(headless);
			threadLocal.set(new ChromeDriver(chromeOpts));
			Reporter.log("===[ IT IS EXECUTING IN CHROME BROWSER ]===", true);
			break;
		case "firefox":
			FirefoxOptions firefoxOpts = BrowserSettings.getFirefoxOptions(headless);
			threadLocal.set(new FirefoxDriver(firefoxOpts));
			Reporter.log("===[ IT IS EXECUTING IN FIREFOX BROWSER ]===", true);

			break;
		case "edge":
			EdgeOptions edgeOpts = BrowserSettings.getEdgeOptions(headless);
			threadLocal.set(new EdgeDriver(edgeOpts));
			Reporter.log("===[ IT IS EXECUTING IN EDGE BROWSER ]===", true);

			break;
		}
		return getDriver();

	}

	public static void quitDriver() {
		getDriver().quit();
		threadLocal.remove();
	}
}
