package com.practice.hibernate.secondarytablewithembeddablemap;


import com.practice.hibernate.secondarytablewithembeddcollection.PersonWithTicket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "personwithembeddablecollectionmap")
public class PersonWithEmbeddableCollectionMap {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ElementCollection
    @CollectionTable(name = "PERSON_TICKET_MAP",
     joinColumns = {
            @JoinColumn(name = "PERSON_ID", referencedColumnName = "id")
     }
    )
    private List<PersonWithTicketMap> tickets =new ArrayList<>();

    @ElementCollection
    @MapKeyColumn(name = "ATTR_NAME")
    @Column(name = "ATTR_VALUE")
    @CollectionTable(name = "PERSON_TICKET_COLL_MAP",
            joinColumns = {
                    @JoinColumn(name = "PERSON_ID", referencedColumnName = "id")
            }
    )
    private Map<String, String> attributes=new HashMap<>();


    public void addAttribute(String key, String value){
        attributes.put(key, value);
    }

    public void addTicket(PersonWithTicketMap ticket){
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

    public List<PersonWithTicketMap> getTickets() {
        return tickets;
    }

    public void setTickets(List<PersonWithTicketMap> tickets) {
        this.tickets = tickets;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
