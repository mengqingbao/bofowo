package com.common.page;

import java.io.Serializable;

public class Paginator
    implements Serializable, Cloneable
{

    public Paginator()
    {
        this(0);
    }

    public Paginator(int itemsPerPage)
    {
        this(itemsPerPage, UNKNOWN_ITEMS);
    }

    public Paginator(int itemsPerPage, int items)
    {
        this.items = items < 0 ? 0 : items;
        this.itemsPerPage = itemsPerPage <= 0 ? 10 : itemsPerPage;
        page = calcPage(0);
    }

    public int getPages()
    {
        return (int)Math.ceil((double)items / (double)itemsPerPage);
    }

    public int getPage()
    {
        return page;
    }

    public int setPage(int page)
    {
        return this.page = calcPage(page);
    }

    public int getItems()
    {
        return items;
    }

    public int setItems(int items)
    {
        this.items = items < 0 ? 0 : items;
        setPage(page);
        return this.items;
    }

    public int getItemsPerPage()
    {
        return itemsPerPage;
    }

    public int setItemsPerPage(int itemsPerPage)
    {
        int tmp = this.itemsPerPage;
        this.itemsPerPage = itemsPerPage <= 0 ? 10 : itemsPerPage;
        if(page > 0)
            setPage((int)(((double)(page - 1) * (double)tmp) / (double)this.itemsPerPage) + 1);
        return this.itemsPerPage;
    }

    public int getOffset()
    {
        return page <= 0 ? 0 : itemsPerPage * (page - 1);
    }

    public int getLength()
    {
        if(page > 0)
            return Math.min(itemsPerPage * page, items) - itemsPerPage * (page - 1);
        else
            return 0;
    }

    public int getBeginIndex()
    {
        if(page > 0)
            return itemsPerPage * (page - 1) + 1;
        else
            return 0;
    }

    public int getEndIndex()
    {
        if(page > 0)
            return Math.min(itemsPerPage * page, items);
        else
            return 0;
    }

    public int setItem(int itemOffset)
    {
        return setPage(itemOffset / itemsPerPage + 1);
    }

    public int getFirstPage()
    {
        return calcPage(1);
    }

    public int getLastPage()
    {
        return calcPage(getPages());
    }

    public int getPreviousPage()
    {
        return calcPage(page - 1);
    }

    public int getPreviousPage(int n)
    {
        return calcPage(page - n);
    }

    public int getNextPage()
    {
        return calcPage(page + 1);
    }

    public int getNextPage(int n)
    {
        return calcPage(page + n);
    }

    public boolean isDisabledPage(int page)
    {
        return page < 1 || page > getPages() || page == this.page;
    }

    public int[] getSlider()
    {
        return getSlider(7);
    }

    public int[] getSlider(int width)
    {
        int pages = getPages();
        if(pages < 1 || width < 1)
            return new int[0];
        if(width > pages)
            width = pages;
        int slider[] = new int[width];
        int first = page - (width - 1) / 2;
        if(first < 1)
            first = 1;
        if((first + width) - 1 > pages)
            first = (pages - width) + 1;
        for(int i = 0; i < width; i++)
            slider[i] = first + i;

        return slider;
    }

    protected int calcPage(int page)
    {
        int pages = getPages();
        if(pages > 0)
            return page >= 1 ? page <= pages ? page : pages : 1;
        else
            return 0;
    }

    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            return null;
        }
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer("Paginator: page ");
        if(getPages() < 1)
        {
            sb.append(getPage());
        } else
        {
            int slider[] = getSlider();
            for(int i = 0; i < slider.length; i++)
            {
                if(isDisabledPage(slider[i]))
                    sb.append('[').append(slider[i]).append(']');
                else
                    sb.append(slider[i]);
                if(i < slider.length - 1)
                    sb.append('\t');
            }

        }
        sb.append(" of ").append(getPages()).append(",\n");
        sb.append("    Showing items ").append(getBeginIndex()).append(" to ").append(getEndIndex()).append(" (total ").append(getItems()).append(" items), ");
        sb.append("offset=").append(getOffset()).append(", length=").append(getLength());
        return sb.toString();
    }

    private static final long serialVersionUID = 0xe3fded8da14ed51cL;
    public static final int DEFAULT_ITEMS_PER_PAGE = 10;
    public static final int DEFAULT_SLIDER_SIZE = 7;
    public static final int UNKNOWN_ITEMS = 0x7fffffff;
    private int page;
    private int items;
    private int itemsPerPage;
}
