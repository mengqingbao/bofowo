package common.security.login;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bofowo.site.model.AccountModel;
import com.bofowo.site.service.AccountService;
import common.util.StringUtil;

public class UamUserDetailService implements UserDetailsService {

	@Resource
	private AccountService accountService;

	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		AccountModel member = accountService.getByUsername(username);

		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_member");
		
		String nick=StringUtil.getMaskPhone(username);

		
		//accountService.setNewbieTask(userInfo,member);
		AuthTaken taken = new AuthTaken(member,nick,"",roles);
		
		
		
		
		
		return taken;
	}

}
