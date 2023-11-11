package com.qa.lemonade.change.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LemonadeStandProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String bill_value;
    private String position_in_line;
    private String requested_lemonades;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillValue() { return bill_value;}

    public void setBillValue(String bill_value) {
        this.bill_value = bill_value;
    }

    public String getPositionInLine() { return position_in_line; }

    public void setPositionInLine(String position_in_line) {
        this.position_in_line = position_in_line;
    }

    public String getRequestedLemonades() {
        return requested_lemonades;
    }

    public void setRequestedLemonades(String requested_lemonades){
        this.requested_lemonades = requested_lemonades;
    }


}
