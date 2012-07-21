package com.lds.beans;
 
import com.lds.persistance.PersonnelDao;
import com.lds.persistance.PersonnelHDao;
import com.lds.vo.Personnel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
  
  
  
public class PersonnelBean  implements Serializable {  
  
    private List<Personnel> personnels;  
  
    private Personnel selectedPersonnel;  
  
    private Personnel[] selectedPersonnels;  
  
    private PersonnelDataModel mediumPersonnelsModel;  
  
    public PersonnelBean() {  
        personnels = new ArrayList<Personnel>();  
          
        //populateRandomCars(cars, 50);  
        PersonnelDao dao = new PersonnelHDao();
        personnels = dao.getAllPersonnels();
        mediumPersonnelsModel = new PersonnelDataModel(personnels);  
    }  
  
    public Personnel[] getSelectedPersonnels() {  
        return selectedPersonnels;  
    }  
    public void setSelectedPersonnels(Personnel[] selectedPersonnels) {  
        this.selectedPersonnels = selectedPersonnels;  
    }  
  
    public Personnel getSelectedPersonnel() {  
        return selectedPersonnel;  
    }  
  
    public void setSelectedPersonnel(Personnel selectedPersonnel) {  
        this.selectedPersonnel = selectedPersonnel;  
    }  
  
    /*private void populateRandomCars(List<Car> list, int size) {  
        for(int i = 0 ; i < size ; i++)  
            list.add(new Car(getRandomModel(), getRandomYear(), getRandomManufacturer(), getRandomColor()));  
    } */ 
  
  /*  private int getRandomYear() {  
        return (int) (Math.random() * 50 + 1960);  
    }  
  
    private String getRandomColor() {  
        return colors[(int) (Math.random() * 10)];  
    }  
  
    private String getRandomManufacturer() {  
        return manufacturers[(int) (Math.random() * 10)];  
    }  
  
    private String getRandomModel() {  
        return UUID.randomUUID().toString().substring(0, 8);  
    }  */
  
    public PersonnelDataModel getMediumPersonnelsModel() {  
        return mediumPersonnelsModel;  
    }  
}  