package edu.upc.dsa;

import edu.upc.dsa.models.Insignia;
import edu.upc.dsa.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Minimo2Impl implements Minimo2{
    private boolean dirty=false;
    private HashMap<String, User > hmUsers;
    private List<Insignia> insigniaList;

    private Minimo2Impl(){
        insigniaList = new ArrayList<>();
        hmUsers = new HashMap<String,User>();

    }

    private static Minimo2 instance;

    public static Minimo2 getInstance() {
        if (instance==null)
        {
            instance = new Minimo2Impl();
        }

        return instance;
    }

    public void addInsignia(Insignia i){
        insigniaList.add(i);
    }

    public void addUser(User user){
        hmUsers.put(user.getId(),user);
    }

    @Override
    public List<Insignia> getInsignias() {
        return insigniaList;
    }

    @Override
    public List<Insignia> getInsigniasByUser(String id) {
        User u = hmUsers.get(id);
        return u.getInsigniaList();
    }

    @Override
    public User getUser(String id) {
        return hmUsers.get(id);
    }

    @Override
    public void dirty() {
        this.dirty = true;
    }

    @Override
    public boolean isDirty(){
        return dirty;
    }

    public void clear(){
        insigniaList.clear();
        hmUsers.clear();
    }
}
