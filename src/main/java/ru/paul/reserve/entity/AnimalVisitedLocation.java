package ru.paul.reserve.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.sql.Timestamp;

@Entity
@Table(schema = "reserve", name = "animal_visited_locations")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AnimalVisitedLocation {

    @Id
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Id
    @ManyToOne
    @JoinColumn(name = "point_id")
    private Point point;

    @NonNull
    @Column(name = "visit_datetime", nullable = false)
    private Timestamp visitDateTime;
}