package com.natgeo.aemcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CQ5Page extends BasePage {

	public CQ5Page(WebDriver driver) {
		super(driver);
	}

	private static By tree_node_list() { return By.cssSelector(".x-tree-node-el>a>span"); };
	private static By tags(String arg1, String arg2) { return By.xpath(
		"(.//label[starts-with(text(),'"+arg1+"')]/parent::div/descendant::"+arg2+")[last()]");}
	private static By tags_section(String arg1, String arg2, String arg3) {
		return By.xpath(
			"(.//label[text()='"+arg3+"']/parent::div//label[starts-with(text(),'"+arg1+"')]/parent::div/descendant::"+arg2+")[last()]");
	}
	private static By fieldset_input(String arg1, String arg2, String arg3) {
		return By.xpath(
			"((.//fieldset[contains(@class, 'x-fieldset')])/descendant::legend/descendant::span[text() = '"+arg1+"']/parent::legend/parent::fieldset/descendant::div/descendant::label[text() = '"+arg2+"']/parent::div/descendant::div/descendant::"+arg3+")");
	}

	public void write_input_field(String field, String value) {
		getDriver().findElement(tags(field,"input")).sendKeys(value);
	}

	public void write_input_field_in_section(String field, String value, String section) {
		getDriver().findElement(tags_section(field, "input", section)).sendKeys(value);
	}

	public void write_textarea_field(String field, String value) {
		getDriver().findElement(tags(field, "textarea")).sendKeys(value);
	}

	public void write_frame_field(String field, String value) {
		getDriver().findElement(tags(field, "iframe")).sendKeys(value);
	}

	public void write_input_attribute_field(String field, String attribute, String value) {
		getDriver().findElement(fieldset_input(attribute, field, "input")).sendKeys(value);
	}

	public void write_option_input_field(String value) {
		getDriver().findElement(By.xpath("(.//input[@name = './options'])[last()]")).sendKeys(value);
	}

	public void click_on_button(String text) {
		getDriver().findElement(By.xpath("(//button[text()='" + text + "'])[last()]")).click();
	}

  private Boolean exists_item(String name) {
		return getDriver().findElement(By.xpath(name)).isDisplayed();
	}

	/* private Void multiple_selection(List<WebElement>)

	public void  cq_object_cleaner(String cq_object):
			// Deletes a cq5 object from websites admin or dam admin
			if exists_item(cq_object){
					self.driver_facade.multiple_selection(
							(By.XPATH, self.title_unselected.format(cq_object)))
					self.driver_facade.right_click((By.XPATH, self.title_locator
																					.format(cq_object)))
					self.driver_facade.click((By.XPATH, self.menu_popup_locator
																		.format("Delete")))
					self.driver_facade.click((By.XPATH, "(//button[text()='Yes'])"
																							"[last()]"), 5)
					if self.driver_facade.is_element_visible(
									(By.XPATH, "(//button[text()='Yes'])[last()]")):
							self.driver_facade.click(
									(By.XPATH, "(//button[text()='Yes'])[last()]"), 5)}
			else
					raise {NoSuchElementException('Object "{0}" does not exists'
																			 .format(cq_object))}
																			 */

}
