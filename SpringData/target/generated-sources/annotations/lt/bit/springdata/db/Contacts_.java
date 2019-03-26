package lt.bit.springdata.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lt.bit.springdata.db.Persons;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-28T12:27:16")
@StaticMetamodel(Contacts.class)
public class Contacts_ { 

    public static volatile SingularAttribute<Contacts, String> contact;
    public static volatile SingularAttribute<Contacts, Persons> personId;
    public static volatile SingularAttribute<Contacts, Integer> id;
    public static volatile SingularAttribute<Contacts, String> type;

}