class Device{

    private String name;
    private boolean status;
    private String color;

    public Device(String name, boolean status, String color){
        this.name = name;
        this.status = status;
        this.color = color;
    }

    public String getName(){
        return name;
    }

    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    public String getColor(){
        return color;
    }
}
