package com.johnjeremih.mvvmwithjava.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.johnjeremih.mvvmwithjava.data.Repository;
import com.johnjeremih.mvvmwithjava.model.Employee;
import java.util.ArrayList;

/* Made by John De la cruz
 *  2/21/21
 */

 public class DetailViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Employee>> employees;


    /*
    * Initiation Method. This will check whether the Mutable data is null or not
    * If the data is null then it will get the instance form the Repository class
     */
     public void init(){

        if (employees!= null){
            return ;
        }

        // Get the instance form the Repository class
        Repository repository = Repository.getInstance();
        employees = repository.getEmployees();

    }

    public LiveData<ArrayList<Employee>> getEmployee(){
        return employees;
    }

}
