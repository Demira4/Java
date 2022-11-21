package lessFive;

    public class Worker {
    //   1 . Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    private String FIO;
    private String position;
    private String eMail;
    private String phone;
    private int paycheck;
    private int age;

        public int getAge() {
            return age;
        }

        public void setPaycheck(int paycheck) {
            this.paycheck = Math.abs(paycheck);
        }

        public void setAge(int age) {
            if (age>68) {
                System.out.println("Ошибка введен не верно возраст! Проверьте ввод данных!");
            }
            this.age = Math.abs(age);
        }

        //2. Конструктор класса должен заполнять эти поля при создании объекта.
        public Worker(String FIO, String position, String eMail, String phone, int paycheck, int age) {
        this.FIO = FIO;
        this.position = position;
        this.eMail = eMail;
        this.phone = phone;
        this.paycheck = paycheck;
        this.age = age;
    }

        //3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
        public void printInfo () {
            System.out.println(String.format(" ФИО сотрудника: %s%n Должность: %s%n Электронная почта: %s%n Телефон: %s%n Оклад: %s%n Возраст: %s%n", FIO, position,eMail,phone,paycheck,age));
        }

    }