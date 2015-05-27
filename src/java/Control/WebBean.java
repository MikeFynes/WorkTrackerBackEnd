/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Employee;
import Model.Worktime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Startup;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mike
 */
@Startup
@SessionScoped
public class WebBean implements Serializable {
private String method, sevenDays, lastMonth, full, codeEntered;
 private final DataBean dBean;
 
 private Employee loggedUser;
 private int empId;
 
  FacesContext facesContext;
 
 
    public WebBean(){
        dBean = new DataBean();

             
        
        }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSevenDays() {
        return sevenDays;
    }

    public void setSevenDays(String sevenDays) {
        this.sevenDays = "sevenDays";
    }

    public String getLastMonth() {
        return lastMonth;
    }

    public void setLastMonth(String lastMonth) {
        this.lastMonth = "lastMonth";
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = "full";
    }

    public Employee getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Employee loggedUser) {
        this.loggedUser = loggedUser;
    }
    
    
    public String addUserForm(){
        String result = "";
   try{
       
   
        if(getLoggedUser().getRole().getId()>3){
            result = dBean.addEmployee();        
        }
        else{
            result = "fail";
        }
        
   }
   catch (NullPointerException e){
       result ="fail";
   }
    
    
    return result;
        
        
    }
    
    
    
    
    
    
    

    
    
    
    public List<Worktime> loadList (int size){
      try {
          List<Worktime> fullList =  dBean.getWorkersTime(getLoggedUser().getId());
        System.out.println("EMP ID IS "+Integer.toString(getLoggedUser().getId()));
        if(size > fullList.size()){
            size = fullList.size();
        }
        else if(size == 0){
             size = fullList.size();
        }
       List<Worktime> webList = new ArrayList<Worktime>();
        for(int i=0; i<size; i++){
            webList.add(fullList.get(i));
        }
        
        
        return webList;
              }
      catch(NullPointerException e){
          System.out.println(e.toString());
           
    List<Worktime> fullList =  new ArrayList<Worktime>();
    return fullList;
          
      }

    }
    
    
        public Boolean checkLogin(){
     
        if(dBean.fetchUserId(getCodeEntered()) != null){
              setLoggedUser((dBean.fetchUserId(getCodeEntered()).getEmployee()));
              setEmpId(getLoggedUser().getId());
        return true;    
        }
        else{
            return false;
        }
        
    }
        
        
            public String getCodeEntered() {
        return codeEntered;
    }

    public void setCodeEntered(String codeEntered) {
        this.codeEntered = codeEntered;
       
    }
    
    
    public String userNameGrabber(){
        
        
             setLoggedUser((dBean.fetchUserId(getCodeEntered()).getEmployee()));
       try{
           String userFull = loggedUser.getFname()+" "+loggedUser.getLname();
           return userFull;
       }
       catch(NullPointerException e){
                    return "null";
       }

    }
    
    
  
    
    public String logOut(){
        setCodeEntered(null);
        String navCase = "false";
        
        return navCase;
        
    }
    
    
    public List<Worktime> getFullTeamWorkingHours(){
        
        int superId = getLoggedUser().getSupervisor().getId();
        List<Worktime> fullTeam = dBean.fullTeam(superId);
        
        if(fullTeam != null){
        return fullTeam;    
        
        }
        else{
            fullTeam = new ArrayList<Worktime>();
            return fullTeam;
        }
        
        
    }
    
    
    
    

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
    
    
    
}
