package com.sdhdata;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ArchivoConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		     //DESARROLLO
		registry.addResourceHandler("/VerificableBienes/**").addResourceLocations("file:/C:/DATASDH/DATASPI/VerificableBienes/");
		registry.addResourceHandler("/VerificableSPI/**").addResourceLocations("file:/C:/DATASDH/DATASPI/VerificableSPI/");
		registry.addResourceHandler("/User/**").addResourceLocations("file:/C:/DATASDH/DATASPI/User/"); 
		registry.addResourceHandler("/InformesEquipo/**").addResourceLocations("file:/C:/DATASDH/INVENTARIO/InformesEquipo/");
		registry.addResourceHandler("/InformesPeriferico/**").addResourceLocations("file:/C:/DATASDH/INVENTARIO/InformesPeriferico/");
		
		
		      //SERVIDORES
	    //registry.addResourceHandler("/VerificableBienes/**").addResourceLocations("file:/opt/DATASDH/DATASPI/VerificableBienes/");
	    //registry.addResourceHandler("/VerificableSPI/**").addResourceLocations("file:/opt/DATASDH/DATASPI/VerificableSPI/");
		//registry.addResourceHandler("/User/**").addResourceLocations("file:/opt/DATASDH/DATASPI/User/"); 
		//registry.addResourceHandler("/InformesEquipo/**").addResourceLocations("file:/opt/DATASDH/INVENTARIO/InformesEquipo/");
		//registry.addResourceHandler("/InformesPeriferico/**").addResourceLocations("file:/opt/DATASDH/INVENTARIO/InformesPeriferico/");
		 
	}	

}
