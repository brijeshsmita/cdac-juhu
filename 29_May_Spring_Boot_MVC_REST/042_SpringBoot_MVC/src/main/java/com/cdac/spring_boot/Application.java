package com.cdac.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
/* @SpringBootApplication provides alias for the following two annotation
 * 
 *			 @EnableAutoConfigurtion (auto-config)
 * 			 @ComponentScan (component scan base-package)
 * SpringApplication class provides static run method to bootstrap 
 * and launch the application class which has been annotated with
 * @SpringBootApplication 
 */
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
