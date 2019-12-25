package com.luv2code.e2e.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lzugaj on Sunday, December 2019
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;

	@Column(name = "user_name")
	private String username;

	@Column(name = "user_password")
	private String password;

	@ToString.Exclude
	@OneToMany(mappedBy = "user",
			fetch = FetchType.LAZY,
			cascade = { CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.REFRESH, CascadeType.PERSIST })
	private List<Message> messages;

	@ToString.Exclude
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

}
