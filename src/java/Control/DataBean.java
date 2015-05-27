/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Codes;
import Model.Employee;
import Model.Permissionlevel;
import Model.Trackingtype;
import Model.Worktime;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author mike
 */
@Stateless
public class DataBean implements Serializable {


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private final EntityManager em;
private EntityTransaction t;

  /**
     * sets up lists from database
     */ 
private List<Employee> listEmployee;
private List<Permissionlevel> listPermissionLevel;
private List<Trackingtype> listTrackingType;
private List<Worktime> listWorkTime;

  /**
     * Employee input values
     */ 
private int empId, superId;
private String firstName, lastName;
private Permissionlevel employeeRole;
private Employee employeeToAdd;

 /**
     * Permission role input values
     */ 
private int roleId;
private String name, description;

 /**
     * Work Time input values
     */ 
private int wId;
private long startTime, endTime;
private Trackingtype tracker;



/* CODE LIST
*/
private String codeEntered;
private List<Codes> codes;




 /**
     * Tracking Type input values
     */ 


    /**
     * Creates a new instance of DataHandler
     */
    public DataBean() {
        em = Persistence.createEntityManagerFactory("ServletPU").createEntityManager();
        listEmployee = new ArrayList<>();
        listPermissionLevel = new ArrayList<Permissionlevel>();
        listTrackingType = new ArrayList<Trackingtype>();
        listWorkTime = new ArrayList<Worktime>();
        codes = new ArrayList<Codes>();
    }
    
    

    public String addEmployee(){
       
        try{
        Employee toAdd = new Employee();
        toAdd.setId(toAdd.getId());
        toAdd.setFname(getFirstName());
        toAdd.setLname(getLastName());
        toAdd.setRole(findPermissionLevel(getRoleId()));
        toAdd.setSupervisor(findEmployee(getSuperId()));
 
        t = em.getTransaction();
        t.begin();
        em.persist(toAdd);
        t.commit();
        return "success";
        }
        catch(NullPointerException e){
       return "fail";
        }
    }
    
    
    public void addPermissionLevel(){
        Permissionlevel toAdd = new Permissionlevel();
        toAdd.setId(toAdd.getId());
        toAdd.setName(getName());
        toAdd.setDescription(getDescription());
        
        t = em.getTransaction();
        t.begin();
        em.persist(toAdd);
        t.commit();
    }
    

    
    public Permissionlevel findPermissionLevel(int role){
               
        Permissionlevel level = em.find(Permissionlevel.class, role);
        return level;
    }
    
    public Employee findEmployee(int id){
        
        
        Employee found = em.find(Employee.class, id);
        return found;
    }
    
    public Trackingtype findTrackingType(int id){
        
        Trackingtype found = em.find(Trackingtype.class, id);
        return found;
        
    }
    
public List<Worktime> getWorkersTime(int id){
      List<Worktime> selectedWorker = new ArrayList<Worktime>();

      
      for(int i = 0; i<getListWorkTime().size();i++){
          Worktime item = getListWorkTime().get(i);
          if(item.getEmployee().getId() == id && item.getEndtime() != null){
              selectedWorker.add(getListWorkTime().get(i));
          }
          
          
      }
    
    
    
    
    return selectedWorker;
}

public void checkIn(){
    Worktime toAdd = new Worktime();

    BigInteger bi2 = BigInteger.valueOf(getStartTime());
    int id = idGenerator();
    toAdd.setId(id);
    toAdd.setStarttime(bi2);
    
   toAdd.setEmployee(getEmployeeToAdd());
    toAdd.setTrackingtype(getTracker());

    setwId(id);
        t = em.getTransaction();
        t.begin();
        em.persist(toAdd);
        t.commit();
  
}

public void checkOut(int id){
    Worktime toModify = em.find(Worktime.class, id);
     toModify.setEndtime(BigInteger.valueOf(getEndTime()));
    
        t = em.getTransaction();
        t.begin();
        em.merge(toModify);
        t.commit();
    
    
}

    
public Codes fetchUserId(String code){
    
    if(code != null){
        
    
    try{
    Codes entered = em.find(Codes.class, code);
    
   
    
    return entered;
    }
    catch(Error e){
        return null;
    }
    }
    else{
        return null;
    }
}    
 


public List<Worktime> fullTeam(int superVisorId){
    
     List<Worktime> fullTeam = new ArrayList<Worktime>();
    
           for(int i = 0; i<getListWorkTime().size();i++){
          Worktime item = getListWorkTime().get(i);
          if(item.getEmployee().getSupervisor().getId() == superVisorId && item.getEndtime() != null){
              fullTeam.add(getListWorkTime().get(i));
          }
     
           }
    return fullTeam;
}
           
    


















    
    public List<Employee> getListEmployee() {
         listEmployee = em.createNamedQuery("Employee.sortById").getResultList();
        return listEmployee;
    }

    /**
     *
     * @param listEmployee
     */
    
    public void setListEmployee(List<Employee> listEmployee) {
       
        this.listEmployee = listEmployee;
    }

    public List<Permissionlevel> getListPermissionLevel() {
        listPermissionLevel = em.createNamedQuery("Permissionlevel.sortAllById").getResultList();
        return listPermissionLevel;
    }

    /**
     *
     * @param listPermissionLevel
     */
    
    public void setListPermissionLevel(List<Permissionlevel> listPermissionLevel) {
        this.listPermissionLevel = listPermissionLevel;
    }

    public List<Trackingtype> getListTrackingType() {
        listTrackingType = em.createNamedQuery("Trackingtype.sortById").getResultList();
        return listTrackingType;
    }

    public void setListTrackingType(List<Trackingtype> listTrackingType) {
        this.listTrackingType = listTrackingType;
    }

    public List<Worktime> getListWorkTime() {
        listWorkTime = em.createNamedQuery("Worktime.sortAscending").getResultList();
        return listWorkTime;
    }

    public void setListWorkTime(List<Worktime> listWorkTime) {
        this.listWorkTime = listWorkTime;
    }

    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    public List<Codes> getCodes() {
        codes = em.createNamedQuery("Codes.findAll").getResultList();
        return codes;
    }

    public void setCodes(List<Codes> codes) {
        this.codes = codes;
    }



    /**
     *
     * @return
     */
 
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @return
     */
 
    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Trackingtype getTracker() {
        return tracker;
    }

    public void setTracker(Trackingtype tracker) {
        this.tracker = tracker;
    }

    
    
    
    
    
    
    
    
    
    
    
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Permissionlevel getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(Permissionlevel employeeRole) {
        this.employeeRole = employeeRole;
    }

    /**
     *
     * @return
     */
    
    public Employee getEmployeeToAdd() {
        return employeeToAdd;
    }

    public void setEmployeeToAdd(Employee employeeToAdd) {
        this.employeeToAdd = employeeToAdd;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
  
    
    public static int idGenerator() {
        int max = 2100000000;
        int min = 0;
    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1);

    return randomNum;
}

    public int getSuperId() {
        return superId;
    }

    public void setSuperId(int superId) {
        this.superId = superId;
    }
    
    
    


    

    
    
    

    
    
    
}
