package Model;

import Model.Employee;
import Model.Trackingtype;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-25T23:21:44")
@StaticMetamodel(Worktime.class)
public class Worktime_ { 

    public static volatile SingularAttribute<Worktime, Trackingtype> trackingtype;
    public static volatile SingularAttribute<Worktime, BigInteger> endtime;
    public static volatile SingularAttribute<Worktime, Integer> id;
    public static volatile SingularAttribute<Worktime, BigInteger> starttime;
    public static volatile SingularAttribute<Worktime, Employee> employee;

}