package com.adda.app.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Maid {
	@Id
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
    private String profile;
    private boolean isActive;
   
    @Lob
	@Column(name="imageData",length = 1000)
	private byte[] profileData;
   
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "maid")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "maid")
    private List<Review> reviews;

    @OneToMany(mappedBy = "maid")
    private List<Payment> payments;
    
    @ManyToMany
    @JoinTable(
      name = "user_maid",
      joinColumns = @JoinColumn(name = "maid_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

}
