package lessFive;

public class Main {
    public static void main (String[] args){
 //       4. Создать массив из 5 сотрудников.
//            Пример:
//    Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//    persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//    persArray[1] = new Person(...);
//...
//    persArray[4] = new Person(...);
        Worker [] workerArray = new Worker[5];
        workerArray[0] = new Worker(" Иванов Иван Иванович", "Генеральный директор", "gendir@info.com", "123456789", 100000, 50);
        workerArray[1] = new Worker(" Петров Петр Петрович", "Финансовый директор", "findir@info.com", "234567891", 80000, 45);
        workerArray[2] = new Worker(" Белов Алексондр Сергеевич", "Директор по продажам", "saledir@info.com", "345678912", 50000, 41);
        workerArray[3] = new Worker(" Блинов Владимир Никифорович", "Директор по складам", "skdir@info.com", "456789123", 50000, 43);
        workerArray[4] = new Worker(" Казаков Виктор Алексеевич", "Директор по логистике", "logdir@info.com", "567891234", 50000, 39);
//5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
    for (int i = 0; i< workerArray.length; i++){
        if (workerArray[i].getAge()>= 40) {
            workerArray[i].printInfo();
        }
    }


    }
}
