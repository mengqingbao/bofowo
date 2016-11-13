package com.common.page;

import java.util.ArrayList;
import java.util.Collection;

public class PageList<T> extends ArrayList<T> {

    public PageList() {
        paginator = new Paginator();
    }

    public PageList(Collection<T> c) {
        this(c, null);
    }

    public PageList(Collection<T> c, Paginator paginator) {
        super(c);
        this.paginator = paginator != null ? paginator : new Paginator();
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        if (paginator != null)
            this.paginator = paginator;
    }

    private static final long serialVersionUID = 0x1fb2895198568854L;
    private Paginator paginator;
}
