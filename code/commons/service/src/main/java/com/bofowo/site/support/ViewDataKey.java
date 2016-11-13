package com.bofowo.site.support;

import com.bofowo.core.land.util.MemCachedUtil;

public class ViewDataKey {

	public static final String INDEX_MAP ="MAP_001";  //首页Map集合
	public static final String INDEX_TYPE_LIST="TYPE_001";//首页类型
	public static final String INDEX_ALLTYPE_LIST="ALLTYPE_001";//首页类型
	
	public static final String NEWS_MAP = "MAP_NEWS";  //新闻Map集合
	public static final String NEWS_TYPE_LIST = "TYPE_NEWS"; //新闻类型

    public static final String AUDIO_MAP ="MAP_002";  //音频Map集合
	public static final String AUDIO_TYPE_LIST="TYPE_002"; //音频类型
	
	public static final String BLOG_MAP="MAP_003";// 博客Map集合
	public static final String BLOG_TYPE_LIST="TYPE_003";//博客类型
    public static final String VIDEO_MAP="MAP_004";//视频集合
	public static final String VIDEO_TYPE_LIST="TYPE_OO4"; //视频类型集合
	
	public static void cleanAllMembers(){
		MemCachedUtil.clear(INDEX_MAP);
		MemCachedUtil.clear(INDEX_TYPE_LIST);
		MemCachedUtil.clear(INDEX_ALLTYPE_LIST);
		
		MemCachedUtil.clear(NEWS_MAP);
		MemCachedUtil.clear(NEWS_TYPE_LIST);
		
		MemCachedUtil.clear(AUDIO_MAP);
		MemCachedUtil.clear(AUDIO_TYPE_LIST);
		
		MemCachedUtil.clear(BLOG_MAP);
		MemCachedUtil.clear(BLOG_TYPE_LIST);
		
		
		MemCachedUtil.clear(VIDEO_MAP);
		MemCachedUtil.clear(VIDEO_TYPE_LIST);
		
		
		
		
		
	}}