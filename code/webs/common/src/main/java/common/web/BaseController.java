package common.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import common.util.LayoutType;


public class BaseController  {
	  	@Resource
	    protected HttpServletRequest request;
	    protected Logger log = LoggerFactory.getLogger(this.getClass());
	    public void setLayout(LayoutType type){
	    	request.setAttribute("layout", "layout/"+type.getMessage());
	    	request.setAttribute("selectedMenu",type.getCode());
	    }
		@InitBinder
		protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
				throws Exception {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 可以設定任意的日期格式
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			dateFormat2.setLenient(false);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// 格式化时间
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat2, true));
			binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));// 去掉空格
			binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
			binder.registerCustomEditor(long.class, new CustomNumberEditor(Long.class, true));
			
		}
		
		/*public int getUserId(){
			return CurrentUserUtil.getCurrentUserId();
		}*/
		
		public String getLanguage(){
			//set land
			Cookie[] cookies = request.getCookies();
			if(cookies!=null){
				for(Cookie cookie:cookies){
					if("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE".equals(cookie.getName())){
						 return cookie.getValue();
					}
				}
			}
			return "en_us";
		}
		
		public String redirectRefer(HttpServletRequest request){
				return "redirect:"+request.getHeader("referer");
		}
}
