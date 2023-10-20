
package com.adda.app.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adda.app.Entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, Long>{

}
