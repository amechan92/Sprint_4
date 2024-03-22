package pages;

public class Utils {

    public static class FormData {
        private String name;
        private String surname;
        private String address;
        private String phone;
        private String deliveryDate;
        private String courierComment;

        // Конструктор
        public FormData(String name, String surname, String address, String phone, String deliveryDate, String courierComment) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.phone = phone;
            this.deliveryDate = deliveryDate;
            this.courierComment = courierComment;
        }

        // Геттеры и Сеттеры
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getDeliveryDate() {
            return deliveryDate;
        }

        public void setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        public String getCourierComment() {
            return courierComment;
        }

        public void setCourierComment(String courierComment) {
            this.courierComment = courierComment;
        }
    }

    // Методы для получения предопределённых наборов данных
    public static FormData dataSet1() {
        return new FormData(
                "Иван",
                "Иванов",
                "Москва, Кремль",
                "+71234567890",
                "01.04.2024",
                "Позвонить за час"
        );
    }

    public static FormData dataSet2() {
        return new FormData(
                "Петр",
                "Петров",
                "Санкт-Петербург, Эрмитаж",
                "+79876543210",
                "15.04.2024",
                "Не звонить"
        );
    }
}
