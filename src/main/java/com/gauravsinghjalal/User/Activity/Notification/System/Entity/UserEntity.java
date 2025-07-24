package com.gauravsinghjalal.User.Activity.Notification.System.Entity;

import com.gauravsinghjalal.User.Activity.Notification.System.Model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;


    @ElementCollection(fetch = FetchType.EAGER)
//    What it does:
//    Tells JPA: “This field is a collection of values (like a list or set), but it’s not another entity.”
//    It’s not a separate Role entity — it’s just a collection of Enums (or basic types).
//    EAGER means: load this collection immediately when the User is loaded.
//✅ Why it's needed:
//    You're storing a Set of Enum values, not full entity objects.

    @Enumerated(EnumType.STRING)
//    What it does:
//    Tells JPA to save the enum as its string name ("USER", "ADMIN") instead of the enum's ordinal number (0, 1, 2).
//            ✅ Why it's good:
//    Human-readable in the database
//    Safe from enum ordering bugs (e.g., if the enum order changes later)
    @CollectionTable(name = "user_roles",
            //This defines the "user_roles" table, which is a separate join table that maps each User to their roles.
            joinColumns = @JoinColumn(name = "user_id"))
    //    Yes: It allows multiple different roles per user
//    No: It does not allow the same role twice
//    It represents a unique collection of roles naturally
    @Column(name = "role")
    private Set<Role> roles= new HashSet<>();

}
