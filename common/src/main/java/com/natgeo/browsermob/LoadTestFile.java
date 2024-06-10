package com.natgeo.browsermob;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import com.natgeo.browsermob.data.TestData;

public class LoadTestFile {

	public static Map<String, TestData> getFile(String fileName) {
		Map<String, TestData> testValues = new HashMap<String, TestData>();
		Properties props = new Properties();
		InputStream input = null;

		try {

			input = LoadTestFile.class.getClassLoader().getResourceAsStream(fileName);
			if (input == null) {
				System.out.println("Sorry, unable to find " + fileName);
				return null;
			}

			// load a properties file from class path, inside static method
			props.load(input);

			Set<String> keys = props.stringPropertyNames();
			for (String key : keys) {
				TestData entry = new TestData();

				String parts[] = props.getProperty(key).split(";");
				entry.setValue(parts[0]);
				entry.setCheckType(parts[1]);
				entry.setName(parts[2]);

				testValues.put(key, entry);
				//System.out.println(key + " : " + props.getProperty(key));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return testValues;
	}

}
