class SmartHome{

    Device[] devices;

    public SmartHome(int count){
        devices = new Device[count];
    }

    public void addDevice(String name, boolean status, String color){ // Добавление устройства в массив
        for(int i = 0; i < devices.length; i++){
            if(devices[i] == null){
                devices[i] = new Device(name, status, color);
                System.out.println(devices[i].getName() + " - Добавлен в массив устройств");
                break;
            }
        }
    }

    public void switcDevice(String name){ // Переключение статуса устройства
        for(int i = 0; i < devices.length; i++){
            if(devices[i] != null && devices[i].getName().equals(name)){
                devices[i].setStatus(!devices[i].getStatus());
                System.out.println("Статус устройства: " + devices[i].getName() + ", переключён на: " + devices[i].getStatus());
                break;
            }
        }
    }

    public void statusCheckDevice(){ // Вывод статуса всех устройств
        for(int i = 0; i < devices.length; i++){
            if(devices[i] == null){
                break;
            }
            else{
                System.out.println("Статус устройства: " + devices[i].getName() + " = " + devices[i].getStatus());
            }
        }
    }

    public void infoDevice(String name){ // Вывод полной информации об устройстве
        for(int i = 0; i < devices.length; i++){
            if(devices[i] != null && devices[i].getName() == name){
                System.out.println("Имя устройства: " + devices[i].getName() + "\nСтатус устройства: " + devices[i].getStatus() + "\nЦвет устройства: " + devices[i].getColor());
            }
        }
    }
}
