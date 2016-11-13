package org.springframe.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanUtil implements ApplicationContextAware {  
    
  private static ApplicationContext applicationContext;  
    
  @Override  
  public void setApplicationContext(ApplicationContext context)  
      throws BeansException {  
	  SpringBeanUtil.applicationContext = context;  
  }  
  public static Object getBean(String name){  
      return applicationContext.getBean(name);  
  }  
}  
