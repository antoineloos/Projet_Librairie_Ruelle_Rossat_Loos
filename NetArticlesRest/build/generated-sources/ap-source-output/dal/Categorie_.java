package dal;

import dal.Client;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-15T17:43:27")
@StaticMetamodel(Categorie.class)
public class Categorie_ { 

    public static volatile SingularAttribute<Categorie, String> libcategorie;
    public static volatile SingularAttribute<Categorie, Integer> idCategorie;
    public static volatile CollectionAttribute<Categorie, Client> clientCollection;

}