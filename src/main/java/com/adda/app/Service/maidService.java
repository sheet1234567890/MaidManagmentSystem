package com.adda.app.Service;

import java.util.List;

import com.adda.app.Entity.Maid;

public interface maidService {

	public Maid SaveMaid(Maid maid);
	public List<Maid> listofMaids();
	public List<Maid> listOfActiveMaids();
	public List<Maid>listOfCategoryWiseMaids(Long cid);
	public void Deletemaid(Long id);
	
}
