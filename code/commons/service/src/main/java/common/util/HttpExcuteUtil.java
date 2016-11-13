package common.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpExcuteUtil {
	
	private  static Logger log = LoggerFactory.getLogger(HttpExcuteUtil.class);
	private static HttpClient getInstance() throws KeyManagementException,
			NoSuchAlgorithmException {
		HttpClient client = new DefaultHttpClient();
		SSLContext ctx = SSLContext.getInstance("SSL");
		// SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(null, new TrustManager[] { trustManager }, null);
		SSLSocketFactory ssf = new SSLSocketFactory(ctx);
		// 忽略掉HostName的比较，否则访问部分地址可能会报异常
		ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		ClientConnectionManager ccm = client.getConnectionManager();
		SchemeRegistry sr = ccm.getSchemeRegistry();
		sr.register(new Scheme("https", 443, ssf));
		client = new DefaultHttpClient(ccm, client.getParams());
		return client;
	}
	public static String getContent(String url, BasicHttpParams params,
			List<NameValuePair> formParams, boolean isGet) throws IOException {
		HttpClient httpclient = null;
		try {
			httpclient = getInstance();
		} catch (KeyManagementException e1) {
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}

		HttpResponse response = null;
		if (isGet) {
			HttpGet method = new HttpGet(url); 
			try {
				
				response = httpclient.execute(method);
			} catch (ClientProtocolException e) {
				throw e;
			} catch (IOException e) {
				throw e;
			}
		} else {
			HttpPost method = new HttpPost(url);
			try {
				method.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				throw e1;
			}
			try {
				method.setHeader("Content-Type",
						"application/x-www-form-urlencoded");
				method.setParams(params);
				response = httpclient.execute(method);
			} catch (ClientProtocolException e) {
				throw e;
			} catch (IOException e) {
				throw e;
			}
		}

		int statusCode = 0;

		HttpEntity resEntity = response.getEntity();
		InputStream in = null;
		StringBuffer contentBuffer = new StringBuffer();
		try {
			in = resEntity.getContent();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String inputLine = null;
			while ((inputLine = reader.readLine()) != null) {
				contentBuffer.append(inputLine);
			}
			/*
			 * JSONObject jsonobj = JSONObject
			 * .fromObject(contentBuffer.toString());
			 */
			return contentBuffer.toString();
			// return jsonobj;
		} catch (IllegalStateException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
			if (httpclient != null) {
				httpclient.getConnectionManager().shutdown();
			}
		}
	}

	private static X509TrustManager trustManager = new X509TrustManager() {
		public void checkClientTrusted1(X509Certificate[] xcs, String string)
				throws CertificateException {
		}

		public void checkServerTrusted1(X509Certificate[] xcs, String string)
				throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException {

		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException {
		}
	};

	/**
	 * 
	* @Title: basePostURL
	* @Description: TODO(使用原生HttpURLConnection发送请求，清楚缓存)
	* @param @param strUrl
	* @param @param params
	* @param @return
	* @param @throws IOException    设定文件
	* @return String    返回类型
	* @author ChenXun
	* @date 2015年4月29日
	* @throws
	 */
	public static String basePostURL(String strUrl, String params) throws IOException {

		URL url = null;
		HttpURLConnection connection = null;

		try {
			url = new URL(strUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.connect();

			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.writeBytes(params);
			out.flush();
			out.close();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	
	}

	
	public static String paraTo16(String str) throws UnsupportedEncodingException {
		String hs = "";

		byte[] byStr = str.getBytes("GB2312");
		for (int i = 0; i < byStr.length; i++) {
			String temp = "";
			temp = (Integer.toHexString(byStr[i] & 0xFF));
			if (temp.length() == 1)
				temp = "%0" + temp;
			else
				temp = "%" + temp;
			hs = hs + temp;
		}
		return hs.toUpperCase();

	}
	

	
	
	
	
	
	public static void main(String[] args) throws Exception {
		
//	   InputStream inStream=HttpExcuteUtil.class.getClassLoader().getSystemResourceAsStream("sms.properties");
//		
//		
//		Properties p=new Properties();
//		p.load(inStream);
//		String strSmsUrl =p.getProperty("sms_url");
//		String strReg = p.getProperty("sms_reg"); // 注册号（由华兴软通提供）
//		String strAccount =p.getProperty("sms_account");
//		String strPwd = p.getProperty("sms_pwd"); // 密码（由华兴软通提供）   //md5加密
		
		String phoneNO="15216614939";
		String content="test12323214214";
		 content+="【律云科技】";
		 content = paraTo16(content);
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("grant_type", "client_credentials");
			jsonObject.put("client_id", "YXA6JOMWlLap_YbI_ucz77j-4-mI0dd");
		//String strSmsParam = "account=" + strAccount + "&userid=" + strReg + "&password=" + strPwd + "&mobile=" + phoneNO + "&content=" + content;
		 String strSmsParam = "data=" + jsonObject.toString();
		 System.out.println(strSmsParam);
		 String message=basePostURL("http://a1.easemob.com/easemob-demo/chatdemoui/token",strSmsParam );
//		String message=basePostURL("http://192.168.0.243:8787/app/query-memo-detail.json",strSmsParam );
		Document doc=  DocumentHelper.parseText(message);
		String result=doc.selectSingleNode("//").getText(); //xpath
		if("ok".equals(result.trim())){
			//验证码存到session  
			
		}
		else{
			
		}
		
		
		
		
	}
	
	

}
