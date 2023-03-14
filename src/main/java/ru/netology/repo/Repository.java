package ru.netology.repo;

public class Repository {
  private Ticket[] repository = new Ticket[0];

  public void save(Ticket ticket) throws AlreadyExistsException {
    if (findByID(ticket.getId()) == null) {
      Ticket[] tmp = new Ticket[repository.length + 1];
      for (int i = 0; i < repository.length; i++) {
        tmp[i] = repository[i];
      }
      tmp[tmp.length - 1] = ticket;
      repository = tmp;
    } else {
      throw new AlreadyExistsException("Element " + ticket.getId() + "already exists");
    }
  }

  public void removeById(int id) throws NotFoundException {
    if (findByID(id) != null){
      Ticket[] tmp = new Ticket[repository.length - 1];
      int copyToindex = 0;
      for (Ticket ticket : repository) {
        if (ticket.getId() != id) {
          tmp[copyToindex] = ticket;
          copyToindex++;
        }
        repository = tmp;
      }
    } else {
      throw new NotFoundException("Element with id:" + id + "is not found.");
    }
  }

  public Ticket[] getRepository() {
    return repository;
  }

  public Ticket findByID(int id) {
    for (Ticket ticket : repository){
      if (ticket.getId() == id){
        return ticket;
      }
    }
    return null;
  }
  public Ticket findByFrom(String from) {
    for (Ticket ticket : repository){
      if (ticket.getDepartureAirport().equals(from)){
        return ticket;
      }
    }
    return null;
  }
  public Ticket findByTo(String to) {
    for (Ticket ticket : repository){
      if (ticket.getArrivalAirport().equals(to)){
        return ticket;
      }
    }
    return null;
  }
  public Ticket[] findAll(){
    return repository;
  }

}
