class Main
{
    public static void main (String[] args)
    {
        SmartHome smartHome = new SmartHome();
        smartHome.addDevice("Плита", false, "Серый"); // Добавление устройств
        smartHome.addDevice("Утюг", false, "Белый");
        smartHome.addDevice("Лампа", true, "Коричневый");

        smartHome.switchDevice("Утюг"); // Переключение статуса

        smartHome.statusCheckDevice(); // Вывод статуса всех устройств

        smartHome.infoDevice("Утюг"); // Вывод полной информации об устройстве
        smartHome.infoDevice("Лампа");

        smartHome.removeDevice("Утюг"); // Удаление утюга из списка
        smartHome.statusCheckDevice(); // Вывод статуса всех устройств
        System.out.println("Устройство: " + smartHome.foundDevice("Плита").getName() + " найдено"); // Поиск устройства
        smartHome.foundDevice("Скамейка"); // Намеренный вызов ошибки

        smartHome.ALlDevices(); // Вывод всех устройств
    }
}