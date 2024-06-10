package com.natgeo.utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextFileUtil {

	static InputStream is;
	static BufferedReader br;
    static StringBuilder sb;

	public static String textFileToString(String filePath) throws IOException  {
		String returnString = null;
		is = new FileInputStream(filePath);
		br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        sb = new StringBuilder();
        while (line != null) {
        		sb.append(line).append("\n");
            line = br.readLine();
        }
        returnString = sb.toString();
        System.out.println(returnString);
		return returnString;
	}

}
