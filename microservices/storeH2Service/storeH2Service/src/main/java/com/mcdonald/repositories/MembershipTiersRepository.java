package com.mcdonald.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcdonald.models.MembershipTiers;

public interface MembershipTiersRepository extends JpaRepository<MembershipTiers, Integer> {
}
