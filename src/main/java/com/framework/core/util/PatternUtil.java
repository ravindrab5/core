package com.framework.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class PatternUtil {
	private Logger log;

	public PatternUtil() {
		super();
		log = LogInitilizer.getLogger();
		log.debug("PatternUtil initlized ");
	}

	public String extractPattern(String text, String pat) {
		// Step 1: Allocate a Pattern object to compile a regexe

		Pattern pattern = Pattern.compile(pat);
		log.debug("Compiling pattern - " + pat + " for text - "+text);

		// Step 2: Allocate a Matcher object from the compiled regexe pattern,
		// and provide the input to the Matcher
		
		Matcher matcher = pattern.matcher(text);
		String match = null;

		// Use method find()
		while (matcher.find()) { // find the next match
			match = matcher.group(1);
			log.debug("Found match - " + match);
		}
		return match;
	}

}
