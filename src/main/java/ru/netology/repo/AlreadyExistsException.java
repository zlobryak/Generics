package ru.netology.repo;

public class AlreadyExistsException extends Throwable {
  public AlreadyExistsException(String msg) { super(msg);
  }
}
