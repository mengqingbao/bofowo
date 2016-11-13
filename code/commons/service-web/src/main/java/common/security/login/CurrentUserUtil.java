/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.security.login;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.bofowo.site.model.AccountModel;


/**
 * 功能描述：当前用户
 * @author winker
 * time : 2011-8-1 下午02:19:20
 */
public class CurrentUserUtil {

    public static String getCurrentUserName() {
    //	 SecurityContext context = getSecurityContext();
    	if(getAuthentication()!=null){
    	if(getAuthentication().getPrincipal() instanceof UserDetails){
    		UserDetails userdetails = (UserDetails) getAuthentication()
			    		    .getPrincipal();
			    	if(userdetails!=null){
			    		String username=userdetails.getUsername();
			    		return username;
					}else{
						return null;
					}    		 
    		  }
    	}
    	return null;

    }
    //正式姓名
    public static String getCurrentNick(){
    	if(getAuthentication().getPrincipal() instanceof AuthTaken){
    		AuthTaken userdetails = (AuthTaken) getAuthentication()
			    		    .getPrincipal();
			    	if(userdetails!=null){
			    		return userdetails.getNick();
					}else{
						return "";
					}    		 
    		  }else{
    			  
    			  return (String) getAuthentication().getPrincipal();
    		  }
    }
    public static String getCurrentSecret() {
    	return (String) getAuthentication().getCredentials();
    //	 SecurityContext context = getSecurityContext();
    	/*if(getAuthentication().getPrincipal() instanceof CspUserDetail){
    		CspUserDetail userdetails = (CspUserDetail) getAuthentication()
			    		    .getPrincipal();
			    	if(userdetails!=null){
					return userdetails.getPassword();
					}else{
						return null;
					}    		 
    		  }else{
    			  
    			  return (String) getAuthentication().getCredentials();
    		  }*/

    }
    
   
    public static SecurityContext getSecurityContext(){
    	return SecurityContextHolder.getContext();
    }
    
    public static Authentication getAuthentication(){
    	return getSecurityContext().getAuthentication();
    }
    
    /**
     * 动态修改内存中的权限
     * @param au
     */
  
    /**
     * 判断用户是否登录
     * @return
     */
    public static boolean isAuthority(){
    	SecurityContext context = getSecurityContext();
    	Authentication authentication = getAuthentication();
    		if(authentication==null){ 
    			return false;
    		}
    	if(!(authentication.getPrincipal() instanceof AuthTaken)){
			return false;
		}else{
			return true;
		}
    }

	public static void removeGrantedAuthority(String au) {
		SecurityContext context = getSecurityContext();
    	Authentication authentication = context.getAuthentication();
    	AuthTaken auth = (AuthTaken) authentication.getPrincipal();
    	Collection<GrantedAuthority> ags= (Collection<GrantedAuthority>) auth.getAuthorities();
    	ags.remove(new GrantedAuthorityImpl(au));
    	auth.setGrantedAuthorities(ags);
    	Authentication newauthentication = new UsernamePasswordAuthenticationToken(auth, authentication.getCredentials());
    	context.setAuthentication(newauthentication);
	}

}
