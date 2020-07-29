package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class MyInfo implements InfoContributor {

	@Value("${application.name}")
	private String applicationName;

	@Value("${build.version}")
	private String buildVersion;

	@Value("${build.timestamp}")
	private String buildTimestamp;
	
	@Value("${build.description}")
	private String buildDescricao;

	private MyInfoObject myInfoObject;

	@Override
	public void contribute(Builder builder) {
		myInfoObject = new MyInfoObject();
		myInfoObject.setApplicationName(applicationName);
		myInfoObject.setApplicationVersion(buildVersion);
		myInfoObject.setTimeStamp(buildTimestamp);
		myInfoObject.setDescricao(buildDescricao);
		builder.withDetail("infoSystem", myInfoObject);
	}

}
