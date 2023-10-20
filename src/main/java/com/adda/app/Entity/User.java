package com.adda.app.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userId;
	    private String FirstName;
	    private String LastName;
	    private String email;
	    private String verification;
	    private String mobile;
	    private String password;
	    private String dob;
	    private String gender;
	    private String location;
	    private String profile="default.png";
	    @ElementCollection(fetch = FetchType.EAGER)
	    private List<String> role;
	    private boolean isActive=true;
	    @Lob
		@Column(name="imageData",length = 1000)
		private byte[] profileData;
	    @OneToMany(mappedBy = "user")
	    private List<Rating> ratings;

	    @OneToMany(mappedBy = "user")
	    private List<Review> reviews;

	    @OneToMany(mappedBy = "user")
	    private List<Payment> payments;
	    
	    @ManyToMany(mappedBy = "users")
	    private List<Maid> maids;
}
