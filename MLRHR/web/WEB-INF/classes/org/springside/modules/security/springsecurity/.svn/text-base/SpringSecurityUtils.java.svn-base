/**
 * Copyright (c) 2005-2009 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: SpringSecurityUtils.java 1185 2010-08-29 15:56:19Z calvinxiu $
 */
package org.springside.modules.security.springsecurity;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

/**
 * SpringSecurity鐨勫伐鍏风被.
 * 
 * 娉ㄦ剰. 鏈被鍙敮鎸丼pringSecurity 3.0.x.
 * 
 * @author calvin
 */
public class SpringSecurityUtils {
	/**
	 * 鍙栧緱褰撳墠鐢ㄦ埛, 杩斿洖鍊间负SpringSecurity鐨刄ser绫绘垨鍏跺瓙绫� 濡傛灉褰撳墠鐢ㄦ埛鏈櫥褰曞垯杩斿洖null.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends User> T getCurrentUser() {
		Authentication authentication = getAuthentication();

		if (authentication == null) {
			return null;
		}

		Object principal = authentication.getPrincipal();
		if (!(principal instanceof User)) {
			return null;
		}

		return (T) principal;
	}

	/**
	 * 鍙栧緱褰撳墠鐢ㄦ埛鐨勭櫥褰曞悕, 濡傛灉褰撳墠鐢ㄦ埛鏈櫥褰曞垯杩斿洖绌哄瓧绗︿覆.
	 */
	public static String getCurrentUserName() {
		Authentication authentication = getAuthentication();

		if (authentication == null || authentication.getPrincipal() == null) {
			return "";
		}

		return authentication.getName();
	}
	
	/**
	 * 鍙栧緱褰撳墠鐢ㄦ埛鐧诲綍IP, 濡傛灉褰撳墠鐢ㄦ埛鏈櫥褰曞垯杩斿洖绌哄瓧绗︿覆.
	 */
	public static String getCurrentUserIp() {
		Authentication authentication = getAuthentication();

		if (authentication == null) {
			return "";
		}

		Object details = authentication.getDetails();
		if (!(details instanceof WebAuthenticationDetails)) {
			return "";
		}

		WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
		return webDetails.getRemoteAddress();
	}

	/**
	 * 鍒ゆ柇鐢ㄦ埛鏄惁鎷ユ湁瑙掕壊, 濡傛灉鐢ㄦ埛鎷ユ湁鍙傛暟涓殑浠绘剰涓�釜瑙掕壊鍒欒繑鍥瀟rue.
	 */
	public static boolean hasAnyRole(String... roles) {
		Authentication authentication = getAuthentication();
		
		if (authentication == null) {
			return false;
		}

		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> grantedAuthorityList = ( Collection<GrantedAuthority> ) authentication.getAuthorities();
		for (String role : roles) {
			for (GrantedAuthority authority : grantedAuthorityList) {
				if (role.equals(authority.getAuthority())) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 灏哢serDetails淇濆瓨鍒癝ecurity Context.
	 * 
	 * @param userDetails 宸插垵濮嬪寲濂界殑鐢ㄦ埛淇℃伅.
	 * @param request 鐢ㄤ簬鑾峰彇鐢ㄦ埛IP鍦板潃淇℃伅,鍙负Null.
	 */
	public static void saveUserDetailsToContext(UserDetails userDetails, HttpServletRequest request) {
		PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(userDetails,
				userDetails.getPassword(), userDetails.getAuthorities());

		if (request != null) {
			authentication.setDetails(new WebAuthenticationDetails(request));
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	/**
	 * 鍙栧緱Authentication, 濡傚綋鍓峉ecurityContext涓虹┖鏃惰繑鍥瀗ull.
	 */
	private static Authentication getAuthentication() {
		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			return null;
		}

		return context.getAuthentication();
	}
}
