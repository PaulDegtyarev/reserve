package ru.paul.reserve.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "reserve", name = "points")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private Double latitude;

    @NonNull
    @Column(nullable = false)
    private Double longitude;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "area_points",
            joinColumns = @JoinColumn(name = "point_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id"))
    List<Area> areas = new ArrayList<>();

    @OneToMany(mappedBy = "chippingLocation")
    private List<Animal> chippedAnimals = new ArrayList<>();

    @OneToMany(mappedBy = "point")
    private List<AnimalVisitedLocation> animalVisitedLocations = new ArrayList<>();
}