package ru.netology.logic;

import ru.netology.repo.Repository;
import ru.netology.repo.Ticket;

import java.util.Arrays;

public class Manager {

  private Repository repository = new Repository();

  public void save(Ticket ticket) {
    repository.save(ticket);
  }

  public Ticket[] findAll(){
    return repository.findAll();
  }
  public void removeById(int id) {
    repository.removeById(id);
  }

  public Ticket[] findFromTo(String from, String to) {
    Ticket[] result = new Ticket[0];
    Ticket[] allTickets = repository.findAll();
    for (Ticket allTicket : allTickets) {
      if (allTicket.getDepartureAirport().equals(from)) {
        if (allTicket.getArrivalAirport().equals(to)) {
          Ticket[] tmp = new Ticket[result.length + 1];
          for (int i = 0; i < result.length; i++) {
            tmp[i] = result[i];
          }
          tmp[tmp.length - 1] = allTicket;
          result = tmp;
        }
      }
    }
    Arrays.sort(result);
    return result;
  }
}