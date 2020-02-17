package com.srisai.srisaispringsecurityauthprovider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class CustomAuthentication implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        grantedAuthorities.add( new SimpleGrantedAuthority("ADMIN") );
//        grantedAuthorities.add(new SimpleGrantedAuthority(userOptional.get().role));
//        Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuthorities);
//        return auth;

        if (userName.equalsIgnoreCase("srisai") && password.equals("shirdi")) {           // replace your custom code here for custom authentication
            grantedAuthorities.add( new SimpleGrantedAuthority("ROLE_ADMIN") );
            return new UsernamePasswordAuthenticationToken(userName, password, grantedAuthorities);
        }
        else if (userName.equalsIgnoreCase("jayakar") && password.equals("thupili")) {
            grantedAuthorities.add( new SimpleGrantedAuthority("ROLE_USER") );
            return new UsernamePasswordAuthenticationToken(userName, password, grantedAuthorities);
        }
        else {
            throw new BadCredentialsException("External system authentication failed");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
