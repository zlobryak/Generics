package ru.netology.logic;

import ru.netology.repo.Ticket;

public class Comparator implements java.util.Comparator<Ticket> {
  @Override
  public int compare(Ticket o1, Ticket o2) {
    if (o1.getTravelTime() < o2.getTravelTime()){
      return -1;
    } else if (o1.getTravelTime() > o2.getTravelTime()){
      return 1;
    }else return 0;
  }
}
