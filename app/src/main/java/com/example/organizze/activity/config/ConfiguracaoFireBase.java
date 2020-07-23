package com.example.organizze.activity.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFireBase {

    private static FirebaseAuth auth;
    private static DatabaseReference dbRef;

    //Retorna instancia do FireBaseAuth
    public static DatabaseReference getFireBase(){
        if(dbRef == null){
            dbRef = FirebaseDatabase.getInstance().getReference();
        }
        return dbRef;
    }

        //retorna instancia do FireBaseAuth
        public static FirebaseAuth getFireBaseAuth(){
            if(auth == null){
                auth = FirebaseAuth.getInstance();
            }
            return auth;
        }



}
