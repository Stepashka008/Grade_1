class Light extends Device implements Controllable { // Наследование класса Device и подключение интерфейса Controllable

    private int brightness;

    public Light(String name, boolean status, String color, int brightness){
        super(name, status, color);
        this.brightness = brightness;
    }

    public int get(){ // Переопределенный метод интерфейса Controllable
        return brightness;
    }
    public void set(int brightness){ // Переопределенный метод интерфейса Controllable
        this.brightness = brightness;
    }
}
