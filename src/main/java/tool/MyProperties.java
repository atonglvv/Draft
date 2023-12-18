package tool;

import java.util.Date;
import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @description  属性文件工具类,支持缓存及刷新
 * @author atong
 * @date 9:31 2021/4/8
 * @version 1.0.0.1
 **/
public class MyProperties {

	private static HashMap<String, MyProperties> configMap = new HashMap<String, MyProperties>();

	private Date loadTime = null;
	private ResourceBundle rb = null;
	private static final String CONFIG_FILE = "properties";
	/** 缓存1分钟 */
	private static final long CONFIG_CACHE_TIME = 60 * 1000;

	private MyProperties(String name) {
		this.loadTime = new Date();
		this.rb = ResourceBundle.getBundle(name);
	}

	public static synchronized MyProperties getInstance(String name) {
		MyProperties conf = configMap.get(name);
		if (null == conf) {
			conf = new MyProperties(name);
			configMap.put(name, conf);
			return conf;
		}
		if (System.currentTimeMillis() - conf.getLoadTime().getTime() > CONFIG_CACHE_TIME) {
			conf = new MyProperties(name);
			configMap.put(name, conf);
			return conf;
		}
		return conf;
	}

	public static synchronized MyProperties getInstance() {
		return getInstance("config");
	}

	public Date getLoadTime() {
		return loadTime;
	}

	public String getValue(String key) {
		try {
			String v = rb.getString(key);
			return v;
		}catch (MissingResourceException e) {
			return "";
		}
	}

	public boolean getBool(String key) {
		String v = getValue(key);
		return "true".equalsIgnoreCase(v);
	}

	public int getInt(String key) {
		String v = getValue(key);
		return Integer.parseInt(v);
	}

	public long getLong(String key) {
		String v = getValue(key);
		return Long.parseLong(v);
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i=0; i<10; i++) {
			String v = MyProperties.getInstance("common").getValue("jdbc.jndi.name");
			Thread.sleep(1000 * 30);
		}

	}

}
