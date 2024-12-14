class Device{

    private String name; private String fixedName;
    private boolean status; private boolean fixedStatus;
    private String color; private String fixedColor;

    public Device(String name, boolean status, String color){
        this.name = name; fixedName = name;
        this.status = status; fixedStatus = status;
        this.color = color; fixedColor = color;
    }

    public String getFixedName(){
        return fixedName;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public boolean getFixedStatus(){
        return fixedStatus;
    }
    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    public String getFixedColor(){
        return fixedColor;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
}
