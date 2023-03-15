package ru.netology.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TicketTest {
  Ticket ticket1 = new Ticket(1, 100, "AAA", "BBB", 1000);
  Ticket ticket2 = new Ticket(2, 200, "CCC", "DDD", 2000);
  Ticket ticket3 = new Ticket(3, 100, "CCC", "DDD", 3000);

  @Test
  void compareToBelow() {
    Assertions.assertEquals(-1, ticket1.compareTo(ticket2));
  }

  @Test
  void compareToEquals() {
    Assertions.assertEquals(1, ticket2.compareTo(ticket1));
  }

  @Test
  void compareToAbove() {
    Assertions.assertEquals(0, ticket1.compareTo(ticket3));
  }

}