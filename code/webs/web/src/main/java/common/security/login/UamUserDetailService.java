package common.security.login;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bofowo.site.model.UserModel;
import com.bofowo.site.service.UserService;

import common.util.StringUtil;

public class UamUserDetailService implements UserDetailsService {

//	@Resource
//	private UserService userService;

	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserModel member = null;//userService.loadByUserName(username);

		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_member");
		
		String nick=StringUtil.getMaskPhone(username);

		
		//accountService.setNewbieTask(userInfo,member);
		AuthTaken taken = new AuthTaken(member,nick,"",roles);
		
		
		
		
		
		return taken;
	}

}
