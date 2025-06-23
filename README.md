Veterinary Management System API
Bu proje, bir veteriner kliniğinin ihtiyaç duyduğu temel işlevleri karşılamak üzere tasarlanmış RESTful API geliştirmeye yöneliktir. Proje içerisinde;

Hayvanlar ve Sahipleri (Müşteriler):

Hayvanların eklenmesi, güncellenmesi, görüntülenmesi ve silinmesi

Müşteri (hayvan sahibi) bilgilerinin yönetimi ve isme göre filtreleme

Belirli bir müşteriye ait tüm hayvanların listelenmesi

Aşıların Yönetimi:

Hayvanlara uygulanan aşıların eklenmesi, güncellenmesi, görüntülenmesi ve silinmesi

Aynı tip (adı ve kodu aynı) aşıdan, aşı koruyuculuk bitiş tarihi henüz geçmemişse, yeni aşı eklenemeyecek şekilde kontrol

Belirli hayvan id’sine göre aşı kayıtlarının listelenmesi

Aşı koruyuculuk bitiş tarihi belli bir tarih aralığında olan aşıların, hayvan bilgileriyle birlikte listelenmesi

Randevu Yönetimi:

Hayvanların aşı ve muayene randevularının oluşturulması, güncellenmesi, görüntülenmesi ve silinmesi

Randevular LocalDateTime ile tarih ve saat bilgisi içerecek şekilde kaydedilir

Randevu oluşturulurken, doktorun o gün müsait olup olmadığı (sadece tarih olarak kayıtlı AvailableDate üzerinden) kontrolü

Aynı doktor için girilen tarih ve saatte başka bir randevu var mı kontrolü (çakışma önleme)

Çakışma veya müsaitlik olmadığında özel (custom) exception fırlatılarak hata mesajı verilir

Randevular; doktor ve hayvana göre ya da girilen tarih aralığına göre filtrelenebilmelidir

Veteriner Doktor ve Müsait Gün Yönetimi:

Doktorların kaydedilmesi, bilgilerinin güncellenmesi, görüntülenmesi ve silinmesi

Doktorların çalıştığı günlerin (sadece tarih bilgisi; saat, dakika, saniye içermeyen) eklenmesi, güncellenmesi, görüntülenmesi ve silinmesi

Teknolojiler ve Araçlar
Java 17 (veya daha güncel bir sürüm)

Spring Boot (REST API geliştirme, Spring Data JPA)

PostgreSQL (veritabanı)

Maven (proje yönetimi)

Lombok (getter, setter, constructor otomasyonu)

Swagger/OpenAPI (opsiyonel) API dokümantasyonu için

Postman API testleri ve koleksiyon yönetimi

Proje Yapısı
Proje aşağıdaki temel klasör yapısına göre organize edilmiştir:

veterinary-management-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── suheda/
│   │   │           └── veterinary/
│   │   │               ├── VeterinaryManagementSystemApplication.java   // Ana uygulama sınıfı
│   │   │               ├── config/                                     // Swagger, Security gibi konfigürasyon
│   │   │               ├── controller/                                 // API endpoint’leri (Animal, Customer, Doctor, Appointment vb.)
│   │   │               ├── dto/                                        // Veri transfer nesneleri
│   │   │               ├── entity/                                     // Tüm entity sınıfları (Animal, Customer, Vaccine, Doctor, AvailableDate, Appointment)
│   │   │               ├── exception/                                  // Custom exception’lar ve global hata yönetimi
│   │   │               ├── repository/                                 // Spring Data JPA repository’leri
│   │   │               └── service/                                    // İş mantığı (interface ve implementasyon)
│   │   │                   └── impl/
│   │   └── resources/
│   │       └── application.properties                                // Uygulama konfigürasyonu
│   │
├── src/test/java/com/suheda/veterinary/
│       └── ...                                                     // Test sınıfları
│
├── pom.xml                                                         // Maven yapılandırması
└── README.md                                                       // Proje açıklaması
Entity'ler
Proje aşağıdaki temel entity'lerden oluşur:

Animal:

id, name, species, breed, gender, colour, dateOfBirth

Her hayvan, bir Customer (sahibi) ile ilişkilidir.

Customer:

id, name, phone, mail, address, city

Bir müşterinin birden fazla hayvanı olabilir.

