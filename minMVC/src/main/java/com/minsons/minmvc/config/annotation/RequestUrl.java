package com.minsons.minmvc.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
@Documented
public @interface RequestUrl {

	public String value();
	
}
