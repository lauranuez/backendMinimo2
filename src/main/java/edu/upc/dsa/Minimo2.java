package edu.upc.dsa;

import edu.upc.dsa.models.Insignia;
import edu.upc.dsa.models.User;

import java.util.List;

public interface Minimo2 {
    public List<Insignia> getInsignias();
    public List<Insignia> getInsigniasByUser(String id);
    public User getUser(String id);
    public void addInsignia(Insignia i);
    public void addUser(User user);
    public void dirty();
    public boolean isDirty();
    public void clear();
}
