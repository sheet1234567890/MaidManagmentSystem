
package com.adda.app.reposatory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adda.app.Entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, Long>{
  @Query("SELECT r FROM Rating r WHERE r.maid.mId=:mid")
	List<Rating> getRatingByMaidId(Long mid);

}
