/*
 * Copyright 2016 Synerzip Softech. All Rights Reserved.
 */

package util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The Interface DataProviderArguments.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DataProviderArguments {
	String path();
}
