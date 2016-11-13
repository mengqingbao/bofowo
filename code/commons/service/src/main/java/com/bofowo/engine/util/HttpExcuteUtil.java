package com.bofowo.engine.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

public class HttpExcuteUtil {
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

}
