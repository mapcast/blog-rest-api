package com.transplate.project.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.transplate.project.service.user.UserDetailService;
import com.transplate.project.util.TokenUtil;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {
	
	private final TokenUtil tokenUtil;
	
	private final UserDetailService userDetailService;
		
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String path = request.getRequestURI();
		
		if(path.startsWith("/swagger") || path.startsWith("/v2") || request.getMethod().equals("GET")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		final String authorizationHeader = request.getHeader("Authorization");
        String token = null;
        HttpSession session = request.getSession();
        
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        	token = authorizationHeader.substring(7);
        }
        
        String userId = tokenUtil.getUserNameFromToken(token);
        if (userId == null) {
            return;
        }
        
        UserDetails userDetails = userDetailService.getUserByUserId(userId);
        
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                    = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            session.setAttribute("userId", userId);
        }
        
        filterChain.doFilter(request, response);
		
	}

}
