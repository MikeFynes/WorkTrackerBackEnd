package Model;

import Model.Worktime;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-25T23:21:44")
@StaticMetamodel(Trackingtype.class)
public class Trackingtype_ { 

    public static volatile SingularAttribute<Trackingtype, String> name;
    public static volatile CollectionAttribute<Trackingtype, Worktime> worktimeCollection;
    public static volatile SingularAttribute<Trackingtype, String> description;
    public static volatile SingularAttribute<Trackingtype, Integer> id;

}