package com.example.mongo;

import com.example.mongo.entity.Member;
import com.example.mongo.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
class MongoApplicationTests {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	@DisplayName("저장 테스트")
	public void saveMemberTest() {
		//given
		Member member = new Member();
		member.setName("andrew");
		member.setAge(32);
		memberRepository.save(member);

		// when
		Member retrivedMember = memberRepository.findById(member.getId()).get();

		// then
		assertThat(member.getId()).isEqualTo(retrivedMember.getId());
		assertThat(member.getAge()).isEqualTo(retrivedMember.getAge());
		}
}
