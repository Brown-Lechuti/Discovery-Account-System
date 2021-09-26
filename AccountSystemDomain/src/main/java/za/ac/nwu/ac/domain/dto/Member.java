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
    private  int currency_available;
    private int plays_available;


    //default constructor
    public Member() {}
    
    //parametized constructor
    public Member(String first_name, String last_name, String activation_date, int currency_available, int plays_availble) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.activation_date = activation_date;
        this.currency_available = currency_available;
        this.plays_available = plays_availble;
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
        return plays_available;
    }

    public void setPlays(int plays_available) {this.plays_available = plays_available;}

    public int getCurrency() {
        return currency_available;
    }

    public void setCurrency(int currency_available) {
        this.currency_available = currency_available;
    }


}
