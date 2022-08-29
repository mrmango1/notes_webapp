package com.itsqmet.todo.controller;

public interface CurrentDao<T> {
  T currentTable(int id);
}
