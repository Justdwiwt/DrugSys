package com.sxdxswxy.drugsys.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 使用 Swagger 2 构建 RESTful APIs
 * <p>开启地址:http://localhost:8081/swagger-ui.html</p>
 *
 * @author Justdwiwt
 */
@Configuration  // 启动时加载此类
@EnableSwagger2 // 表示此项目启用 Swagger API 文档
public class SwaggerConfig {

    /**
     * 启动时初始化，返回实例 Docket
     *
     * @return Docket（Swagger API 摘要）
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 配置包路径,此路径下的 Controller 类才会自动生成 Swagger API 文档
                .apis(RequestHandlerSelectors.basePackage("com.sxdxswxy.drugsys"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置页面展示的基本信息
     *
     * @return pageInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DrugManagerSystemAPI")
                .description("DrugSys API 1.0 操作文档")
                //服务条款网址
                .termsOfServiceUrl("https://github.com/Justdwiwt")
                .version("1.0")
                .contact(new Contact("Justdwiwt", "https://github.com/Justdwiwt",
                        "justdwiwt@gmail.com"))
                .build();
    }

}
