package com.OOPAssigment;

import java.util.*;

public class dataset {

    //ArrayList of DataRow objects
	private List<dataRow> rows = new ArrayList<>();

	//adds rows to the arrayList
    public void addRows(dataRow row){

        rows.add(row);
    }
    
    //gets the rows from the arrayList
    public List<dataRow> getRows(){

        return rows;
    }

}
