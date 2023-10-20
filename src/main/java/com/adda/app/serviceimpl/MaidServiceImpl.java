package com.adda.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adda.app.Entity.Maid;
import com.adda.app.Service.maidService;
import com.adda.app.reposatory.MaidRepo;
@Service
public class MaidServiceImpl implements maidService {
  @Autowired
	private MaidRepo repo;
	@Override
	public Maid SaveMaid(Maid maid) {
		// TODO Auto-generated method stub
		return this.repo.save(maid);
	}

	@Override
	public List<Maid> listofMaids() {
		// TODO Auto-generated method stub
		return repo.findAll();
 	}

	@Override
	public List<Maid> listOfActiveMaids() {
		// TODO Auto-generated method stub
		return repo.activemaidlist();
	}

	@Override
	public List<Maid> listOfCategoryWiseMaids(Long cid) {
		// TODO Auto-generated method stub
		return repo.getMaidsByCategoryId(cid);
	}

	@Override
	public void Deletemaid(Long id) {
		// TODO Auto-generated method stub
		Maid m = this.repo.findById(id).orElse(null);
		this.repo.delete(m);
	}

}
