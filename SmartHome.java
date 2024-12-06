class SmartHome{

    private int count = 0; // Кол-во устройств в доме
    Device[] devices;

    public SmartHome(int maxCount){
        devices = new Device[maxCount];
    }

    public void addDevice(String name, boolean status,  String color){ // Добавление устройства в массив
        Add add = new Add(name, status, color);
        add.addElement();
    }

    private class Add{ // Класс для добавления устройства

        String name;
        boolean status; // Статус по умолчанию выключен
        String color;

        public Add(String name, boolean status, String color){
            this.name = name;
            this.status = status;
            this.color = color;
        }

        public void addElement(){
            try{
                devices[count] = new Device(name, status, color);
                System.out.println("Устройство: " + name + " - добавлено в дом");
                count++;
            }
            catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("Вы добавили максимальное кол-во устройств!");
            }
        }
    }

    public void switcDevice(String name){ // Переключение статуса устройства
        Switc switc = new Switc(name);
        switc.switcElement();
    }

    private class Switc{ // Класс для переключения статуса

        String name;

        public Switc(String name){
            this.name = name;
        }

        public void switcElement(){
            for (Device device : devices) { // Заменили for на foreach!!!
                if (device != null && device.getName().equals(name)) { // equals - сравнение строк
                    device.setStatus(!device.getStatus());
                    System.out.println("\nСтатус устройства: " + device.getName() + ", переключён на: " + device.getStatus());
                    break;
                }
            }
        }
    }

    public void statusCheckDevice(){ // Вывод статуса всех устройств
        CheckStatus checkStatus = new CheckStatus();
        checkStatus.statusCheck();
    }

    private class CheckStatus{

        public void statusCheck(){
            System.out.println("\nВывод статуса всех устройств: "); System.out.println("-------------------------------------");
            for (Device device : devices) {
                if (device == null) {
                    break;
                } else {
                    System.out.println("Статус устройства: " + device.getName() + " = " + device.getStatus());
                    System.out.println("-------------------------------------");
                }
            }
        }
    }

    public void infoDevice(String name){ // Вывод полной информации об устройстве
        Info info = new Info(name);
        info.OpenInfoDevice();
    }

    private class Info{

        String name;

        public  Info(String name){
            this.name = name;
        }

        public void OpenInfoDevice(){
            System.out.println("\nВывод полной информации об устройстве: ");
            for (Device device : devices) {
                if (device != null && device.getName().equals(name)) {
                    System.out.println("Имя устройства: " + device.getName() + "\nСтатус устройства: " + device.getStatus() + "\nЦвет устройства: " + device.getColor());
                }
            }
        }
    }
}
