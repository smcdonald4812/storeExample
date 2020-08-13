package com.mcdonald.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcdonald.models.MembershipTiers;
import com.mcdonald.repositories.MembershipTiersRepository;

public class MembershipTiersService implements Service<MembershipTiers>{
	@Autowired
	MembershipTiersRepository mtr;
	@Override
	public Optional<MembershipTiers> read(int id) {
		return mtr.findById(id);
	}
	@Override
	public List<MembershipTiers> readAll() {
		return mtr.findAll();
	}
	@Override
	public void create(MembershipTiers t) {
		mtr.saveAndFlush(t);
	}
	@Override
	public void update(MembershipTiers t) {
		mtr.saveAndFlush(t);
	}
	@Override
	public void delete(int id) {
		mtr.deleteById(id);
	}
}
