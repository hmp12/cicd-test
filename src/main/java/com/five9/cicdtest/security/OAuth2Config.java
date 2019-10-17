//package com.five9.cicdtest.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//
//
//@Configuration
//
//public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
//    private String clientid = "hmp";
//    private String clientSecret = "dmm";
//    private String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA4vkblgB28SWm1g87MG8KZ4ZGJxBtACRafRr4CshIGhpwBEbvcp3D+JRVRX7c4ZEMwWIIkpXmdFqHcuhoIQzISQIDAQABAkEA3AaWilwa8XwJdls/ip0qHd9ZpEbVE50qJzr8lx8+XiXNZsPocVj37mKBsQuOwjn8qccCN3DpTF5noPehGJHxAQIhAPTYrLG49qz3Leboz7t/WGSzDFcjMPYK0t3gsvcgqLVpAiEA7U///3rkIMeZSqA/B5qG5fVkrc+O+OCMG2I4VZiMv+ECIF4h32MEZXHiJfeckiDXuLgeTiRCF1TAnIlJFgUEvVfhAiAO5o4JaZr3X/EFGYi7nn1H5R+cNkMg52CEu6cT4M89oQIhAIRNarabse/h5JCUUKB8Y2zwHGl2W6Y10lhtzT+xvwpJs";
//    private String publicKey = "public key";
//
//    @Autowired
//    @Qualifier("authenticationManagerBean")
//    private AuthenticationManager authenticationManager;
//
//    @Bean
//    public JwtAccessTokenConverter tokenEnhancer() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey(privateKey);
////        converter.setVerifierKey(publicKey);
//        return converter;
//    }
//
//    @Bean
//    public JwtTokenStore tokenStore() {
//        return new JwtTokenStore(tokenEnhancer());
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
//                .accessTokenConverter(tokenEnhancer());
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
////        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
//                .authorizedGrantTypes("password");
//
//    }
//}
