package com.oil.a;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface ClassroomRepositoryCustom {
	
	@Transactional
	public void delete(int cla);
	
	/**
	 * 查询班级dto
	 * @return
	 */
	public List<ClassroomDto> listClassroomDto();
}
