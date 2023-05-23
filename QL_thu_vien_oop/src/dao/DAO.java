/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author minh0
 */
public interface DAO<T> {
    public int Them(T t);
    public int Sua(T t);
    public int Xoa(T t);
    public List<T> TìmKiem(T t);
    public T getT(String ma);
}
