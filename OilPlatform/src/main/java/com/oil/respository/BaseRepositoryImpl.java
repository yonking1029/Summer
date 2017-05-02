package com.oil.respository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> 
							extends SimpleJpaRepository<T,ID>
							implements BaseRepository<T,ID>{

    private final EntityManager entityManager;

    //父类没有不带参数的构造方法，这里手动构造父类
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }
	@Override
	public List<T> find(String sql, Map<String, Object> params) {
		return null;
	}
}

