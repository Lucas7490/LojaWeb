package br.mack.dao;
 
import jdbc.DataSource;

/**
 *
 * @author 31358535
 */
public abstract class DAO<T> {
    protected DataSource datasource;
    
    public abstract void create(T el);
    public abstract T read(T key);
    public abstract T delete(T key);
    public abstract void update(T key);
}