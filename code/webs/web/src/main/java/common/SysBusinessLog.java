package common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/****************************************
 * 系统业务日志注解类
 * @author Arthur
 * @since 2015-02-26
 * @version 1.2
 *
 ****************************************/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysBusinessLog {
	String remark() default "";//用于业务方法日志描述
}
