package Model;

import Model.Codes;
import Model.Employee;
import Model.Permissionlevel;
import Model.Worktime;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-25T23:21:44")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> fname;
    public static volatile SingularAttribute<Employee, String> lname;
    public static volatile SingularAttribute<Employee, Permissionlevel> role;
    public static volatile CollectionAttribute<Employee, Employee> employeeCollection;
    public static volatile CollectionAttribute<Employee, Worktime> worktimeCollection;
    public static volatile CollectionAttribute<Employee, Codes> codesCollection;
    public static volatile SingularAttribute<Employee, Integer> id;
    public static volatile SingularAttribute<Employee, Employee> supervisor;

}