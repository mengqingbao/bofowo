package common.security.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bofowo.site.model.AdminModel;

public class AuthTaken implements UserDetails {

	private Collection<GrantedAuthority> grantedAuthorities;
	private String username;
	private String password;
	private String status;
	private String nick;
	private String picture;

	public AuthTaken() {

	}

	public AuthTaken(AdminModel member,String nick,String picture,List<String> roles) {
		if(member!=null){
		username = member.getAdminusername();
		password = member.getAdminPasswd();
		status = "1";
		this.nick=nick;
		this.setPicture(picture);
		grantedAuthorities = new ArrayList<GrantedAuthority>();
		if (null != roles) {
			for (String role : roles) {
				GrantedAuthorityImpl ga = new GrantedAuthorityImpl(
						role);
				grantedAuthorities.add(ga);
			}
		}
		}
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		if ("1".equals(status)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Collection<GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(
			Collection<GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}