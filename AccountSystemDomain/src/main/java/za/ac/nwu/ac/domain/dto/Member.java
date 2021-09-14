package za.ac.nwu.ac.domain.dto;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "MEMBER_")
public class Member
{
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String first_name;
    private String last_name;
    private String activation_date;
    private int plays;
    private  int currency;

    //default constructor
    public Member() {}
    
    //parametized constructor
    public Member(String first_name, String last_name, String activation_date, int currency, int plays) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.activation_date = activation_date;
        this.plays = plays;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getActivation_date() {
        return activation_date;
    }

    public void setActivation_date(String activation_date) {
        this.activation_date = activation_date;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }


}
