package common;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
public class MD5Util {
	private  static Logger log = LoggerFactory.getLogger(MD5Util.class);
    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
    public static void main(String[] args) {
//        System.out.println(MD5Util.MD5("123456"));
//        System.out.println(MD5Util.MD5("12345678"));
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String jiemiValue = md5.encodePassword("1", null);
		System.out.println(jiemiValue);
//		String validateNo= Math.random(); 
//		System.out.println(String.valueOf(Math.random()*900000+1).substring(0,6));
		long currentTime = System.currentTimeMillis();
	    
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
		    
		Date date = new Date(currentTime);
		    
		System.out.println(formatter.format(date));
    }
}