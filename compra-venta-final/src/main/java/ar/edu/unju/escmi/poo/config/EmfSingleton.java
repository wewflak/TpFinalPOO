package ar.edu.unju.escmi.poo.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfSingleton<otherObject> {

    private static EmfSingleton instancia = new EmfSingleton();
    static private final String PERSISTENCE_UNIT_NAME = "TestPersistence";
    private EntityManagerFactory emf = null;

    public static EmfSingleton getInstance() {
        return instancia;
    }
    private EmfSingleton() {
    	
    }

    public EntityManagerFactory getEmf() {
        if (emf == null)
            this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return this.emf;
    }
//    private static MySingleton instance = new MySingleton();
//
//    // You could do this here or in the constructor
//    // private OtherObject obj = new OtherObject();
//
//    /** Use this if you want to do it in the constructor instead. */
//    private OtherObject obj;
//
//    private MySingleton() {
//        obj = new OtherObject();
//    }
//
//    /** Now you can just return your static reference */
//    public static MySingleton getInstance() {
//        return instance;
//    }
}
