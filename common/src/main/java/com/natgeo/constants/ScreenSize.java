package com.natgeo.constants;

import java.awt.Rectangle;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ScreenSize {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScreenSize.class);
	public final static Rectangle DESKTOP800X600 = new Rectangle(800,600);
	public final static Rectangle DESKTOP1024X768 = new Rectangle(1024,768);	
	public final static Rectangle DESKTOP1152X8640 = new Rectangle(1152,864);
	public final static Rectangle DESKTOP1280X768 = new Rectangle(1280,768);
	public final static Rectangle DESKTOP1280X800 = new Rectangle(1280,800);
	public final static Rectangle DESKTOP1280X960 = new Rectangle(1280,960);
	public final static Rectangle DESKTOP1280X1024 = new Rectangle(1280,1024);
	public final static Rectangle DESKTOP1400X1050 = new Rectangle(1400,1050);
	public final static Rectangle DESKTOP1440X900 = new Rectangle(1440,900);
	public final static Rectangle DESKTOP1600X1200 = new Rectangle(1600,1200);
	public final static Rectangle DESKTOP1680X1050 = new Rectangle(1680,1050);
	public final static Rectangle DESKTOP1920X1080 = new Rectangle(1920,1080);
	public final static Rectangle DESKTOP1920X1200 = new Rectangle(1920,1200);
	public final static Rectangle DESKTOP2560X1600 = new Rectangle(2560,1600);

	
	public final static Rectangle IPHONE_X = new Rectangle(1125,2436);
	public final static Rectangle IPHONE_X_VP = new Rectangle(375,812);
	public final static Rectangle IPHONE_8_PLUS = new Rectangle(1080,1920);
	public final static Rectangle IPHONE_8_PLUS_VP = new Rectangle(414,736);
	public final static Rectangle IPHONE_8 = new Rectangle(750,1334);
	public final static Rectangle IPHONE_8_VP = new Rectangle(375,667);
	public final static Rectangle IPHONE_7_PLUS = new Rectangle(1080,1920);
	public final static Rectangle IPHONE_7_PLUS_VP = new Rectangle(414,736);
	public final static Rectangle IPHONE_7 = new Rectangle(750,1334);
	public final static Rectangle IPHONE_7_VP = new Rectangle(375,667);
	public final static Rectangle IPHONE_6S_PLUS = new Rectangle(1080,1920);
	public final static Rectangle IPHONE_6S_PLUS_VP = new Rectangle(414,736);
	public final static Rectangle IPHONE_6S = new Rectangle(750,1334);
	public final static Rectangle IPHONE_6S_VP = new Rectangle(375,667);
	public final static Rectangle IPHONE_6_PLUS = new Rectangle(1080,1920);
	public final static Rectangle IPHONE_6_PLUS_VP = new Rectangle(414,736);
	public final static Rectangle IPHONE_6 = new Rectangle(750,1334);
	public final static Rectangle IPHONE_6_VP = new Rectangle(375,667);
	public final static Rectangle IPHONE_5 = new Rectangle(640,1136);
	public final static Rectangle IPHONE_5_VP = new Rectangle(320,568);

	public final static Rectangle IPOD = new Rectangle(640,1136);
	public final static Rectangle IPOD_VP = new Rectangle(320,568);

	public final static Rectangle IPAD_PRO = new Rectangle(2048,2732);
	public final static Rectangle IPAD_PRO_VP = new Rectangle(1024,1366);
	public final static Rectangle IPAD_3 = new Rectangle(1536,2048);
	public final static Rectangle IPAD_3_VP = new Rectangle(768,1024);
	public final static Rectangle IPAD_4 = new Rectangle(1536,2048);
	public final static Rectangle IPAD_4_VP = new Rectangle(768,1024);
	public final static Rectangle IPAD_AIR_1 = new Rectangle(1536,2048);
	public final static Rectangle IPAD_AIR_1_VP = new Rectangle(768,1024);	
	public final static Rectangle IPAD_AIR_2 = new Rectangle(1536,2048);
	public final static Rectangle IPAD_AIR_2_VP = new Rectangle(768,1024);	
	public final static Rectangle IPAD_MINI = new Rectangle(768,1024);
	public final static Rectangle IPAD_MINI_VP = new Rectangle(768,1024);	
	public final static Rectangle IPAD_MINI_3 = new Rectangle(1536,2048);
	public final static Rectangle IPAD_MINI_3_VP = new Rectangle(768,1024);	
	public final static Rectangle IPAD_MINI_4 = new Rectangle(1536,2048);
	public final static Rectangle IPAD_MINI_4_VP = new Rectangle(768,1024);	
	
	
	public final static Rectangle NEXUS_6P = new Rectangle(1440,2560);
	public final static Rectangle NEXUS_6P_VP = new Rectangle(411,731);
	public final static Rectangle NEXUS_5X = new Rectangle(1080,1920);
	public final static Rectangle NEXUS_5X_VP = new Rectangle(411,731);	
	public final static Rectangle PIXEL = new Rectangle(1080,1920);
	public final static Rectangle PIXEL_VP = new Rectangle(411,731);	
	public final static Rectangle PIXEL_XL = new Rectangle(1440,2560);
	public final static Rectangle PIXEL_XL_VP = new Rectangle(411,731);	
	public final static Rectangle PIXEL_2 = new Rectangle(1080,1920);
	public final static Rectangle PIXEL_2_VP = new Rectangle(411,731);	
	public final static Rectangle PIXEL_2_XL = new Rectangle(1440,2560);
	public final static Rectangle PIXEL_2_XL_VP = new Rectangle(411,731);	

	public final static Rectangle GALAXY_NOTE_5 = new Rectangle(1440,2560);
	public final static Rectangle GALAXY_NOTE_5_VP = new Rectangle(480,853);	

	public final static Rectangle LG_G5 = new Rectangle(1440,2560);
	public final static Rectangle LG_G5_VP = new Rectangle(480,853);	
	
	public final static Rectangle ONE_PLUS_3 = new Rectangle(1080,1920);
	public final static Rectangle ONE_PLUS_3_VP = new Rectangle(480,853);
	
	public final static Rectangle GALAXY_S8 = new Rectangle(1440,2960);
	public final static Rectangle GALAXY_S8_VP = new Rectangle(360,740);
	public final static Rectangle GALAXY_S8_PLUS = new Rectangle(1440,2960);
	public final static Rectangle GALAXY_S8_PLUS_VP = new Rectangle(360,740);
	public final static Rectangle GALAXY_S7 = new Rectangle(1440,2560);
	public final static Rectangle GALAXY_S7_VP = new Rectangle(360,740);
	public final static Rectangle GALAXY_S7_EDGE = new Rectangle(1440,2560);
	public final static Rectangle GALAXY_S7_EDGE_VP = new Rectangle(360,640);
	
	public final static Rectangle NEXUS_7 = new Rectangle(1200,1920);
	public final static Rectangle NEXUS_7_VP = new Rectangle(600,960);	
	public final static Rectangle NEXUS_9 = new Rectangle(1536,2048);
	public final static Rectangle NEXUS_9_VP = new Rectangle(768,1024);	

	public final static Rectangle GALAXY_TAB_10 = new Rectangle(800,1280);
	public final static Rectangle GALAXY_TAB_10_VP = new Rectangle(800,1280);
	
	public final static Rectangle CHROMEBOOK_PIXEL = new Rectangle(2560,1700);
	public final static Rectangle CHROMEBOOK_PIXEL_VP = new Rectangle(1280,850);
	
	
	public static Rectangle getRec(String  name) {
		LOGGER.info("screen Name -->" + name);
	    for (Field rec : ScreenSize.class.getDeclaredFields()) {
	        if( name.trim().toUpperCase().equals(rec.getName()) ) {  		
	        		try {
						return (Rectangle) rec.get(null);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        }
	                
	    }
	    LOGGER.error("Screen size not found");
	    return null;
	}
}
