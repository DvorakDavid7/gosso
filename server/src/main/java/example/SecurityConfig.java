package example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.saml2.provider.service.registration.InMemoryRelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrations;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public RelyingPartyRegistrationRepository relyingPartyRegistrations() {
        RelyingPartyRegistration azureRegistration = RelyingPartyRegistrations
                .fromMetadataLocation("https://login.microsoftonline.com/67b7de17-01a8-410a-a645-3eacd61c1111/federationmetadata/2007-06/federationmetadata.xml?appid=732b721a-d7c7-4647-9f0d-84f8cc2b205f")
                .registrationId("azure")
                .build();

        RelyingPartyRegistration oktaRegistration = RelyingPartyRegistrations
                .fromMetadataLocation("https://dev-90054128.okta.com/app/exk87n1a4mz9OyrFP5d7/sso/saml/metadata")
                .registrationId("okta")
                .build();

        return new InMemoryRelyingPartyRegistrationRepository(oktaRegistration);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .saml2Login(saml2 -> saml2.relyingPartyRegistrationRepository(relyingPartyRegistrations()))
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .build();
    }
}