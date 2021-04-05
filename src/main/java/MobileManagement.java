import java.util.*;

public class MobileManagement implements MobileRepository {
    public static  ArrayList<Mobile> mobiles = new ArrayList<>();
    public MobileManagement(ArrayList<Mobile> mobiles){
        this.mobiles = mobiles;
    }
    public MobileManagement(){

        mobiles.add(new Mobile("Iphone","4",2010,256,200));
        mobiles.add(new Mobile("Iphone","4s" ,2010,256,200));
        mobiles.add(new Mobile("Iphone","5" ,2010,256,200));
        mobiles.add(new Mobile("Iphone","5s" ,2010,256,200));
        mobiles.add(new Mobile("Iphone","5s pro" ,2010,256,200));
        mobiles.add(new Mobile("Iphone","6" ,2010,256,200));
        mobiles.add(new Mobile("Iphone","6s" ,2010,256,200));
        mobiles.add(new Mobile("Iphone","6s plus" ,2010,256,200));
    }

    @Override
    public List<Mobile> fetchAll() {
        return mobiles;
    }

    @Override
    public Mobile insert(Mobile m) {
        if(mobiles.stream().filter(c->c.getId()==m.getId()).count()>0){
            throw new RuntimeException("Mobile is exist in db");
        }else{
            mobiles.add(m);
            return mobiles.get(mobiles.indexOf(m));
        }

    }

    @Override
    public Mobile update(Mobile m) {
        for (Mobile mob:mobiles) {
            if(mob.getId()==m.getId()) {
                mob.setMemory(m.getMemory());
                mob.setMobileName(m.getMobileName());
                mob.setMobileYear(m.getMobileYear());
                mob.setMobileModel(m.getMobileModel());
                mob.setPrice(m.getPrice());
                return mob;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Mobile m) {
        if(mobiles.indexOf(m)>-1){
            mobiles.removeIf(c->c.getId()==m.getId());
            return  true;
        }
        return  true;
    }
}
