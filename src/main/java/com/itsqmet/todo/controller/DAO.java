package com.itsqmet.todo.controller;

import java.util.List;

public interface DAO <T>{
  boolean create(T t);
  List<T> read();
  boolean update(T t);
  boolean delete(T t);
}
