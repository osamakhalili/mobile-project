import java.util.List;

public interface MobileRepository {
    List<Mobile> fetchAll();

    public Mobile insert(Mobile m);

    public Mobile update(Mobile m);

    public boolean remove(Mobile m);
}
