package com.easemob.server.example.httpclient.apidemo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.easemob.server.example.comm.Constants;
import com.easemob.server.example.comm.HTTPMethod;
import com.easemob.server.example.comm.Roles;
import com.easemob.server.example.httpclient.utils.HTTPClientUtils;
import com.easemob.server.example.httpclient.vo.ClientSecretCredential;
import com.easemob.server.example.httpclient.vo.Credential;
import com.easemob.server.example.httpclient.vo.EndPoints;

/**
 * REST API Demo :用户体系集成 REST API HttpClient4.3实现
 * 
 * Doc URL: http://www.easemob.com/docs/rest/userapi
 * 
 * @author Lynch 2014-09-15
 * 
 */
public class EasemobIMUsers {

	private static Logger LOGGER = LoggerFactory.getLogger(EasemobIMUsers.class);

    // 通过app的client_id和client_secret来获取app管理员token
    private static Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
            Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);

    public static void main(String[] args) {
        /**
         * 注册IM用户[单个]
         */
//    	JSONObject datanode = new JSONObject();
//        datanode.put("username","13761732024");
    	Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String md5Password = md5.encodePassword("abc123456", null);
//        datanode.put("password", md5Password);
        System.out.println(md5Password);
//        JSONObject createNewIMUserSingleNode = createNewIMUserSingle(datanode);
//        if (null != createNewIMUserSingleNode) {
//            LOGGER.info("注册IM用户[单个]: " + createNewIMUserSingleNode.toString());
//        }

        /**
         * IM用户登录
//         */
//        JSONObject imUserLoginNode = imUserLogin("13761732024", "7fe51b13499ad08aba40a93cbf6e98cd");
//        if (null != imUserLoginNode) {
//            LOGGER.info("IM用户登录: " + imUserLoginNode.toString());
//        }
//        JSONObject imUserLoginNode = imUserLogin("13916030397", "0659c7992e268962384eb17fafe88364");
//        if (null != imUserLoginNode) {
//            LOGGER.info("IM用户登录: " + imUserLoginNode.toString());
//        }

//        /**
//         * 注册IM用户[批量生成用户然后注册]
//         */
//        String usernamePrefix = "kenshinnuser";
//        Long perNumber = 10l;
//        Long totalNumber = 100l;
//        JSONObject createNewIMUserBatchGenNode = createNewIMUserBatchGen(usernamePrefix, perNumber, totalNumber);
//        if (null != createNewIMUserBatchGenNode) {
//            LOGGER.info("注册IM用户[批量]: " + createNewIMUserBatchGenNode.toString());
//        }
//
////        /**
////         * 获取IM用户[主键查询]
////         */
//        String userPrimaryKey = "18168117208";
//        JSONObject getIMUsersByPrimaryKeyNode = getIMUsersByPrimaryKey(userPrimaryKey);
//        if (null != getIMUsersByPrimaryKeyNode) {
//            LOGGER.info("获取IM用户[主键查询]: " + getIMUsersByPrimaryKeyNode.toString());
//        }
//        System.out.println(getIMUsersByPrimaryKeyNode.get("statusCode"));
//
//        /**
//         * 重置IM用户密码 提供管理员token
//         */
//		String username = "18168117208";
//		JSONObject json2 = new JSONObject();
//        json2.put("newpassword", "96e79218965eb72c92a549dd5a330112");
//        JSONObject modifyIMUserPasswordWithAdminTokenNode = modifyIMUserPasswordWithAdminToken(username, json2);
//        if (null != modifyIMUserPasswordWithAdminTokenNode) {
//            LOGGER.info("重置IM用户密码 提供管理员token: " + modifyIMUserPasswordWithAdminTokenNode.toString());
//        }
//        JSONObject imUserLoginNode2 = imUserLogin(username, json2.get("newpassword").toString());
//        if (null != imUserLoginNode2) {
//            LOGGER.info("重置IM用户密码后,IM用户登录: " + imUserLoginNode2.toString());
//        }
//
//        /**
//         * 添加好友[单个]
//         */
//        String ownerUserPrimaryKey = username;
//        String friendUserPrimaryKey = "kenshinnuser099";
//        JSONObject addFriendSingleNode = addFriendSingle(ownerUserPrimaryKey, friendUserPrimaryKey);
//        if (null != addFriendSingleNode) {
//            LOGGER.info("添加好友[单个]: " + addFriendSingleNode.toString());
//        }
//
        /**
         * 查看好友
         */
        JSONObject getFriendsNode = getFriends("15601920157");
        if (null != getFriendsNode) {
            LOGGER.info("查看好友: " + getFriendsNode.toString());
        }
//
//        /**
//         * 解除好友关系
//         **/
//        JSONObject deleteFriendSingleNode = deleteFriendSingle(ownerUserPrimaryKey, friendUserPrimaryKey);
//        if (null != deleteFriendSingleNode) {
//            LOGGER.info("解除好友关系: " + deleteFriendSingleNode.toString());
//        }
//
//        /**
//         * 删除IM用户[单个]
//         */
//        JSONObject deleteIMUserByUserPrimaryKeyNode = deleteIMUserByUserPrimaryKey(userPrimaryKey);
//        if (null != deleteIMUserByUserPrimaryKeyNode) {
//            LOGGER.info("删除IM用户[单个]: " + deleteIMUserByUserPrimaryKeyNode.toString());
//        }
//
//        /**
//         * 删除IM用户[批量]
//         */
//        Long limit = 2l;
//        JSONObject deleteIMUserByUsernameBatchNode = deleteIMUserByUsernameBatch(limit, null);
//        if (null != deleteIMUserByUsernameBatchNode) {
//            LOGGER.info("删除IM用户[批量]: " + deleteIMUserByUsernameBatchNode.toString());
//        }
    }

    /**
	 * 注册IM用户[单个]
	 * 
	 * 给指定Constants.APPKEY创建一个新的用户
	 * 
	 * @param dataNode
	 * @return
	 */
	public static JSONObject createNewIMUserSingle(JSONObject dataNode) {

		JSONObject objectNode = new JSONObject();

		// check Constants.APPKEY format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Constants.APPKEY");

			return objectNode;
		}


		// check properties that must be provided
		if (null != dataNode && !dataNode.has("username")) {
			LOGGER.error("Property that named username must be provided .");

			objectNode.put("message", "Property that named username must be provided .");

			return objectNode;
		}
		if (null != dataNode && !dataNode.has("password")) {
			LOGGER.error("Property that named password must be provided .");

			objectNode.put("message", "Property that named password must be provided .");

			return objectNode;
		}

		try {

		    objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.USERS_URL, credential, dataNode,
					HTTPMethod.METHOD_POST);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return objectNode;
	}

	/**
	 * 注册IM用户[批量]
	 * 
	 * 给指定Constants.APPKEY创建一批用户
	 * 
	 * @param dataArrayNode
	 * @return
	 */
	public static JSONObject createNewIMUserBatch(ArrayNode dataArrayNode) {

		JSONObject objectNode = new JSONObject ();

		// check Constants.APPKEY format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Constants.APPKEY");

			return objectNode;
		}

		// check properties that must be provided
		if (dataArrayNode.isArray()) {
			for (JsonNode jsonNode : dataArrayNode) {
				if (null != jsonNode && !jsonNode.has("username")) {
					LOGGER.error("Property that named username must be provided .");

					objectNode.put("message", "Property that named username must be provided .");

					return objectNode;
				}
				if (null != jsonNode && !jsonNode.has("password")) {
					LOGGER.error("Property that named password must be provided .");

					objectNode.put("message", "Property that named password must be provided .");

					return objectNode;
				}
			}
		}

		try {

			objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.USERS_URL, credential, dataArrayNode,
					HTTPMethod.METHOD_POST);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return objectNode;
	}

	/**
	 * 注册IM用户[批量生成用户然后注册]
	 * 
	 * 给指定Constants.APPKEY创建一批用户
	 * 
	 * @param usernamePrefix
	 *            生成用户名的前缀
	 * @param perNumber
	 *            批量注册时一次注册的数量
	 * @param totalNumber
	 *            生成用户注册的用户总数
	 * @return
	 */
	public static JSONObject createNewIMUserBatchGen(String usernamePrefix, Long perNumber, Long totalNumber) {
		JSONObject objectNode = new JSONObject ();

//		if (totalNumber == 0 || perNumber == 0) {
//			return objectNode;
//		}
//		System.out.println("你即将注册" + totalNumber + "个用户，如果大于" + perNumber + "了,会分批注册,每次注册" + perNumber + "个");
//		List genericArrayNode = EasemobIMUsers.genericArrayNode(usernamePrefix, totalNumber);
//		if (totalNumber <= perNumber) {
//			objectNode = EasemobIMUsers.createNewIMUserBatch(genericArrayNode);
//		} else {
//
//			List tmpArrayNode = new ArrayList();
//			
//			for (int i = 0; i < genericArrayNode.size(); i++) {
//				tmpArrayNode.add(genericArrayNode.get(i));
//				// 300 records on one migration
//				if ((i + 1) % perNumber == 0) {
//					objectNode = EasemobIMUsers.createNewIMUserBatch(tmpArrayNode);
//					if(objectNode!=null){
//						LOGGER.info("注册IM用户[批量]: " + objectNode.toString());
//					}
//					tmpArrayNode.removeAll(null);
//					continue;
//				}
//
//				// the rest records that less than the times of 300
//				if (i > (genericArrayNode.size() / perNumber * perNumber - 1)) {
//					objectNode = EasemobIMUsers.createNewIMUserBatch(tmpArrayNode);
//					if(objectNode!=null){
//						LOGGER.info("注册IM用户[批量]: " + objectNode.toString());
//					}
//					tmpArrayNode.removeAll(null);
//				}
//			}
//		}

		return objectNode;
	}

	/**
	 * 获取IM用户
	 * 
	 * @param userPrimaryKey
	 *            用户主键：username或者uuid
	 * @return
	 */
	public static JSONObject getIMUsersByPrimaryKey(String userPrimaryKey) {
		JSONObject objectNode = new JSONObject ();

		// check Constants.APPKEY format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Constants.APPKEY");

			return objectNode;
		}

		// check properties that must be provided
		if (StringUtils.isEmpty(userPrimaryKey)) {
			LOGGER.error("The primaryKey that will be useed to query must be provided .");

			objectNode.put("message", "The primaryKey that will be useed to query must be provided .");

			return objectNode;
		}

		try {

			URL userPrimaryUrl = HTTPClientUtils
					.getURL(Constants.APPKEY.replace("#", "/") + "/users/" + userPrimaryKey);
			objectNode = HTTPClientUtils.sendHTTPRequest(userPrimaryUrl, credential, null, HTTPMethod.METHOD_GET);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return objectNode;
	}

	/**
	 * 删除IM用户[单个]
	 * 
	 * 删除指定Constants.APPKEY下IM单个用户
	 *
	 * 
	 * @param userPrimaryKey
	 * @return
	 */
	public static JSONObject deleteIMUserByUserPrimaryKey(String userPrimaryKey) {
		JSONObject objectNode = new JSONObject ();

		// check Constants.APPKEY format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Constants.APPKEY");

			return objectNode;
		}

		try {

			URL deleteUserPrimaryUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/users/"
					+ userPrimaryKey);
			objectNode = HTTPClientUtils.sendHTTPRequest(deleteUserPrimaryUrl, credential, null,
					HTTPMethod.METHOD_DELETE);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return objectNode;
	}

	/**
	 * 删除IM用户[批量]
	 * 
	 * 批量指定Constants.APPKEY下删除IM用户
	 * 
	 * @param limit
	 * @param queryStr
	 * @return
	 */
	public static JSONObject deleteIMUserByUsernameBatch(Long limit, String queryStr) {

		JSONObject objectNode = new JSONObject ();

		// check Constants.APPKEY format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Constants.APPKEY");

			return objectNode;
		}
		if (StringUtils.isEmpty(queryStr)) {
			LOGGER.error("queryStr must be provided .");

			objectNode.put("message", "queryStr must be provided .");

			return objectNode;
		}

		try {

			URL deleteIMUserByUsernameBatchUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/users"
					+ "?ql=" + queryStr + "&limit=" + limit);
			objectNode = HTTPClientUtils.sendHTTPRequest(deleteIMUserByUsernameBatchUrl, credential, null,
					HTTPMethod.METHOD_DELETE);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return objectNode;
	}

	/**
	 * 重置IM用户密码 提供管理员token
	 * 
	 * @param userPrimaryKey
	 * @param dataObjectNode
	 * @return
	 */
	public static JSONObject modifyIMUserPasswordWithAdminToken(String userPrimaryKey, JSONObject dataObjectNode) {
		JSONObject objectNode = new JSONObject ();

		// check Constants.APPKEY format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Constants.APPKEY");

			return objectNode;
		}

		if (StringUtils.isEmpty(userPrimaryKey)) {
			LOGGER.error("Property that named userPrimaryKey must be provided，the value is username or uuid of imuser.");

			objectNode.put("message",
					"Property that named userPrimaryKey must be provided，the value is username or uuid of imuser.");

			return objectNode;
		}

		if (null != dataObjectNode && !dataObjectNode.has("newpassword")) {
			LOGGER.error("Property that named newpassword must be provided .");

			objectNode.put("message", "Property that named newpassword must be provided .");

			return objectNode;
		}

		try {
			URL modifyIMUserPasswordWithAdminTokenUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/")
					+ "/users/" + userPrimaryKey + "/password");
			objectNode = HTTPClientUtils.sendHTTPRequest(modifyIMUserPasswordWithAdminTokenUrl, credential,
					dataObjectNode, HTTPMethod.METHOD_PUT);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return objectNode;
	}
	
	/**
	 * 添加好友[单个]
	 * 
	 * @param ownerUserPrimaryKey
	 * @param friendUserPrimaryKey
	 * 
	 * @return
	 */
	public static JSONObject addFriendSingle(String ownerUserPrimaryKey, String friendUserPrimaryKey) {
		JSONObject objectNode = new JSONObject ();

		// check Constants.APPKEY format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Constants.APPKEY");

			return objectNode;
		}

		if (StringUtils.isEmpty(ownerUserPrimaryKey)) {
			LOGGER.error("Your userPrimaryKey must be provided，the value is username or uuid of imuser.");

			objectNode.put("message", "Your userPrimaryKey must be provided，the value is username or uuid of imuser.");

			return objectNode;
		}

		if (StringUtils.isEmpty(friendUserPrimaryKey)) {
			LOGGER.error("The userPrimaryKey of friend must be provided，the value is username or uuid of imuser.");

			objectNode.put("message",
					"The userPrimaryKey of friend must be provided，the value is username or uuid of imuser.");

			return objectNode;
		}

		try {

			URL addFriendSingleUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/users/"
					+ ownerUserPrimaryKey + "/contacts/users/" + friendUserPrimaryKey);

			JSONObject body = new JSONObject();
			objectNode = HTTPClientUtils.sendHTTPRequest(addFriendSingleUrl, credential, body, HTTPMethod.METHOD_POST);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return objectNode;
	}
	
	/**
	 * 删除好友
	 * 
	 * @param ownerUserPrimaryKey
	 * @param friendUserPrimaryKey
	 * 
	 * @return
	 */
	public static JSONObject deleteFriendSingle(String ownerUserPrimaryKey, String friendUserPrimaryKey) {
		JSONObject objectNode = new JSONObject ();

		// check Constants.APPKEY format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Constants.APPKEY");

			return objectNode;
		}

		if (StringUtils.isEmpty(ownerUserPrimaryKey)) {
			LOGGER.error("Your userPrimaryKey must be provided，the value is username or uuid of imuser.");

			objectNode.put("message", "Your userPrimaryKey must be provided，the value is username or uuid of imuser.");

			return objectNode;
		}

		if (StringUtils.isEmpty(friendUserPrimaryKey)) {
			LOGGER.error("The userPrimaryKey of friend must be provided，the value is username or uuid of imuser.");

			objectNode.put("message",
					"The userPrimaryKey of friend must be provided，the value is username or uuid of imuser.");

			return objectNode;
		}

		try {
			URL addFriendSingleUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/users/"
					+ ownerUserPrimaryKey + "/contacts/users/" + friendUserPrimaryKey);

			JSONObject body =new JSONObject();
			objectNode = HTTPClientUtils.sendHTTPRequest(addFriendSingleUrl, credential, body, HTTPMethod.METHOD_DELETE);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return objectNode;
	}
	
	/**
	 * 获取用户所有好友
	 * 
	 * @param ownerUserPrimaryKey
	 * 
	 * @return
	 */
	public static JSONObject  getFriends(String ownerUserPrimaryKey) {
		JSONObject objectNode = new JSONObject ();

		// check Constants.APPKEY format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Constants.APPKEY: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Constants.APPKEY");

			return objectNode;
		}

		if (StringUtils.isEmpty(ownerUserPrimaryKey)) {
			LOGGER.error("Your userPrimaryKey must be provided，the value is username or uuid of imuser.");

			objectNode.put("message", "Your userPrimaryKey must be provided，the value is username or uuid of imuser.");

			return objectNode;
		}

		try {
			
			URL addFriendSingleUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/users/"
					+ ownerUserPrimaryKey + "/contacts/users");

			JSONObject  body = new JSONObject();
			objectNode = HTTPClientUtils.sendHTTPRequest(addFriendSingleUrl, credential, body, HTTPMethod.METHOD_GET);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return objectNode;
	}

	/**
	 * IM用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static JSONObject  imUserLogin(String username, String password) {

		JSONObject objectNode = new JSONObject();

		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", Constants.APPKEY)) {
			LOGGER.error("Bad format of Appkey: " + Constants.APPKEY);

			objectNode.put("message", "Bad format of Appkey");

			return objectNode;
		}
		if (StringUtils.isEmpty(username)) {
			LOGGER.error("Your username must be provided，the value is username or uuid of imuser.");

			objectNode.put("message", "Your username must be provided，the value is username or uuid of imuser.");

			return objectNode;
		}
		if (StringUtils.isEmpty(password)) {
			LOGGER.error("Your password must be provided，the value is username or uuid of imuser.");

			objectNode.put("message", "Your password must be provided，the value is username or uuid of imuser.");

			return objectNode;
		}

		try {
			JSONObject dataNode = new JSONObject();
			dataNode.put("grant_type", "password");
			dataNode.put("username", username);
			dataNode.put("password", password);

			objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.TOKEN_APP_URL, null, dataNode,
					HTTPMethod.METHOD_POST);

		} catch (Exception e) {
			throw new RuntimeException("Some errors ocuured while fetching a token by usename and passowrd .");
		}

		return objectNode;
	}

	/*************************************************************************************************************************/
	/**
	 * 指定前缀和数量生成用户基本数据
	 * 
	 * @param usernamePrefix
	 * @param number
	 * @return
	 */
	public static List genericArrayNode(String usernamePrefix, Long number) {
		List arrayNode = new ArrayList();
		for (int i = 0; i < number; i++) {
			JSONObject userNode = new JSONObject();
			userNode.put("username", usernamePrefix + "_" + i);
			userNode.put("password", Constants.DEFAULT_PASSWORD);

			arrayNode.add(userNode);
		}

		return arrayNode;
	}

}
