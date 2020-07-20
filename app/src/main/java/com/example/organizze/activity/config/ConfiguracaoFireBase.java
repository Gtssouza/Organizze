package com.example.organizze.activity.config;

import com.google.firebase.auth.FirebaseAuth;

public class ConfiguracaoFireBase {

    private static FirebaseAuth auth;

        //retorna instancia do FireBaseAuth
        public static FirebaseAuth getFireBaseAuth(){
            if(auth == null){
                auth = FirebaseAuth.getInstance();
            }
            return auth;
        }



}
