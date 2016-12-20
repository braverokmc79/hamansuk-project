package com.example.wbe04.util;

public class FormTagReplace {

	
	public static String chagne(String str){	
		String change=str.replace("\n", "<br>")
					.replace("  ", "&nbsp;&nbsp;")
					.replace("<", "&lt;")
					.replace(">", "&gt;");
		 return change;
	}
	
	
}
