import javax.swing.JOptionPane;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
class SmartHome{

    private int count = 0; // Кол-во устройств в доме

    List<Device> devices; // Список устройств

    public SmartHome(){
        devices = new ArrayList<>();
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
            devices.add(new Device(name, status, color));
            System.out.println("Устройство: " + name + " - добавлено в дом");
            count++;
        }
    }

    public void switchDevice(String name){ // Переключение статуса устройства
        if (foundDevice(name)){ // Если устройство вообще есть
            Switc switc = new Switc(name);
            switc.switcElement();
        }
    }

    private class Switc{ // Класс для переключения статуса

        String name;

        public Switc(String name){
            this.name = name;
        }

        public void switcElement(){
            for (Device device : devices) { // foreach, device - наш объект
                if (device.getName().equals(name)) { // equals - сравнение строк
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
                System.out.println("Статус устройства: " + device.getName() + " = " + device.getStatus());
                System.out.println("-------------------------------------");
            }
        }
    }

    public void infoDevice(String name){ // Вывод полной информации об устройстве
        if (foundDevice(name)){ // Если устройство вообще есть
            Info info = new Info(name);
            info.OpenInfoDevice();
        }
    }

    private class Info{

        String name;

        public  Info(String name){
            this.name = name;
        }

        public void OpenInfoDevice(){
            System.out.println("\nВывод полной информации об устройстве: ");
            for (Device device : devices) {
                if (device.getName().equals(name)) {
                    System.out.println("Имя устройства: " + device.getName() + "\nСтатус устройства: " + device.getStatus() + "\nЦвет устройства: " + device.getColor());
                    break;
                }
            }
        }
    }

    public void removeDevice(String name){ // Метод удаления устройства из списка
        if (foundDevice(name)){ // Если устройство вообще есть
            for (Device device : devices){
                if (device.getName().equals(name)){
                    devices.remove(device); // Удаление устройства из списка
                    System.out.println("\nУстройство " + name + " удалено");
                    break;
                }
            }
        }
    }
    public boolean foundDevice(String name){
        for (Device device : devices) {
            if (device.getName().equals(name)) {
                System.out.println("\nУстройство " + name + " найдно");
                return true;
            }
        }
        try {
            throw new DeviceNotFoundException("Такого устройства в доме нету");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка!", JOptionPane.ERROR_MESSAGE); // Вывод информации пользователю
        }
        return false;
    }
}

class DeviceNotFoundException extends Exception{ // Создаем свою ошибку наследованную от суппер класс Exception

    public DeviceNotFoundException(String txt){
        super(txt); // Передаем аргумент нашему родителю
    }
}
