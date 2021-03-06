package com.backbase.goldensample.store.configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


import com.backbase.buildingblocks.backend.communication.http.HttpCommunicationConfiguration;
import com.backbase.goldensample.store.config.StoreIntegrationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

class AppConfigurationTest {

    /*
     * Setup a context runner with the class StoreIntegrationConfig
     * in it. For that, I use ApplicationContextRunner#withUserConfiguration()
     * methods to populate the context.
     */
    ApplicationContextRunner context = new ApplicationContextRunner()
         .withUserConfiguration(HttpCommunicationConfiguration.class)
        .withUserConfiguration(StoreIntegrationConfig.class)
        .withPropertyValues("app.product-service.host=localhost"
            , "app.product-service.port=8080"
            , "app.review-service.host=localhost"
            , "app.review-service.port=8080");

    @Test
    void should_check_presence_of_example_service() {
        /*
         * We start the context and we will be able to trigger
         * assertions in a lambda receiving a
         * AssertableApplicationContext
         */
        context.run(it -> {
            /*
             * We can use assertThat to assert on the context
             * and check if the @Beans configured are present
             */
            assertAll(
                () -> assertThat(it).hasBean("accessProviderRestTemplate")
                    .as("RestTemplate bean is required to inject Sleuth headers. Don't use 'new RestTemplate()'"),
                () -> assertThat(it).hasBean("productServiceImplApi"),
                () -> assertThat(it).hasBean("reviewServiceImplApi"),
                () -> assertThat(it).hasBean("apiClient"),
                () -> assertThat(it).hasBean("apiReviewClient"));
        });
    }
}
