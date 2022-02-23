package dev.cfan.rocklifterapi.security;

//  Stolen from : https://git.generalassemb.ly/sureshmelvinsigera/Java-Spring/blob/master/README.md

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JpaUserService JPAUserService;

    @Autowired
    private JWTUtils jwtUtils;

    //When any api will be called this method will be called first and this will extract
    // Token from header pass to JWT Util calls for token details extraction  @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {

        final String AuthorizationHeader = httpServletRequest.getHeader("Authorization");

        String username = null;
        String jwt = null;

        //Checking if Bearer is present in Header or not because When sending api request with
        // token bearer should be present in that
        if (AuthorizationHeader != null && AuthorizationHeader.startsWith("Bearer ")) {
            jwt = AuthorizationHeader.substring(7);
            username = jwtUtils.extractUsername(jwt);
        }

        //Token is being passed to JwtUtil class for details extraction
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.JPAUserService.loadUserByUsername(username);
            if (jwtUtils.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken
                        usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
