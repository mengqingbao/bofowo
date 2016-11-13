package common.security.login;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bofowo.site.model.AdminModel;

import common.util.StringUtil;

public class UamUserDetailService implements UserDetailsService {



	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		AdminModel member = null;

		
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_member");
		
		String nick=StringUtil.getMaskPhone(username);

		//accountService.setNewbieTask(userInfo,member);
		AuthTaken taken = new AuthTaken(member,nick,"",roles);
		
		
		
		
		
		return taken;
	}

}
