package dev.patika.veterinary_management_system.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "available_dates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Sadece tarih bilgisi saklanacak.
    @Column(nullable = false)
    private LocalDate availableDate;

    // İlişki: Bu müsaitlik, ilgili bir doktora aittir.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
