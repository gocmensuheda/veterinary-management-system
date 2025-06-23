![BCO 2193e830-e000-4211-9988-c4733cf97ec4](https://github.com/user-attachments/assets/dc6bbef6-b1ba-450f-9ad2-f4549cc65668) 🐾 Veterinary Management System

Veteriner kliniklerinin hayvan, müşteri, doktor, aşı ve randevu takibini kolaylaştırmak için geliştirilmiş bir RESTful API uygulamasıdır.

---

## 🚀 Özellikler

- Hayvan ve müşteri yönetimi (ekle, listele, güncelle, sil)
- Aşı kayıtları ve tekrar aşı kuralı
- Doktorların çalışma günleri
- Randevu sistemi (müsaitlik ve saat çakışma kontrolleri)
- İsimle arama ve tarih filtrelemeleri
- Custom exception'lar ve anlamlı hata mesajları

---

## 🧰 Kullanılan Teknolojiler

| Teknoloji     | Açıklama                |
|---------------|-------------------------|
| Java 17       | Programlama dili        |
| Spring Boot   | Uygulama çatısı         |
| Spring Data JPA | Veritabanı işlemleri |
| PostgreSQL / MySQL | Veritabanı         |
| Lombok        | Kod sadeleştirme        |
| Maven         | Build ve bağımlılıklar |

---

## 🧩 UML Diyagramı


Entity’ler arası ilişki yapısı:


+----------------+             +----------------+            +----------------+
|   Customer     |1           *|     Animal     |1          *|    Vaccine     |
+----------------+-------------+----------------+------------+----------------+
| - id: Long     |             | - id: Long     |            | - id: Long     |
| - name: String |             | - name: String |            | - name: String |
| - phone: String|             | - species: Str |            | - code: String |
| - mail: String |             | - breed: String|            | - startDate: LocalDate |
| - address: Str |             | - gender: Str  |            | - endDate: LocalDate   |
| - city: String |             | - colour: Str  |            |                    |
+----------------+             | - dob: LocalDate            |                    |
                               +----------------+            +------------------+
                                        |
                                        |1
                                        |
                              +---------+---------+
                              |     Appointment    |
                              +--------------------+
                              | - id: Long         |
                              | - appointmentDate: LocalDateTime |
                              +--------+-----------+
                                       |
               +----------------+     1|          1      +------------------+
               |    Doctor      |<------+--------------->|  AvailableDate   |
               +----------------+                      +------------------+
               | - id: Long     |                      | - id: Long       |
               | - name: String |                      | - availableDate: LocalDate |
               | - phone: String|                      +------------------+
               | - mail: String |
               | - address: Str |
               | - city: String |
               +----------------+


---

## 📦 Kurulum

```bash
git clone https://github.com/kullanici-adi/veterinary-management-system.git
cd veterinary-management-system
mvn clean install
mvn spring-boot:run
🔧 src/main/resources/application.properties dosyasını veritabanına göre güncelleyin.

📮 Örnek API Kullanımı
✅ Hayvan Ekleme
http
POST /api/animals
Content-Type: application/json
json
{
  "name": "Pamuk",
  "species": "Kedi",
  "breed": "Tekir",
  "gender": "Dişi",
  "colour": "Beyaz",
  "dateOfBirth": "2021-06-01",
  "owner": { "id": 1 }
}
📁 Proje Klasör Yapısı (önerilen)
├── README.md
├── veterinary.sql
├── docs/
│   ├── veterinary_uml.png
│   └── postman_preview.png
├── postman/
│   └── Veterinary System - Suheda.postman_collection.json
├── src/
│   └── main/...
💬 Hata Yönetimi
"Kayıt sistemde mevcut." – Duplicate verilerde

"Girilen saatte başka bir randevu mevcuttur." – Çakışan randevu

"Doktor bu tarihte çalışmamaktadır!" – Uygun olmayan gün

"ID'li kayıt bulunamadı." – Silme/güncelleme öncesi kayıt kontrolü

📬 Postman Koleksiyonu
Tüm istekler örnek JSON gövdeleriyle birlikte şu dosyada: 📂 Veterinary System - Suheda.postman_collection.json

🧪 Veritabanı Yedeklemesi
📄 veterinary.sql dosyasını yükleyerek örnek kayıtlarla tablo yapısını import edebilirsin.

👩‍💻 Geliştirici
Şuheda 💻 Backend Developer · 🎯 Spring Boot & UML Odaklı 🌍 Bursa, Türkiye
