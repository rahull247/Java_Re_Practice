package com.practice.hibernate.secondarytablewithembeddcollection;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personwithembeddablecollection")
public class PersonWithEmbeddableCollection {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ElementCollection
    @CollectionTable(name = "PERSON_TICKET",
     joinColumns = {
            @JoinColumn(name = "PERSON_ID", referencedColumnName = "id")
     }
    )
    private List<PersonWithTicket> tickets =new ArrayList<>();

    public void addTicket(PersonWithTicket ticket){
        this.tickets.add(ticket);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PersonWithTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<PersonWithTicket> tickets) {
        this.tickets = tickets;
    }
}
