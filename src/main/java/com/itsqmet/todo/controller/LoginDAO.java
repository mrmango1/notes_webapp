package com.itsqmet.todo.controller;

public interface LoginDAO<T>{
  T validate(T t);
  T register();
}
