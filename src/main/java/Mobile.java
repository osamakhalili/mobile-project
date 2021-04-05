public class Mobile {
    private static int increament = 0;
    private int id;
    private String mobileName;
    private String mobileModel;
    private double mobileYear;
    private double memory;
    private double price;

    public  Mobile(){

    }
    public Mobile (String mobileName, String mobileModel, double mobileYear, double memory, double price) {
        this.id = ++increament;
        this.mobileName = mobileName;
        this.mobileModel = mobileModel;
        this.mobileYear = mobileYear;
        this.memory = memory;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }


    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public double getMobileYear() {
        return mobileYear;
    }

    public void setMobileYear(double mobileYear) {
        this.mobileYear = mobileYear;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id: "+id+", Mobile name: "+ mobileName+", Mobile Model: "+mobileModel+", mobileYear: "+mobileYear+", memory: "+memory+", GB, price: "+price+" ";
    }



}
