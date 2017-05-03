package com.oil.comm.dto;

import java.util.List;

public class SimplePageDTO<T> {  
	  
    private Integer total = 0;
  
    private List<T> rows;
    
    public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public SimplePageDTO() {}

	public SimplePageDTO(List<T> rows,Integer total) {
		super();
		this.total = total;
		this.rows = rows;
	}
}  

