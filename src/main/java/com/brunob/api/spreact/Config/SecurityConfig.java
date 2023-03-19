package com.brunob.api.spreact.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.env.Environment;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private static final String[] PUBLIC_MATCHERS = {"/h2-console/**"}; //seta um array de string com url's liberadas
//
//    @Autowired
//    private Environment env; // permite pegar o perfil que esta sendo utilizado (teste,dev,etc)
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////        if(Arrays.asList(env.getActiveProfiles()).contains("test")){
////           http.headers().frameOptions().disable(); // Após verificar se o perfil usado é test libera acesso total, serve pra poder liberar acesso ao banco h2 por exemplo
////        }
//
//        http.cors().and().csrf().disable();//seta a config do cors + desabilita proteção contra ataque csrf uma vez que não estaremos fazendo controle de sessão
//
////        http.authorizeRequests()
////                        .antMatchers(PUBLIC_MATCHERS).permitAll() // responsável por liberar acesso a toda url que contem essas string's
////                        .anyRequest().authenticated(); // bloqueia todo o resto dos endpoints
//
////        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//garante que não será feito controle de sessão setando pra STATELESS(sem estado)
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource(){//aqui é feita toda config básica pra segurança geral do backend
//        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//        corsConfiguration.setAllowedMethods(Arrays.asList("POST","GET","DELETE","PUT","OPTIONS")); //estes verbose's estão sendo habilitados
//        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration); //setando a config pra todo o back via /**
//        return urlBasedCorsConfigurationSource;
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder(); // libera acesso no back inteiro ao método pra criptografar senhas
//    }
//}
