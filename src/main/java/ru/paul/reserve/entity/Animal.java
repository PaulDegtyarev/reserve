package ru.paul.reserve.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import ru.paul.reserve.enums.Gender;
import ru.paul.reserve.enums.LifeStatus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "reserve", name = "animals")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private Float weight;

    @NonNull
    @Column(nullable = false)
    private Float length;

    @NonNull
    @Column(nullable = false)
    private Float height;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "life_status", nullable = false)
    private LifeStatus lifeStatus;

    @NonNull
    private Timestamp deathDatetime;

    @NonNull
    @Column(name = "chipping_datetime",nullable = false)
    private Timestamp chippingDatetime;

    @ManyToOne
    @JoinColumn(name="chipper_id", nullable=false)
    private Account chipper;

    @ManyToOne
    @JoinColumn(name="chipping_location_id", nullable=false)
    private Point chippingLocation;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "animals_types",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    List<Type> types = new ArrayList<>();

    @OneToMany(mappedBy = "animal")
    private List<AnimalVisitedLocation> visitedLocations = new ArrayList<>();
}
