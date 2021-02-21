package com.johnjeremih.mvvmwithjava.data;

import androidx.lifecycle.MutableLiveData;
import com.johnjeremih.mvvmwithjava.model.Employee;
import java.util.ArrayList;

/* Made by John De la cruz
 *  2/21/21
 */

// Singleton pattern
public class Repository {

    private static Repository instance;
    private final ArrayList<Employee> dataSet = new ArrayList<>();

    public static Repository getInstance(){
        if (instance == null){
            instance = new Repository();
        }
        return instance;
    }


    //Pretending to retrieve the data from the web services
    public MutableLiveData<ArrayList<Employee>> getEmployees(){
        setDataSet();

        MutableLiveData<ArrayList<Employee>> data = new MutableLiveData<>();
        data.setValue(dataSet);

         return data;
    }


    //Assuming this is the data tha comes from a online source.
    private void setDataSet(){

        dataSet.add(new Employee("Juan Pablo","Great Employee, Hard Worker"));
        dataSet.add(new Employee("Anne Wilson","Very Brilliant person"));
        dataSet.add(new Employee("Anthony Rambo","Likes to talk a lot"));
        dataSet.add(new Employee("Randy Petro","Doesn't hesitate to ask questions"));
        dataSet.add(new Employee("Barbara Hillsongs","Love to contribute with her ideas"));
        dataSet.add(new Employee("Maria Rosa","She is always giving her all"));
        dataSet.add(new Employee("Brama Can","Great Employee, Hard Worker"));
        dataSet.add(new Employee("Ana Weu","Very Brilliant person"));
        dataSet.add(new Employee("Rodrigo Pepe","Likes to talk a lot"));
        dataSet.add(new Employee("Shawn Mark","Doesn't hesitate to ask questions"));
        dataSet.add(new Employee("Mark Dante","Love to contribute with her ideas"));
        dataSet.add(new Employee("Mary Rose","She is always giving her all"));

    }


}
