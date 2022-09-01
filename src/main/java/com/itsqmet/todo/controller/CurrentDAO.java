package com.itsqmet.todo.controller;

public interface CurrentDAO<T> {
  T currentTable(int id);
}
