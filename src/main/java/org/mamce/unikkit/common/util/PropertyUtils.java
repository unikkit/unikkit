package org.mamce.unikkit.common.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class PropertyUtils {

	public static final Logger LOGGER = Logger.getLogger(PropertyUtils.class);
	private static Properties props;
	
	static {
		
		if(props == null) {
			Resource resource = new ClassPathResource(Constants.UNIKK_PROPS_FILE);
			try {
				props = PropertiesLoaderUtils.loadProperties(resource);
				LOGGER.info("unikk properties loaded!");
			} catch (IOException e) {
				LOGGER.fatal("Error loading property file", e);
			}
		}
	
	}
	
	/**
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}
	
	/**
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getProperty(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}
	
	/**
	 * @param key
	 * @return
	 */
	public static Object getObject(Object key) {
		return props.get(key);
	}
}
