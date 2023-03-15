package ru.netology.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
  Repository repository = new Repository();
  Ticket ticket1 = new Ticket(1, 100, "AAA", "BBB", 1000);
  Ticket ticket2 = new Ticket(2, 200, "CCC", "DDD", 2000);
  Ticket ticket3 = new Ticket(3, 300, "EEE", "FFF", 3000);
  Ticket ticket4 = new Ticket(4, 400, "GGG", "HHH", 4000);
  Ticket ticket5 = new Ticket(5, 500, "III", "JJJ", 5000);
  Ticket ticket6 = new Ticket(6, 600, "III", "JJJ", 6000);

  @Test
  void save() {
    repository.save(ticket1);
    Ticket[] expected = {ticket1};
    Assertions.assertArrayEquals(expected, repository.findAll());
  }

  @Test
  void saveAlredyExistId() {
    repository.save(ticket1);
    Assertions.assertThrows(AlreadyExistsException.class, () -> {
      repository.save(ticket1);
    });
  }

  @Test
  public void removeByIdWhenWrongTest() {
    Assertions.assertThrows(NotFoundException.class, () -> {
      repository.removeById(-100);
    });
  }

  @Test
  void removeById() {
    repository.save(ticket1);
    repository.save(ticket2);
    repository.save(ticket3);
    repository.save(ticket4);
    repository.save(ticket5);
    repository.removeById(5);
    Ticket[] expected = {ticket1, ticket2, ticket3, ticket4};
    Assertions.assertArrayEquals(expected, repository.findAll());
  }

  @Test
  void removeByIdWrongId() {
    repository.save(ticket1);
    repository.save(ticket2);
    repository.save(ticket3);
    repository.save(ticket4);
    repository.save(ticket5);
    Assertions.assertThrows(NotFoundException.class, () -> {
      repository.removeById(6);
    });
  }

  @Test
  void findByID() {
    repository.save(ticket1);
    repository.save(ticket2);
    repository.save(ticket3);
    repository.save(ticket4);
    repository.save(ticket5);
    Ticket expected = ticket5;
    Assertions.assertEquals(expected, repository.findByID(5));
  }

  @Test
  void findByIDWhenNull() {
    repository.save(ticket1);
    repository.save(ticket2);
    repository.save(ticket3);
    repository.save(ticket4);
    repository.save(ticket5);
    Assertions.assertNull(repository.findByID(7));
  }

  @Test
  void findByFrom() {
    repository.save(ticket1);
    repository.save(ticket2);
    repository.save(ticket3);
    repository.save(ticket4);
    repository.save(ticket5);
    Ticket expected = ticket5;
    Assertions.assertEquals(expected, repository.findByFrom("III"));
  }
  @Test
  void findByFromNull() {
    repository.save(ticket1);
    repository.save(ticket2);
    repository.save(ticket3);
    repository.save(ticket4);
    repository.save(ticket5);
    Assertions.assertNull(repository.findByFrom("KKK"));
  }


  @Test
  void findByTo() {
    repository.save(ticket1);
    repository.save(ticket2);
    repository.save(ticket3);
    repository.save(ticket4);
    repository.save(ticket5);
    Ticket expected = ticket5;
    Assertions.assertEquals(expected, repository.findByTo("JJJ"));
  }
  @Test
  void findByToNull() {
    repository.save(ticket1);
    repository.save(ticket2);
    repository.save(ticket3);
    repository.save(ticket4);
    repository.save(ticket5);
    Assertions.assertNull(repository.findByTo("KKK"));
  }
}