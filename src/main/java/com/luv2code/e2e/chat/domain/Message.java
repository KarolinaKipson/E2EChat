package com.luv2code.e2e.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by lzugaj on Wednesday, December 2019
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_message")
	private Long id;

	@Column(name = "content")
	private String content;

	@Column(name = "sending_date")
	private LocalDateTime sendingDate;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;

}
