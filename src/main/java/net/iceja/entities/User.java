/*
Copyright (c) 2019  Ekaterina Alexeevna Ivanova. All rights reserved.
PROPRIETARY. For demo purposes only, not for redistribution or any commercial 
use.
*/

package net.iceja.entities;


import java.util.Objects;



/**
 *
 * @author Ekaterina Alexeevna Ivanova
 */


public class User {
    
    private String fio;
    private String password;
    private String login;
    
    private User(){
        
    }

    public User (String firstname, String lastname, String patronymic){
           this.setFio(firstname);
           this.login = lastname;
           this.password = patronymic;
    }
    
    public User (String fio, String login){
    	this(fio, login, "");
 }


    
    @Override
    public int hashCode(){
        if(password == null || login == null || getFio() == null )
            return 0;
        int code =  (login.charAt(0) * 100000000) + 
                (password.charAt(0)  * 1000000000) +  (getFio().charAt(0) * 100000000) ;
                
        return code;
        
    } 

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.getFio(), other.getFio())) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    
    @Override
     public String toString(){
         
         return getFio();
     }
   

    /**
     * @return the patronymic
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param patronymic the patronymic to set
     */
    public void setPassword(String patronymic) {
        this.password = patronymic;
    }

    /**
     * @return the lastname
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLogin(String lastname) {
        this.login = lastname;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }


    public enum Gender {
        FEMALE("Ж"),
        MALE("М");
        String name ;
        Gender(String n){
            this.name = n;
        }
    
    }
            
    
}
