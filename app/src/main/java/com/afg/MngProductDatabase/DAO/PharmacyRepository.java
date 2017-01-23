package com.afg.MngProductDatabase.DAO;



/**
 * Created by usuario on 13/01/17.
 */
public class PharmacyRepository {
    private static PharmacyRepository ourInstance = new PharmacyRepository();

    public static PharmacyRepository getInstance() {
        return ourInstance;
    }

    private PharmacyRepository() {
    }
}
