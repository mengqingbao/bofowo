// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   QueryBase.java

package com.common.page;

import java.io.Serializable;


public class QueryBase
    implements Serializable
{

    public QueryBase()
    {
        needQeryTotal = false;
        needDelete = false;
        needQueryAll = false;
        language="en_US";
        currentUserName="";
    }

    public boolean isAllowedQuery()
    {
        throw new RuntimeException("Please implement it in sub classes.");
    }

    protected final Integer getDefaultPageSize()
    {
        return defaultPageSize;
    }

    public Integer getCurrentPage()
    {
        if(currentPage == null)
            return defaultFriatPage;
        else
            return currentPage;
    }

    public void setCurrentPage(Integer cPage)
    {
        if(cPage == null || cPage.intValue() <= 0)
            currentPage = defaultFriatPage;
        else
            currentPage = cPage;
    }

    public Integer getPageSize()
    {
        if(pageSize == null)
            return getDefaultPageSize();
        else
            return pageSize;
    }

    public boolean hasSetPageSize()
    {
        return pageSize != null;
    }

    public void setPageSize(Integer pSize)
    {
        if(pSize == null)
            throw new IllegalArgumentException("PageSize can't be null.");
        if(pSize.intValue() <= 0)
        {
            throw new IllegalArgumentException("PageSize must great than zero.");
        } else
        {
            pageSize = pSize;
            return;
        }
    }

    public Integer getTotalItem()
    {
        if(totalItem == null)
            return defaultTotleItem;
        else
            return totalItem;
    }

    public void setTotalItem(Integer tItem)
    {
        if(tItem == null)
            tItem = new Integer(0);
        totalItem = tItem;
    }

    public int getTotalPage()
    {
        int pgSize = getPageSize().intValue();
        int total = getTotalItem().intValue();
        int result = total / pgSize;
        if(total % pgSize != 0)
            result++;
        return result;
    }

    public int getPageFristItem()
    {
        if(!needQeryTotal)
        {
            int cPage = getCurrentPage().intValue();
            if(cPage == 1)
            {
                return 1;
            } else
            {
                cPage--;
                int pgSize = getPageSize().intValue();
                return pgSize * cPage + 1;
            }
        } else
        {
            return 0;
        }
    }

    public int getPageLastItem()
    {
        if(!needQeryTotal)
        {
            int cPage = getCurrentPage().intValue();
            int pgSize = getPageSize().intValue();
            int assumeLast = pgSize * cPage;
            int totalItem = getTotalItem().intValue();
            if(assumeLast > totalItem)
                return totalItem;
            else
                return assumeLast;
        } else
        {
            return getTotalItem().intValue();
        }
    }
/**
 * 
* @Title: getEndRow
* @Description: TODO mySql的分页函数limit(start,pagesize)
* @param @return    设定文件
* @return int    返回类型
* @date 2015年5月25日
* @author 陈勋
* @throws
 */
    public int getEndRow()
    {
    	
//    	if(currentPage==null){
//    		currentPage=1;
//    	}
//       return currentPage*pageSize;
    	
    	return this.getPageSize();
    }

    public void setEndRow(int endRow)
    {
        this.endRow = endRow;
    }

    public int getStartRow()
    {
    	if(currentPage==null){
    		currentPage=1;
    	}
    	return (currentPage-1)*pageSize;
    }

    public void setStartRow(int startRow)
    {
        this.startRow = startRow;
    }

    protected String getSQLBlurValue(String value)
    {
        if(value == null)
            return null;
        else
            return (new StringBuilder(String.valueOf(value))).append('%').toString();
    }

    public boolean isNeedQeryTotal()
    {
        return needQeryTotal;
    }

    public void setNeedQeryTotal(boolean needQeryTotal)
    {
        this.needQeryTotal = needQeryTotal;
    }

    public boolean isNeedDelete()
    {
        return needDelete;
    }

    public void setNeedDelete(boolean needDelete)
    {
        this.needDelete = needDelete;
    }

    public boolean isNeedQueryAll()
    {
        return needQueryAll;
    }

    public void setNeedQueryAll(boolean needQueryAll)
    {
        this.needQueryAll = needQueryAll;
    }

    public void copyProperties(QueryBase k)
    {
        if(k == null)
            return;
        k.setCurrentPage(currentPage);
        k.setEndRow(endRow);
        k.setNeedDelete(needDelete);
        k.setNeedQeryTotal(needQeryTotal);
        k.setNeedQueryAll(needQueryAll);
        k.setStartRow(startRow);
        k.setTotalItem(totalItem);
    }

    public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCurrentUserName() {
		return currentUserName;
	}

	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}





	public String getDataSource() {		
		return dataSource==null?"dataSource1":dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}





	private static final long serialVersionUID = 0x7570ab2517f4b46dL;
    private static final Integer defaultPageSize = new Integer(20);
    private static final Integer defaultFriatPage = new Integer(1);
    private static final Integer defaultTotleItem = new Integer(0);
    private Integer totalItem;
    private Integer pageSize;
    private Integer currentPage;
    private int startRow;
    private int endRow;
    private boolean needQeryTotal;
    private boolean needDelete;
    private boolean needQueryAll;
    private String language;
    private String currentUserName;
    private String dataSource;
    

}
