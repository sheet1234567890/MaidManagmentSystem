package com.adda.app.reposatory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adda.app.Entity.Maid;

public interface MaidRepo extends JpaRepository<Maid, Long> {
   @Query("SELECT m From Maid m WHERE m.isActive=true ")
	List<Maid> activemaidlist();
   @Query("SELECT m From Maid m WHERE m.category.id=:cid ")
List<Maid> getMaidsByCategoryId(Long cid);

}
