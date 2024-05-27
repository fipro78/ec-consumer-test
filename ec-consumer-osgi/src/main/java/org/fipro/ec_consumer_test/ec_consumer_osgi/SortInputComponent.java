package org.fipro.ec_consumer_test.ec_consumer_osgi;

import java.util.Map;
import java.util.logging.LogManager;

import org.fipro.ec_consumer_test.ec_consumer.CollectionsHelper;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class SortInputComponent {

	/**
	 * Launcher arguments provided by the bnd launcher.
	 */
	String[] launcherArgs;

	@Reference(target = "(launcher.arguments=*)")
	void setLauncherArguments(Object object, Map<String, Object> map) {
		this.launcherArgs = (String[]) map.get("launcher.arguments");
	}
	
	@Activate
	void activate() {
		LogManager.getLogManager().reset();
		
		CollectionsHelper.sort(launcherArgs).forEach(System.out::println);
		
		System.exit(0);
	}
}