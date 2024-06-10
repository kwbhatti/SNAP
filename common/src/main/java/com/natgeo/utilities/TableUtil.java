package com.natgeo.utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Requires the String selector for the group that contains the webelements of
 * every column header(commonly "//thead/tr/th") Requires the String selector
 * for the group that contains the webelements of every cell in the table matrix
 * (commonly "//tbody/tr[0]")
 * 
 * @author esteban.roa
 *
 */
public class TableUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(TableUtil.class);

	private String COLUMN_HEADER_GROUP_SELECTOR;
	private String TABLE_CELL_MATRIX_SELECTOR;

	/**
	 * Creates the TableUtil object with the column header selector string and table
	 * cell matrix selector string
	 * 
	 * @param columnHeaderGroup : String selector for the group that contains the
	 *                          webelements of every column header(commonly
	 *                          "//thead/tr/th")
	 * @param tableCellMatrix   : String selector for the group that contains the
	 *                          webelements of every cell in the table matrix
	 *                          (commonly "//tbody/tr[%s]/th[%s]")
	 */
	public TableUtil(String columnHeaderGroup, String tableCellMatrix) {
		COLUMN_HEADER_GROUP_SELECTOR = columnHeaderGroup;
		TABLE_CELL_MATRIX_SELECTOR = tableCellMatrix;
	}

	/**
	 * Sets the column Header Selector for the profiles page table
	 * 
	 * @param columnHeaderSelector Requires table selector xpath with %s inputs
	 */
	public void SetColumnHeaderSelector(String columnHeaderSelector) {
		this.COLUMN_HEADER_GROUP_SELECTOR = columnHeaderSelector;
	}

	/**
	 * Sets the table cell selector the profiles page table
	 * 
	 * @param tableCellSelector Requires column selector xpath
	 */
	public void SetTableCellSelector(String tableCellSelector) {
		this.TABLE_CELL_MATRIX_SELECTOR = tableCellSelector;
	}

	/**
	 * Get the number of columns in the current table
	 * 
	 * @param pageObj the PageObject where the table is located
	 * @return the number of columns in the table
	 */
	public int GetColumnsCount(PageObject pageObj) {
		return pageObj.findAll(COLUMN_HEADER_GROUP_SELECTOR).size();
	}

	/**
	 * Transform name column into number of the column position in the current table
	 * 
	 * @param pageObj the PageObject where the table is located
	 * @param headerCaption
	 * @return Header Column position in the list of the table's columns
	 */
	public int GetHeaderIndex(PageObject pageObj, String headerCaption) {
		List<WebElementFacade> columns = pageObj.findAll(COLUMN_HEADER_GROUP_SELECTOR);
		int counter = 0;
		boolean found = false;

		while (counter < columns.size() && !found) {
			WebElementFacade header = columns.get(counter);
			if (headerCaption.equals(header.getText())) {
				found = true;
			}
			counter++;
		}

		if (found) {
			return counter - 1;
		}

		LOGGER.info("No column found with the given input: " + headerCaption);
		return -1;
	}

	/**
	 * Gets the cell web element from the given name of the column plus the row
	 * number
	 * 
	 * @param pageObj the PageObject where the table is located
	 * @param columnName the name of the column I´m looking for
	 * @param rowNumber the row number I want to take the information
	 * @return WebElement for the given name column and row numbre
	 */
	public WebElementFacade GetCellElement(PageObject pageObj, String columnName, String rowNumber) {
		int columnHeader = GetHeaderIndex(pageObj, columnName);
		return pageObj.findBy(String.format(TABLE_CELL_MATRIX_SELECTOR, rowNumber, String.valueOf(columnHeader)));
	}

	/**
	 * Returns the cell text of the given cell coordinates
	 * 
	 * @param pageObj the PageObject where the table is located
	 * @param columnName the name of the column I´m looking for
	 * @param rowNumber the row number I want to take the information
	 * @return cell text of the given cell coordinates
	 */
	public String GetCellText(PageObject pageObj, String columnName, String rowNumber) {
		return GetCellElement(pageObj, columnName, rowNumber).waitUntilVisible().getText();
	}

	/**
	 * Perform a click on the cell given the coordinates by column name and row
	 * number
	 * 
	 * @param pageObj the PageObject where the table is located
	 * @param columnName the name of the column I´m looking for
	 * @param rowNumber the row number I want to take the information
	 */
	public void ClickCell(PageObject pageObj, String columnName, String rowNumber) {
		GetCellElement(pageObj, columnName, rowNumber).waitUntilClickable().click();
	}

}
