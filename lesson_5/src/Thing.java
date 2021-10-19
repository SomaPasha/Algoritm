public class Thing {
    private  String name;
    private Integer weight;
    private Integer icon;
    public Thing() {

    }
    public Thing(String name, Integer weight, Integer icon) {
        this.name = name;
        this.weight = weight;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }
}
