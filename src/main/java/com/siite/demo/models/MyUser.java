package com.siite.demo.models;

import java.util.Collection;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "myUser_table")
@Entity
public class MyUser {
	
	@Column(name = "IdUser")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idUser;
	
	@Column(name = "Username")
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9]+")
	private String username;
	
	@Column(name = "Email")
	@Email (regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
	private String email;
	
	@Column(name = "Password")
	@Size(min = 8, max = 60)
	@Pattern(regexp = "[a-zA-Z0-9\\S]+")
	private String password;
	
	@Column(name = "IsAdmin")
	@NotNull
	private boolean isAdmin;
	
	@Column(name = "Websites")
	@OneToMany(mappedBy = "owner")
	private Collection<MyWebsite> websites;

}
