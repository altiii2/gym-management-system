public class Main {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТ TRAINER ===");

        // Тест 1: Валидный тренер
        Trainer goodTrainer = new Trainer(1, "Mike Johnson", "Strength", 8, true, 7000);
        System.out.println("✅ Валидный тренер создан: " + goodTrainer.getName());

        // Тест 2: Невалидные данные
        System.out.println("\n=== ТЕСТ НЕВАЛИДНЫХ ДАННЫХ ===");
        Trainer badTrainer = new Trainer(-5, "", "", 60, true, -1000);
        System.out.println("⚠️ Тренер с ошибками создан (с исправлениями)");

        // Проверка исправлений
        System.out.println("ID исправлен на: " + badTrainer.getTrainerId());
        System.out.println("Имя исправлено на: " + badTrainer.getName());
        System.out.println("Стаж исправлен на: " + badTrainer.getExperienceYears());
    }
}