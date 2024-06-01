package com.app.GroupMatching.repositories;

import com.app.GroupMatching.entities.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember,Long> {

}
