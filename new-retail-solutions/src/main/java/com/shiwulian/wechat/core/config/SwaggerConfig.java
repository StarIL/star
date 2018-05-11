package com.shiwulian.wechat.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Bean
	public Docket createRestApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		ApiInfo apiInfo = new ApiInfoBuilder().title("wechat接口").description("wechat接口").version("1.0") .build();
		docket.apiInfo(apiInfo);
		docket.select()
		.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)) //对应controller@Api
		.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) //对应controller下方法@ApiOperation
		.apis(RequestHandlerSelectors.basePackage("com.shiwulian.wechat.controller")).build();
		return docket;
	}
}
