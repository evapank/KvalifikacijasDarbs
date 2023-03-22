package com.siite.demo.models;

import com.siite.demo.enums.TemplateEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "myWebsite_table")
@Entity
public class MyWebsite {
	
	@Column(name = "IdWeb")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idWeb;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Heading")
	private String heading;
	
	@Column(name = "Paragraph")
	private String paragraph;
	
	@Column(name = "Template")
	private TemplateEnum template;
	
	@ManyToOne
	@JoinColumn(name = "IdUser")
	private MyUser owner;

}