Vaccine:

id, name, code, protectionStartDate, protectionFinishDate

Her aşı kaydı, ilgili bir Animal ile ilişkilidir.

Doctor:

id, name, phone, mail, address, city

Doktorun randevuları ve uygun olduğu günler (AvailableDate) kaydedilir.

AvailableDate:

id, availableDate (sadece tarih bilgisi)

Her kayıt, bir Doctor ile ilişkilidir.

Appointment:

id, appointmentDate (LocalDateTime olarak tarih ve saat bilgisi)

Her randevu, bir Doctor ve bir Animal ilişkilendirmesi içerir.

Kurulum & Çalıştırma
Ön Koşullar:

JDK 17 veya üstü

Maven

PostgreSQL: Veritabanı sunucusunun kurulu ve çalışma durumunda olması

IDE (IntelliJ IDEA, Eclipse vb.)

Veritabanı Ayarları: src/main/resources/application.properties dosyasında veritabanı bağlantı bilgilerini (url, kullanıcı adı, şifre, driver) yapılandır.

Projeyi Çalıştırma:

Terminal veya IDE üzerinden Maven komutunu çalıştırın:

mvn spring-boot:run
Uygulama başlatıldığında, spring.jpa.hibernate.ddl-auto=update ayarı sayesinde veritabanında tablolar otomatik olarak oluşturulur.

API Dokümantasyonu: (Swagger/OpenAPI entegrasyonu yapıldıysa)

Uygulama çalıştığında, tarayıcı üzerinden http://localhost:8080/swagger-ui.html adresinden API dokümantasyonunu görüntüleyebilirsin.

API Kullanımı
Proje, temel CRUD işlemlerinin yanı sıra aşağıdaki iş kurallarını içerir:

Filtreleme Endpoints:

Müşteriler isme göre filtrelenecek.

Hayvanlar isme veya müşteri (sahip) id’sine göre filtrelenecek.

Belirli bir hayvana ait tüm aşı kayıtlarının listelenmesi.

Aşı İş Kuralları:

Aynı tip aşının (adı ve kodu aynı) koruyuculuk bitiş tarihi henüz geçmemişse, yeni aşı eklenmesine izin verilmez.

Randevu Oluşturma İş Kuralları:

Girilen randevu tarihinin (sadece tarih kısmı) doktorun müsaitlik günleri içerisinde olup olmadığı kontrol edilir.

Aynı doktor için, girilen tarih ve saatte başka bir randevunun olup olmadığı kontrol edilir.

Eğer kontrol başarısız olursa, custom exception fırlatılarak "Doktor bu tarihte çalışmamaktadır! / Girilen saatte başka bir randevu mevcuttur." mesajı verilir.

Randevular, doktor veya hayvana göre ya da kullanıcı tarafından girilen tarih aralığına göre filtrelenebilir.

Postman Koleksiyonu
Proje API'lerini test etmek için Postman koleksiyonu oluşturabilirsiniz. Koleksiyon içerisinde;

Customer, Animal, Vaccine, Doctor, AvailableDate, Appointment gibi CRUD endpointleri yer alır.

Örnek istekler ve JSON body örnekleri ile API'nin nasıl kullanılacağını gösterir.

(Daha önce paylaşılan örnek JSON'ları Postman’a import ederek hızlıca testlere başlayabilirsiniz.)

Katkıda Bulunma
Her türlü öneri ve geliştirme katkılarını memnuniyetle karşılıyoruz. Pull request’ler, issue bildirimi vs. için repository’yi fork ederek başlayabilirsiniz.

Lisans
Bu proje, MIT Lisansı kapsamında lisanslanmıştır.

Sonuç
Bu README, projenin temel işlevlerini, yapılandırmasını, API kullanımını ve çalışma kurallarını detaylandırmaktadır. Projenin geliştirilmesi sırasında karşılaşabileceğiniz her türlü problemi adım adım çözecek yapıda tasarlanmıştır. Herhangi bir sorunuz veya eklemek istediğiniz özellikler olursa, tartışmaya açığız!

Bu README projesi, yukarıda belirttiğin gereksinimlere uygun kapsamlı bir dokümantasyon sunar. Herhangi bir ekleme veya detaylandırma yapmak istersen, ona göre güncelleyebiliriz!
