package com.oil.comm.dto;

import java.util.List;

public class PageDTO<T> {  
	  
  
    private Integer page = 1; // 当前页数  
  
    private Integer pagesize = 10; // 每页显示记录的条数  
  
    private Integer total; // 总的记录条数  
  
    private Integer pageCount; // 总的页数  
  
    private List<T> data;
      
    public PageDTO() {}
    
	public PageDTO(Integer page, Integer pagesize, Integer total, List<T> data) {
		super();
		this.page = page;
		this.pagesize = pagesize;
		this.total = total;
		this.data = data;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}


	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageCount() {
		pageCount = getTotal() / getPagesize();  
        return (total % pagesize == 0) ? pageCount  
                : pageCount + 1;  
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> data) {
		this.data = data;
	}
	public SimplePageDTO<T> toSimplePageDTO(){
		return new SimplePageDTO<T>(this.getData(), this.getTotal());
	}
}  

