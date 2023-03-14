package ru.netology.repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket implements Comparable<Ticket> {
  int id;
  int cost;
  String departureAirport;
  String arrivalAirport;
  int travelTime;

  @Override
  public int compareTo(Ticket o) {
    if (this.getCost() < o.getCost()) {
      return -1;
    } else if (this.getCost() > o.getCost()) {
      return 1;
    } else {
      return 0;
    }
  }
}
