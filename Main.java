class Main
{
    public static void main (String[] args)
    {
        int maxCount = 10; // Максимальное кол-во устройств в доме
        SmartHome smartHome = new SmartHome(maxCount);
        smartHome.addDevice("Плита", false, "Серый"); // Добавление устройств
        smartHome.addDevice("Утюг", false, "Белый");
        smartHome.addDevice("Лампа", true, "Коричневый");

        smartHome.switcDevice("Утюг"); // Переключение статуса

        smartHome.statusCheckDevice(); // Вывод статуса всех устройств

        smartHome.infoDevice("Утюг"); // Вывод полной информации об устройстве
        smartHome.infoDevice("Лампа");
    }
}