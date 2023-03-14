package ru.netology.logic;

import ru.netology.repo.AlreadyExistsException;
import ru.netology.repo.NotFoundException;
import ru.netology.repo.Repository;
import ru.netology.repo.Ticket;

public class Manager {

  private Repository repository = new Repository();

  public void save(Ticket ticket) throws AlreadyExistsException {
    repository.save(ticket);
  }

  public void removeById(int id) throws NotFoundException {
    repository.removeById(id);
  }

  public Ticket[] findFromTo(String from, String to) throws NotFoundException {
    Ticket[]result = new Ticket[0];
    Ticket[] allTickets = repository.findAll();
    int indexToCopy = 0;
    for (Ticket ticket : allTickets) {
      if (repository.findByFrom(from) != null || repository.findByTo(to) != null) {
        Ticket[] tmp = new Ticket[result.length + 1];
        tmp[indexToCopy] = ticket;
        indexToCopy++;
      }else {
        throw new NotFoundException("No tickets from" + from + "to" + to);
      }
    }
    return result; //todo Results should be sorted.
  }

  //todo Add few more test for logic.
}
