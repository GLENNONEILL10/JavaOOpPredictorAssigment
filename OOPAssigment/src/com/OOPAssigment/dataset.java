package com.OOPAssigment;

import java.util.*;

public class dataset {

    private List<dataRow> rows = new ArrayList<>();

    public void addRows(dataRow row){

        rows.add(row);
    }

    public List<dataRow> getRows(){

        return rows;
    }

}
