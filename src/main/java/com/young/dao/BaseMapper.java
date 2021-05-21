package com.young.dao;

/**
 * @author 闫亮23
 * @version 1.0
 */
public interface BaseMapper<T,ID> {

    public Integer insert(T entity) throws Exception;


}
