class Thermostat extends Device implements Controllable { // Наследование класса Device и подключение интерфейса Controllable

    private int temperature;

    public Thermostat(String name, boolean status, String color, int temperature){
        super(name, status, color);
        this.temperature = temperature;
    }
    public int get(){ // Переопределенный метод интерфейса Controllable
        return temperature;
    }
    public void set(int temperature){ // Переопределенный метод интерфейса Controllable
        this.temperature = temperature;
    }
}
