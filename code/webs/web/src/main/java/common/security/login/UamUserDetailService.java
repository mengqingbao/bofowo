package common.security.login;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bofowo.site.model.AccountModel;
import com.bofowo.site.model.ShopModel;
import com.bofowo.site.service.AccountService;
import com.bofowo.site.service.ShopService;
import common.util.StringUtil;

public class UamUserDetailService implements UserDetailsService {

	@Resource
	private AccountService accountService;
	
	@Resource
	private ShopService shopService;

	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		AccountModel member = accountService.getByUsername(username);

		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_member");
		
		String nick=StringUtil.getMaskPhone(username);
		int shopId=0;
		ShopModel shop=shopService.getByUsername(username);
		if(shop!=null){
			shopId=shop.getId();
		}
		
		//accountService.setNewbieTask(userInfo,member);
		AuthTaken taken = new AuthTaken(member,nick,"",roles,shopId);
		
		
		
		
		
		return taken;
	}

}
