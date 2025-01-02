package ru.paul.reserve.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import ru.paul.reserve.enums.Role;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "reserve", name = "accounts")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NonNull
    @Column(nullable = false, length = 256)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String password;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "chipper")
    private List<Animal> animals = new ArrayList<>();
}