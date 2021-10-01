package za.ac.nwu.ac.domain.dto;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "MEMBER_")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Member
{
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="activation_date")
    private java.sql.Date activation_date;
    @Column(name="currency_available")
    private Integer currency_available = 0;
    @Column(name="plays_available")
    private Integer plays_available = 0;


    //default constructor
    public Member() { super();}
    
    //parametized constructor
    public Member(String first_name, String last_name, java.sql.Date activation_date, Integer currency_available, Integer plays_available) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.activation_date = activation_date;
        this.currency_available = currency_available;
        this.plays_available = plays_available;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public java.sql.Date getActivation_date() {
        return activation_date;
    }

    public void setActivation_date(java.sql.Date activation_date) {
        this.activation_date = activation_date;
    }

    public Integer getPlays() {
        return plays_available;
    }

    public void setPlays(Integer plays_available) {this.plays_available = plays_available;}

    public Integer getCurrency() {return currency_available;}

    public void setCurrency(Integer currency_available) {this.currency_available = currency_available;}

}
