package ru.netology.repo;

public class NotFoundException extends Throwable {
  public NotFoundException(String msg) {
    super(msg);
  }
}
