package com.jfn.common.pager;

import java.util.ArrayList;
import java.util.List;

public class Page<E> {

    private int pageNumber;
    private int pagesAvailable;
    private int rowCount;
    private int pagesize;
    public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getRowCount()
	{
		return rowCount;
	}

	public void setRowCount( int rowCount )
	{
		this.rowCount = rowCount;
	}

	private List<E> pageItems = new ArrayList<E>();

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPagesAvailable(int pagesAvailable) {
        this.pagesAvailable = pagesAvailable;
    }

    public void setPageItems(List<E> pageItems) {
        this.pageItems = pageItems;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPagesAvailable() {
        return pagesAvailable;
    }

    public List<E> getPageItems() {
        return pageItems;
    }
}