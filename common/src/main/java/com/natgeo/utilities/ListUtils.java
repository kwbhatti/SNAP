package com.natgeo.utilities;

import java.util.List;
import java.util.ListIterator;

public class ListUtils {
	
	public static void replaceStringInList(List<String> list,String strFind, String strReplace) {
	    ListIterator<String> it = list.listIterator();
	    while(it.hasNext()) {
	        it.set(it.next().replace(strFind,strReplace));
	    }
	}

	
	public static void capitalizeTrimStringsInList(List<String> list) {
	    ListIterator<String> it = list.listIterator();
	    while(it.hasNext()) {
	        it.set(it.next().trim().toUpperCase());
	    }
	}
}
