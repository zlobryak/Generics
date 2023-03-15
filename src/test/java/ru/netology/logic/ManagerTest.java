package ru.netology.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repo.AlreadyExistsException;
import ru.netology.repo.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
  Manager manager = new Manager();
  Ticket ticket1 = new Ticket(1, 100, "AAA","BBB", 1000);
  Ticket ticket2 = new Ticket(2, 200, "CCC","DDD", 2000);
  Ticket ticket3 = new Ticket(3, 300, "EEE","FFF", 3000);
  Ticket ticket4 = new Ticket(4, 400, "GGG","HHH", 4000);
  Ticket ticket5 = new Ticket(5, 500, "III","JJJ", 5000);
  Ticket ticket6 = new Ticket(6, 600, "III","JJJ", 6000);
  @Test
  void findFromTo() throws AlreadyExistsException { //Рроверка поиска 1 билета
    manager.save(ticket5);
    manager.save(ticket2);
    manager.save(ticket3);
    manager.save(ticket4);
    manager.save(ticket1);
    Ticket[] expected = {ticket5};
    Ticket[] actual = manager.findFromTo("III", "JJJ");
    Assertions.assertArrayEquals(expected, actual);
  }
  @Test
  void findFromToSort() throws AlreadyExistsException { //Проверка сортироваки значений
    manager.save(ticket6); // Первым подаем большее значение
    manager.save(ticket2);
    manager.save(ticket3);
    manager.save(ticket4);
    manager.save(ticket1);
    manager.save(ticket5); // Посленим подаем меньшее значение
    Ticket[] expected = {ticket5, ticket6}; // В ответе получаем значения в проядке отменьшего к большему
    Ticket[] actual = manager.findFromTo("III", "JJJ");
    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  void findFromToNoResults() {
    manager.save(ticket2);
    manager.save(ticket3);
    manager.save(ticket4);
    manager.save(ticket1);
    Ticket[] expected = new Ticket[0]; // В ответе получаем значения в проядке отменьшего к большему
    Ticket[] actual = manager.findFromTo("III", "JJJ");
    Assertions.assertArrayEquals(expected, actual);
  }

  @Test
  void save() {
    manager.save(ticket1);
    Ticket[] expected ={ticket1};
    Assertions.assertArrayEquals(expected, manager.findAll());
  }

  @Test
  void removeById() {
  }
  //todo Add few more test for logic.
}