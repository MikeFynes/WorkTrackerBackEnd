package Model;

import Model.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-25T23:21:44")
@StaticMetamodel(Permissionlevel.class)
public class Permissionlevel_ { 

    public static volatile SingularAttribute<Permissionlevel, String> name;
    public static volatile CollectionAttribute<Permissionlevel, Employee> employeeCollection;
    public static volatile SingularAttribute<Permissionlevel, String> description;
    public static volatile SingularAttribute<Permissionlevel, Integer> id;

}