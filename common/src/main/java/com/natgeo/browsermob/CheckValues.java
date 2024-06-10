package com.natgeo.browsermob;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natgeo.browsermob.data.TestData;

public class CheckValues {
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckValues.class);

	public static void checkValuesByVariableNames(String name, Map<String, TestData> expectedValues,
			Map<String, String> foundValues) {
		Boolean goodToGo = true;

		LOGGER.info("\n-----------------------------------------------------------");
		LOGGER.info(name);

		for (String key : expectedValues.keySet()) {
			//LOGGER.info("*** " + expectedValues.get(key).getName() + " ***");
			if (foundValues.containsKey(key)) {
				switch (expectedValues.get(key).getCheckType().trim().toLowerCase()) {
				case "dateformat":
					String format = "MM/dd/YYYY";
					String value = foundValues.get(key);
					Date date = null;
					try {
						SimpleDateFormat sdf = new SimpleDateFormat(format);
						date = sdf.parse(value);
						if (!value.equals(sdf.format(date))) {
							date = null;
						}
					} catch (ParseException ex) {
						LOGGER.info("\tExpected Date format MM/dd/YYYY  but Found--> " + foundValues.get(key));
						goodToGo = false;
					}

					break;
				case "today":
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
					Date date2 = new Date();
					if(!dateFormat.format(date2).equals(foundValues.get(key).trim())) {
						logValue( expectedValues.get(key).getName(),dateFormat.format(date2),foundValues.get(key));
						goodToGo = false;
					}
					break;
				case "equals":
				case "equal":
				default:
					if (!expectedValues.get(key).getValue().trim().contentEquals(foundValues.get(key).trim())) {
						logValue( expectedValues.get(key).getName(),expectedValues.get(key).getValue(),foundValues.get(key));
						goodToGo = false;
					}

				}
			} else {
				if(foundValues.get(key)!=null) {
					logValue( expectedValues.get(key).getName(),"null",foundValues.get(key));
					goodToGo = false;
				}	
			}

		}
		if (goodToGo) {
			LOGGER.info("PASSED");
		} else {
			assertThat(goodToGo, equalTo(true));
		}

	}
	
	
	private static void logValue(String name, String expected, String found) {
		LOGGER.info("\tField Name:\t" + name + "\n\t\t\t\t\t\t\tExpected:\t" + expected + "\n\t\t\t\t\t\t\tFound:\t\t" + found);
	}

}
