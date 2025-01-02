package ru.paul.reserve.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(schema = "reserve", name = "areas")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "areas", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<Point> points = new ArrayList<>();
}