import javax.swing.JOptionPane;
import java.util.*;

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
        Switc switc = new Switc(name);
        switc.switcElement();
    }

    private class Switc{ // Класс для переключения статуса

        String name;

        public Switc(String name){
            this.name = name;
        }

        public void switcElement(){
            foundDevice(name).setStatus(!foundDevice(name).getStatus());
            System.out.println("\nСтатус устройства: " + foundDevice(name).getName() + ", переключён на: " + foundDevice(name).getStatus());
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
            System.out.println("Имя устройства: " + foundDevice(name).getName() + "\nСтатус устройства: " + foundDevice(name).getStatus() + "\nЦвет устройства: " + foundDevice(name).getColor());
        }
    }

    public void removeDevice(String name){ // Метод удаления устройства из списка
        devices.remove(foundDevice(name)); // Удаление устройства из списка
        System.out.println("\nУстройство " + name + " удалено");
    }
    public Device foundDevice(String name){ // Метод поиска устройства
        for (Device device : devices) {
            if (device.getName().equals(name)) {
                return device;
            }
        }
        try {
            throw new DeviceNotFoundException("Устройства c названием " + name + " в доме нету");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка!", JOptionPane.ERROR_MESSAGE); // Вывод информации пользователю
        }
        return null;
    }

    public void ALlDevices(){ // Вывод всех устройств с помощью итератора
        System.out.println("\nВывод всех устройств");
        ExitDevice exitDevice = new ExitDevice(devices);
    }

    private class ExitDevice{

        String text = "";
        Iterator<Device> iterator;

        public ExitDevice(List allDevice){
            iterator = allDevice.listIterator(); // Перевод нашего списка устройств в итератор
            infoDeviceExit(iterator);
        }

        public void infoDeviceExit(Iterator<Device> iterator){
            while (iterator.hasNext()){ // Проверка на следующий элемент
                Device device = iterator.next();
                text += "Имя: " + device.getName() + ", Цвет: " +  device.getColor() + ", Статус: " + device.getStatus() + "\n";
            }
            System.out.println(text);
        }

    }
}

class DeviceNotFoundException extends Exception{ // Создаем свою ошибку наследованную от суппер класс Exception

    public DeviceNotFoundException(String txt){
        super(txt); // Передаем аргумент нашему родителю
    }
}
