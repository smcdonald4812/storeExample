package com.mcdonald.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcdonald.models.MembershipTiers;
import com.mcdonald.repositories.MembershipTiersRepository;

@Service
public class MembershipTiersService{
	@Autowired
	MembershipTiersRepository mtr;
	public Optional<MembershipTiers> read(int id) {
		return mtr.findById(id);
	}
	public List<MembershipTiers> readAll() {
		return mtr.findAll();
	}
	public void create(MembershipTiers t) {
		mtr.saveAndFlush(t);
	}
	public void update(MembershipTiers t) {
		mtr.saveAndFlush(t);
	}
	public void delete(int id) {
		mtr.deleteById(id);
	}
}
