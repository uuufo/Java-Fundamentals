package labs_examples.input_output.labs.Exercise_04;

public class Electronic {

    // POJO for an electronics item

    private String name;
    private String make;
    private String model;
    private String serial;
    private String desc;

    public Electronic() {
    }

    public Electronic(String name, String make, String model, String serial, String desc) {
        this.name = name;
        this.make = make;
        this.model = model;
        this.serial = serial;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "name='" + name + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", serial=" + serial +
                ", desc='" + desc + '\'' +
                '}';
    }
}
