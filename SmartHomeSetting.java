import java.util.HashMap;
class SmartHomeSetting {
    // Поиск осуществляется по имени (то есть ключом является имя устройства)
    HashMap<String, Light> listLight = new HashMap<>(); // Яркость
    HashMap<String, Thermostat> listThermostat = new HashMap<>(); // Температура
}
